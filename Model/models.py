import time
import math

class QueryEngine:
    def __init__(self):
        self.sql_executor = SQLExecutor()
        self.mql_executor = MQLExecutor()

    def execute_query(self, query_language, query_script):
        if query_language == "SQL":
            result, execution_time = self.sql_executor.execute(query_script)
            return  result, math.ceil(execution_time)
        elif query_language == "MQL":
            result, execution_time = self.mql_executor.execute(query_script)
            return result, math.ceil(execution_time)
        else:
            return "Wrong Syntax!", 0

class SQLExecutor:
    def execute(self, query):
        start_time = time.time()
        query = query.strip()
        result = "0"

        if query.endswith(';') and query.startswith('SELECT'):
            temp = query[6:-1].split(" ")
            for i in range(len(temp)):
                if temp[i].isdigit():
                    result = str(int(result) + int(temp[i]))
            time.sleep(0.01)
            end_time = time.time()
            execution_time = (end_time - start_time) - 0.01
            # print("SQL Execution Time:", execution_time)  
            return result, execution_time * 1000
        else:
            return "Wrong Syntax!", 0
        


class MQLExecutor:
    def execute(self, query):
        start_time = time.time()
        query = query.strip()
        result = "0"

        if query.endswith(');') and query.startswith('print('):
            temp = query[6:-2].split(" ")
            for i in range(len(temp)):
                if temp[i].isdigit():
                    result = str(int(result) + int(temp[i]))
            time.sleep(0.01)
            end_time = time.time()
            execution_time = (end_time - start_time) - 0.01
            # print("SQL Execution Time:", execution_time)  
            return result, execution_time * 1000
        else:
            return "Wrong Syntax!", 0