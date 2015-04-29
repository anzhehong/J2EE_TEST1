package DAO;

import DBUtil.DBUtil;
import entity.TaughtCourses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by fowafolo on 15/4/29.
 */
public class TaughtCoursesDAO {

    public ArrayList<TaughtCourses> getAllTaughtCourses(){
        ArrayList<TaughtCourses>list = new ArrayList<TaughtCourses>();
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT * FROM TaughtCourses ORDER BY semester DESC";
        Connection connection = dbUtil.getCon();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                TaughtCourses taughtCourses = new TaughtCourses();
                taughtCourses.setTcid(rs.getInt("tcid"));
                taughtCourses.setCourse(rs.getString("course"));
                taughtCourses.setTid(rs.getString("tid"));
                taughtCourses.setClassid(rs.getString("classid"));
                taughtCourses.setSemester(rs.getInt("semester"));
                taughtCourses.setNumberOfStudents(rs.getInt("numberOfStudents"));
                list.add(taughtCourses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return list;
    }
}
