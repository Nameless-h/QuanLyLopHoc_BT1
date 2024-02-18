/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseDTO;
import DTO.PersonDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class CourseDAO {
    private DBConnection db;

    public CourseDAO() {
        db = new DBConnection();
    }

    public ArrayList<CourseDTO> getAllCourse() {
        ArrayList<CourseDTO> listTmp = new ArrayList<CourseDTO>();
        String sql = "SELECT * FROM course";
        try {
            ResultSet rs = db.executeQuery(sql);
                CourseDTO tmp;
                while (rs.next()) {
                    tmp = new CourseDTO();
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setCredits(rs.getString("credits"));
                    tmp.setDepartmentID(rs.getInt("departmentID"));
                    tmp.setTitle(rs.getString("title"));
                    listTmp.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println("Error in file: CourseDAO.java");
            CustomLogger.CustomLogger(PersonDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(CourseDTO c) {
        try {
            String sql = "INSERT INTO course(title,credits,departmentID) VALUES ('";
            sql += c.getTitle() + "',";
            sql += c.getCredits() + ",";
            sql += c.getDepartmentID() + ")";
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: CourseDAO.java");
            System.out.println(e);
            return false;
        }
    }

    public boolean Set(CourseDTO c) {
        try {
            String sql = "UPDATE course SET ";
            sql += "title = '" + c.getTitle() + "',";
            sql += "credits = " + c.getCredits() + ",";
            sql += "departmentID = " + c.getDepartmentID();
            sql += " WHERE courseID = " + c.getCourseID();
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: CourseDAO.java");
            System.out.println(e);
            return false;
        }
    }
}
