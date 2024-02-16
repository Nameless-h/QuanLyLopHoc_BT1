/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseDTO;
import DTO.OfficeAssignmentDTO;
import DTO.OnlineCourseDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class OnlineCourseDAO {
    private DBConnection db;

    public OnlineCourseDAO() {
        db = new DBConnection();
    }

    public ArrayList<OnlineCourseDTO> getAllOnlineCourse() {
        ArrayList<OnlineCourseDTO> listTmp = new ArrayList<OnlineCourseDTO>();
        String sql = "SELECT * FROM onlinecourse";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                OnlineCourseDTO tmp;
                while (rs.next()) {
                    tmp = new OnlineCourseDTO();
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setUrl(rs.getString("url"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(OfficeAssignmentDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(OnlineCourseDTO c) {
        try {
            String sql = "INSERT INTO onlinecourse(courseID,url) VALUES (";
            sql += c.getCourseID() + ",'";
            sql += c.getUrl() + "')";
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: OnlineCourseDAO.java");
            System.out.println(e);
            return false;
        }
    }

    public boolean Set(OnlineCourseDTO c) {
        try {
            String sql = "UPDATE onblinecourse SET ";
            sql += "url = '" + c.getUrl() + "'";
            sql += " WHERE courseID = " + c.getCourseID();
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: OnlineCourseDAO.java");
            System.out.println(e);
            return false;
        }
    }
}
