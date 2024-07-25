package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Cars;
import database.DatabaseConnection;

public class Vehicule {
     DatabaseConnection databaseConnection;
     public Vehicule() {
         this.databaseConnection = new DatabaseConnection();
     }
    Cars cars = new Cars();
    public Vehicule(String model, String brand) {
        this.cars = new Cars();
    }

    public void createVehiculeTable() throws ClassNotFoundException {
        Connection conn = null;

        try {
            conn =  databaseConnection.connection();
            //System.out.println(conn);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Vehicule (" +
                    "brand VARCHAR(255) NOT NULL, " +
                    "model VARCHAR(255) NOT NULL)";


            // Préparer la déclaration SQL
            PreparedStatement stmt = conn.prepareStatement(createTableSQL);

            // Exécuter la déclaration
            stmt.execute();
            System.out.println("Table Vehicule créée avec succès ou déjà existante.");
            stmt.close();
            conn.close();
        }  catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la création de la table Vehicule.");
        }
    }


    public void listeVehicule() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = databaseConnection.connection();
            String listeSQL = "SELECT * FROM vehicule";
            stmt = conn.prepareStatement(listeSQL);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("Aucun véhicule n'existe !");
                return;
            }

            System.out.println("Liste des véhicules :");
            System.out.println("--------------------");
            while (rs.next()) {
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                System.out.println("Marque : " + brand + ", Modèle : " + model);
            }
            System.out.println("--------------------");

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage de la liste des véhicules : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }

    public void AddVehicule(Cars cars) {
         Connection conn = null;
         try{
             conn =  databaseConnection.connection();
             System.out.println(conn.toString());
             String insertSQL = "INSERT INTO vehicule (brand, model) VALUES (?, ?)";
             PreparedStatement stmt = conn.prepareStatement(insertSQL);
             stmt.setString(1, cars.getBrand());
             stmt.setString(2, cars.getModel());
             stmt.execute();
             stmt.close();
             conn.close();
         }catch (Exception e) {
             System.out.println(e.getMessage()+" "+ "Erreur de connexion ou ajout de vehicules.");
         }

    }

}
