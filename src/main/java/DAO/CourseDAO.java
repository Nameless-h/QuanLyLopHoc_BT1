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
    
    public ArrayList<CourseDTO> getAllCourse(){
        ArrayList<CourseDTO> listTmp = new ArrayList<CourseDTO>();
        String sql = "SELECT * FROM course";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                CourseDTO tmp;
                while (rs.next()) {
                    tmp = new CourseDTO();
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setCredits(rs.getString("credits"));
                    tmp.setDepartmentID(rs.getInt("departmentID "));
                    tmp.setTitle(rs.getString("title"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(PersonDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

}
