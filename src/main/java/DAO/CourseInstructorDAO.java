/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseInstructorDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class CourseInstructorDAO {
    private DBConnection db;

    public CourseInstructorDAO() {
        db = new DBConnection();
    }

    public ArrayList<CourseInstructorDTO> getAllCourseInstructor() {
        ArrayList<CourseInstructorDTO> listTmp = new ArrayList<CourseInstructorDTO>();
        String sql = "SELECT * FROM courseinstructor";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                CourseInstructorDTO tmp;
                while (rs.next()) {
                    tmp = new CourseInstructorDTO();
                    tmp.setPersonID(rs.getInt("personID"));
                    tmp.setCourseID(rs.getInt("courseID"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(PersonDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(CourseInstructorDTO c) {
        try {
            String sql = "INSERT INTO courseinstructor(courseID,personID) VALUES (" + c.getCourseID() + ","
                    + c.getPersonID() + ")";
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: CourseInstructorDAO.java");
            System.out.println(e);
            return false;
        }
    }

    public boolean Delete(CourseInstructorDTO c) {
        try {
            String sql = "DELETE FROM courseinstructor WHERE courseID = " + c.getCourseID() + " AND personID = "
                    + c.getPersonID();
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: CourseInstructorDAO.java");
            System.out.println(e);
            return false;
        }
    }
}
