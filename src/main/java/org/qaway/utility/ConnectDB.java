package org.qaway.utility;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {

    // pour lire dans une base de données, on a besoin d'une dependency "mysql"
    MongoDatabase mongoDatabase = null;
    public static Connection connection = null; // objet de la connexion
    Statement statement = null;
    ResultSet resultSet = null;

    public ConnectDB() throws ClassNotFoundException {
    }

    public static Connection connectToMySql() throws SQLException {
        Properties prop = Utility.loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver"); // driver c'est une propertie de mysql,
        // pour donner son existance pour mysql je dois lui donner le nom "driver Class
        String url = prop.getProperty("MYSQLJDBC.url");
        String username = "root";
        String password = "abc123";

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url, username, password); // récupérer DriverManager...
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("database is connected");
        return connection;
    }

        // avant que j'utilise ma base de données faut que je la démmare sur términal
        /*
        mysql.server start
        mysql -u root –p
        show databases
        uqe myDB
        show tables
        select * from crad

         */

    public MongoDatabase connectToMongoDB(String dbName) { // MongoDtabase elle n'a pas besoin de paramètres
        MongoClient mongoClient = new MongoClient();
        mongoDatabase = mongoClient.getDatabase(dbName);
        System.out.println("Database Connected");
        return mongoDatabase;
    }

    public List<String> getTableColumnData(String query, String columnName) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        try {
            statement = connectToMySql().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                list.add(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static String getUsernameFromDB() throws ClassNotFoundException {
        Statement statement;
        ResultSet resultSet;
        String username = "", query = "select username from Users;";
        try {
            statement = ConnectDB.connectToMySql().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                username = resultSet.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return username;
    }

    public static String getPasswordFromDB() throws ClassNotFoundException {
        Statement statement;
        ResultSet resultSet;
        String password = "", query = "select password from Users;";
        try {
            statement = ConnectDB.connectToMySql().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;

    }

}
