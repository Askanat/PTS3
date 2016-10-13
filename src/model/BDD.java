package model;
import java.sql.*;
/**
 * Created by bastien on 12/10/16.
 */
public class BDD {

    public String pilote;

    public BDD() {
        pilote = "com.mysql.jdbc.Driver";
    }

    public ResultSet recupDonneeHero() {
        ResultSet result = null;
        return result;
    }
}
