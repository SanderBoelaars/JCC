/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Sander
 */
public class DatabaseMediator {

    private Properties props;
    private Connection conn;

    public DatabaseMediator(Properties props) {
        this.props = props;

        try {
            initConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            this.props = null;
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Voorwerp> loadItems() throws IOException {
        return null;
    }

    public ArrayList<Set> loadSets() throws IOException {
        return null;
    }

    public void save(Administratie admin) throws IOException {
        try {
            initConnection();
            Statement myStmt = conn.createStatement();

            PreparedStatement psBierdop = conn.prepareStatement("INSERT INTO BIERDOP VALUES(?, ?, ?)");

            for (Set set : admin.getSets()) {
                for (Voorwerp vw : set.getVoorwerpen()) {
                    if (vw instanceof Bierdop) {
                        Bierdop b = (Bierdop) vw;
                        psBierdop.setString(1, b.getNaam());
                        psBierdop.setString(2, b.getMerk());
                        psBierdop.setString(3, set.getNaam());
                    }
                }
            }
            psBierdop.executeUpdate();

            PreparedStatement psPostzegel = conn.prepareStatement("INSERT INTO POSTZEGEL VALUES(?, ?, ?,)");
            for (Set set : admin.getSets()) {
                for (Voorwerp vw : set.getVoorwerpen()) {
                    if (vw instanceof Postzegel) {
                        Postzegel p = (Postzegel) vw;
                        psBierdop.setString(1, p.getNaam());
                        psBierdop.setInt(2, p.getLengte());
                        psBierdop.setInt(3, p.getBreedte());
                        psBierdop.setString(3, set.getNaam());
                    }
                }
            }
            psBierdop.executeUpdate();
            
            PreparedStatement psSet = conn.prepareStatement("INSERT INTO _SET VALUES(?, ?)");
             for (Set set : admin.getSets()) {
                 psSet.setString(1, set.getNaam());
                 psSet.setInt(2, set.getJaartal());
            }
             psSet.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void initConnection() throws SQLException {
        String driver = props.getProperty("driver");
        if (driver != null) {
            System.setProperty("jdbc.drivers", driver);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        conn = DriverManager.getConnection(url, username, password);
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
    }

    private void closeConnection() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
