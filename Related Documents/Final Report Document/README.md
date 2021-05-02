# Note:
For our project, we have implemented the idea as shown in the above architecture or Kylin workflow where we first fetch the data from sensor through our python script. We then take the CSV file or SQL file into Hive (Hadoop) and we can see how many rows are there. After this we have our Kylin server in localhost which we must sync with model and build cube or refresh if we have previous one which are saved in HBase. Now comes our how our data are visualized, there are two ways as follows:

1. BI tools: Tableau
For this we have to connect Kylin and tableau with JDBC/ODBC driver.
2. Third Party App
For this we have to use REST API to connect.

For our project, we have used both ways since we had some problem with Tableau and Kylin getting to connect since JDBC driver were not compatible and for ODBC we had to contact vendor. Now, we have implemented the REST API to connect and get the required data.

># System Workflow Diagram

![alt](./image/Application%20Processing%20Diagram.png)

># System Architecture Diagram

![alt](./image/system%20architecture%20diagram.jpg)
