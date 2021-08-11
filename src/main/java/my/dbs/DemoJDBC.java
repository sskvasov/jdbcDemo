package my.dbs;

import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks",
                "northwind", "northwind");
        String sql = "SELECT ProductID, Name, ProductNumber, ListPrice FROM Production.Product ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name") + " " + resultSet.getDouble("ListPrice"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
