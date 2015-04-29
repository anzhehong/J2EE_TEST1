package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fowafolo on 15/4/27.
 */
public class DBUtil {

    private final String url = "jdbc:mysql://localhost:3306/CourseDB?useUnicode=true&characterEncoding=UTF-8";
    private final  String DB_USER="root";
    private final String DB_PASSWORD="";
    private final String DB_DRIVER="com.mysql.jdbc.Driver";

    private Connection con;
    public DBUtil(){
        try {
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon(){
        return con;
    }
    public void closeCon(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBUtil util = new DBUtil();
        System.out.println(util.getCon());
    }

}
