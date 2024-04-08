package fr.nassim.AccesBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccesBdd {

    private static Connection connection;

    public static void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/nassim-projet-ticket";
        String user = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void saveTicket(String libelle, String description, String criticite) {
        connectToDatabase(); // Connect to the database if not already connected
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ticket (tk_libelle, tk_description, fk_gravite) VALUES (?, ?, ?)");
            statement.setString(1, libelle);
            statement.setString(2, description);
            // For simplicity, we're assuming criticite levels correspond to fk_gravite values 1, 2, and 3.
            int fk_gravite = criticiteComboBox.getItems().indexOf(criticite) + 1;
            statement.setInt(3, fk_gravite);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
