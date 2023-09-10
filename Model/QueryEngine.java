package Model;

public class QueryEngine {
    private SQLExecutor sqlExecutor;
    private MQLExecutor mqlExecutor;

    public QueryEngine() {
        this.sqlExecutor = new SQLExecutor();
        this.mqlExecutor = new MQLExecutor();
    }

    public QueryResult executeQuery(String queryLanguage, String queryScript) {
        if (queryLanguage.equals("SQL")) {
            return this.sqlExecutor.execute(queryScript);
        } else if (queryLanguage.equals("MQL")) {
            return this.mqlExecutor.execute(queryScript);
        } else {
            return new QueryResult("Wrong Syntax!", 0);
        }
    }
}