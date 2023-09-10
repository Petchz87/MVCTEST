package Model;

public class QueryResult {
    private String result;
    private double executionTime;

    public QueryResult(String result, double executionTime) {
        this.result = result;
        this.executionTime = executionTime;
    }

    public String getResult() {
        return result;
    }

    public double getExecutionTime() {
        return executionTime;
    }
}    

