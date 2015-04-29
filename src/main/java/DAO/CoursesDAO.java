package DAO;

import DBUtil.DBUtil;
import entity.Courses;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by fowafolo on 15/4/29.
 */
public class CoursesDAO {

    public ArrayList<Courses> getAllCourses(){
        ArrayList <Courses> list = new ArrayList<Courses>();
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getCon();
        String sql = "SELECT * FROM Courses";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Courses courses = new Courses();
                courses.setName(rs.getString("name"));
                courses.setCode(rs.getString("code"));
                courses.setDescription(rs.getString("description"));
                list.add(courses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public ArrayList<Courses> searchName(String name){
        ArrayList <Courses> list = new ArrayList<Courses>();
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getCon();
        String sql = "SELECT * FROM Courses WHERE name=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Courses courses = new Courses();
                courses.setName(rs.getString("name"));
                courses.setCode(rs.getString("code"));
                courses.setDescription(rs.getString("description"));
                list.add(courses);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Courses> findByCourse(String name){
        ArrayList <Courses> list = new ArrayList<Courses>();
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getCon();
        String sql = "SELECT * FROM Courses WHERE name LIKE ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Courses courses = new Courses();
                courses.setName(rs.getString("name"));
                courses.setCode(rs.getString("code"));
                courses.setDescription(rs.getString("description"));
                list.add(courses);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
