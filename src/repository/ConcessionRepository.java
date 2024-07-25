package repository;

import Metier.Concession;
import Metier.Cars;
import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcessionRepository {
    private DatabaseConnection databaseConnection;

    public ConcessionRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public void createConcessionTable() {
        try  {
            Connection conn = databaseConnection.connection();
            System.out.println("connecter");
            String sql = "CREATE TABLE IF NOT EXISTS Concession ( " +
                    " raisonSocial VARCHAR(255))";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("Table Concession créée avec succès");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la table Concession : " + e.getMessage());
        }
    }

    public void addConcession(Concession concession) {
        String sql = "INSERT INTO concession (raisonSocial) VALUES (?)";
        try  {
            Connection conn = databaseConnection.connection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, concession.getRaisonSocial());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la concession : " + e.getMessage());
        }
    }



    public void getAllConcessions() {
        List<Concession> concessions = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Concession";
            Connection conn = databaseConnection.connection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String raisonSocial = rs.getString("raisonSocial");
                System.out.println("raisonSocial : " + raisonSocial);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des concessions : " + e.getMessage());
        }
    }

    /*public void updateConcession(Concession concession) {
        String sql = "UPDATE Concession SET raisonSocial = ? WHERE id = ?";
        try (Connection conn = databaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, concession.getRaisonSocial());
            pstmt.setInt(2, concession.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de la concession : " + e.getMessage());
        }
    }

     */
    /*
    public void deleteConcession(int id) {
        String sql = "DELETE FROM Concession WHERE id = ?";
        try (Connection conn = databaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la concession : " + e.getMessage());
        }
    }

     */

}