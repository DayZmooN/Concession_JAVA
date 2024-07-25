package repository;

import Metier.Cars;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarsRepository {
    private DatabaseConnection databaseConnection;

    public CarsRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public void createCarsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Cars (" +
                "brand VARCHAR(255) NOT NULL, " +
                "model VARCHAR(255) NOT NULL)";

        try (Connection conn = databaseConnection.connection();
             PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Table Cars créée avec succès ou déjà existante.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la création de la table Cars.");
        }
    }

    public void insertCar(Cars car) {
        String insertSQL = "INSERT INTO Cars (brand, model) VALUES (?, ?)";

        try (Connection conn = databaseConnection.connection();
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.executeUpdate();
            System.out.println("Car ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'insertion de la voiture.");
        }
    }
}
