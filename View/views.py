import json

class QueryView:
    def display_result1(self, script, result, execution_time):
        if result == "Wrong Syntax!":
            print("Wrong Syntax!")
        else:
            print(f"Query: {script}\nResult: {result}\nQuery Execution Time: {execution_time} ms")

    def display_result2(self, script, result, execution_time):
        if result == "Wrong Syntax!":
            output = {"status": "false"}
        else:
            output = {"status": "true","query": script,"result": result,"execution_time": execution_time}
        print(json.dumps(output, indent=4))