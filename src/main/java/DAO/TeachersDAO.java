package DAO;

import DBUtil.DBUtil;
import entity.Teachers;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by fowafolo on 15/4/29.
 */
public class TeachersDAO {

    public ArrayList<Teachers> getAllTeachers(){
        ArrayList<Teachers> list = new ArrayList<Teachers>();
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT * FROM Teachers";
        Connection connection = dbUtil.getCon();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs =  stmt.executeQuery(sql);
            while (rs.next()){
                Teachers teachers = new Teachers();
                teachers.setId(rs.getString("id"));
                teachers.setName(rs.getString("name"));
                teachers.setTitle(rs.getString("title"));
                teachers.setEmail(rs.getString("email"));
                list.add(teachers);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return list;
    }

    public ArrayList<Teachers> searchName(String name){

        ArrayList<Teachers> list = new ArrayList<Teachers>();
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT * FROM Teachers WHERE name=?";
        Connection connection = dbUtil.getCon();

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Teachers teachers = new Teachers();
                teachers.setId(rs.getString("id"));
                teachers.setName(rs.getString("name"));
                teachers.setTitle(rs.getString("title"));
                teachers.setEmail(rs.getString("email"));
                list.add(teachers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Teachers> findByTeacher(String name){
        ArrayList<Teachers> list = new ArrayList<Teachers>();
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT * FROM Teachers WHERE name LIKE ?";
        Connection connection = dbUtil.getCon();

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Teachers teachers = new Teachers();
                teachers.setId(rs.getString("id"));
                teachers.setName(rs.getString("name"));
                teachers.setTitle(rs.getString("title"));
                teachers.setEmail(rs.getString("email"));
                list.add(teachers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
