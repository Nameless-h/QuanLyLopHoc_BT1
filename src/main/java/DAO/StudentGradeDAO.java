/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StudentGradeDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class StudentGradeDAO {
    private DBConnection db;

    public StudentGradeDAO() {
        db = new DBConnection();
    }

    public ArrayList<StudentGradeDTO> getAllStudentGrade() {
        ArrayList<StudentGradeDTO> listTmp = new ArrayList<StudentGradeDTO>();
        String sql = "SELECT * FROM studentgrade";
        try {
            ResultSet rs = db.executeQuery(sql);  
            StudentGradeDTO tmp;
                while (rs.next()) {
                    tmp = new StudentGradeDTO();
                    tmp.setEnrollmentID(rs.getInt("enrollmentID"));
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setGrade(rs.getFloat("grade"));
                    tmp.setStudentID(rs.getInt("studentID"));
                    listTmp.add(tmp);
                }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(StudentGradeDTO s) {
        try {
            String sql = "INSERT INTO studentgrade(courseID,studentID,grade) VALUES (";
            sql += s.getCourseID() + ",";
            sql += s.getStudentID() + ",";
            sql += s.getGrade() + ")";
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: StudentGradeDAO.java");
            System.out.println(e);
            return false;
        }
    }

    public boolean Set(StudentGradeDTO s) {
        try {
            String sql = "UPDATE studentgrade SET ";
            sql += "courseID = " + s.getCourseID() + ",";
            sql += "studentID = " + s.getStudentID() + ",";
            sql += "grade = " + s.getGrade();
            sql += " WHERE enrollmentID = " + s.getEnrollmentID();
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: StudentGradeDAO.java");
            System.out.println(e);
            return false;
        }
    }
}
