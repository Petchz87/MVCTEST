from Model.models import QueryEngine
from View.views import QueryView

class QueryController:
    def __init__(self):
        self.model = QueryEngine()
        self.view = QueryView()

    def process_query(self, query_language, script, output):
        result, execution_time = self.model.execute_query(
            query_language, script)
        if(output == '1'):
            self.view.display_result1(script, result, execution_time)
        else:
            self.view.display_result2(script, result, execution_time)


if __name__ == "__main__":
    controller = QueryController()
    query_language = input(
        "Choose a query language (SQL or MQL): ").strip().upper()
    query_script = input("Enter your script: ")
    query_output = input("Select output which you want(1 or 2): ")
    controller.process_query(query_language, query_script, query_output)
