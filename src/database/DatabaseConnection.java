package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String DB_NAME = "concession_db";
    private static final String UTF8 = "?characterEncoding=utf8";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String USER = "root";
    private static final String PASSWD = "";
    private static final String URLCREATEDB = "jdbc:mysql://localhost:3306/";


    public DatabaseConnection() {
    }

    public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL  + UTF8, USER, PASSWD);
            System.out.println("Connecté à la base de données : " + DB_NAME);
            return conn;

        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage() + "\nURL : " + URL + DB_NAME + UTF8);
        }
        return null;
    }

    public void createDatabase() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URLCREATEDB+UTF8, USER, PASSWD);
            String createDb = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            PreparedStatement stmt = conn.prepareStatement(createDb);
            stmt.execute();
            stmt.close();
            conn.close();
            System.out.println("Base de données créée avec succès ou déjà existante : " + DB_NAME);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la création de la base de données.");
        }
    }


}
