/*
    CLASS CONNECT TO DATABASE
 */
package Database;

import Utility.CustomLogger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Minh Minion
 */
public class DBConnection {

    private String user = "root";
    private String password = "";
    private String url = "jdbc:mySQL://localhost:3307/course_management";
    private Connection conn = null;


    public void Connect() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            CustomLogger.CustomLogger(DBConnection.class.getName(), ex.getMessage(), Level.SEVERE);
        }
    }

    public void disConnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            CustomLogger.CustomLogger(DBConnection.class.getName(), ex.getMessage(), Level.SEVERE);
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Connect();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            CustomLogger.CustomLogger(DBConnection.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return rs;
    }

    public void executeUpdate(String sql) {
        try {
            Connect();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            disConnect();
        } catch (SQLException ex) {
            CustomLogger.CustomLogger(DBConnection.class.getName(), ex.getMessage(), Level.SEVERE);
        }
    }

    public Connection getConnection() {
        Connect();
        return conn;
    }

    public boolean isConnect() {
        return conn != null;
    }
}
