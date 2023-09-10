package Controller;

import Model.QueryEngine;
import Model.QueryResult;
import View.QueryView;

public class QueryController {
    private QueryEngine model;
    private QueryView view;

    public QueryController(QueryEngine model, QueryView view) {
        this.model = model;
        this.view = view;
    }

    public String displayResult1(String script, QueryResult result) {
        if (result.getResult().equals("Wrong Syntax!")) {
            return "Wrong Syntax!";
        } else {
            return "Query: " + script + "\nResult: " + result.getResult() + "\nQuery Execution Time: "
                    + result.getExecutionTime() + " ms";
        }
    }

    public String displayResult2(String script, QueryResult result) {
        if (result.getResult().equals("Wrong Syntax!")) {
            return "{\"status\": \"false\"}";
        } else {
            return "{\"status\": \"true\", \"query\": \"" + script + "\", \"result\": \"" + result.getResult()
                    + "\", \"execution_time\": " + result.getExecutionTime() + "}";
        }
    }

    public void executeQuery(String queryLanguage, String queryScript, String queryOutput) {
        QueryResult result = model.executeQuery(queryLanguage, queryScript);
        String resultText;
    
        if (queryOutput.equals("1")) {
            resultText = displayResult1(queryScript, result);
        } else {
            resultText = displayResult2(queryScript, result);
        }
    
        // Set the result text in the view
        view.setResultText(resultText);
    }
}
