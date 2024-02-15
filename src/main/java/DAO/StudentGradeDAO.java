/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.OnlineCourseDTO;
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

    public StudentGradeDAO(){
        db = new DBConnection();
    }
    
    public ArrayList<StudentGradeDTO> getAllStudentGrade(){
        ArrayList<StudentGradeDTO> listTmp = new ArrayList<StudentGradeDTO>();
        String sql = "SELECT * FROM studentgrade";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                StudentGradeDTO tmp;
                while (rs.next()) {
                    tmp = new StudentGradeDTO();
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setEnrollmentID(rs.getInt("enrollmentID"));
                    tmp.setGrade(rs.getFloat("grade"));
                    tmp.setStudentID(rs.getInt("studentID"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }
}
