package Model;

public class SQLExecutor {
    public QueryResult execute(String query) {
        long startTime = System.currentTimeMillis();

        query = query.trim();
        String result = "0";

        if (query.endsWith(";") && query.startsWith("SELECT")) {
            String[] temp = query.substring(6, query.length() - 1).split(" ");
            for (String s : temp) {
                if (s.matches("\\d+")) {
                    result = String.valueOf(Integer.parseInt(result) + Integer.parseInt(s));
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long endTime = System.currentTimeMillis();
            double executionTime = (endTime - startTime) - 10.0;
            return new QueryResult(result, executionTime);
        } else {
            return new QueryResult("Wrong Syntax!", 0);
        }
    }
}