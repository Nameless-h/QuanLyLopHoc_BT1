/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseDTO;
import DTO.OnlineCourseDTO;
import DTO.OnsiteCourseDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class OnsiteCourseDAO {
    private DBConnection db;

    public OnsiteCourseDAO() {
        db = new DBConnection();
    }

    public ArrayList<OnsiteCourseDTO> getAllOnsiteCourse() {
        ArrayList<OnsiteCourseDTO> listTmp = new ArrayList<OnsiteCourseDTO>();
        String sql = "SELECT * FROM onsitecourse";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                OnsiteCourseDTO tmp;
                while (rs.next()) {
                    tmp = new OnsiteCourseDTO();
                    tmp.setCourseID(rs.getInt("courseID"));
                    tmp.setCourse_time(rs.getString("course_time"));
                    tmp.setDays(rs.getString("days"));
                    tmp.setLocation(rs.getString("location"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(OnsiteCourseDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(OnsiteCourseDTO c) {
    try {
        String sql = "INSERT INTO onsitecourse(courseID, location, days, course_time) VALUES (";
        sql += c.getCourseID() + ",";
        sql += "'" + c.getLocation() + "',";
        sql += "'" + c.getDays() + "',";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(c.getCourse_time());
        String courseTimeString = dateFormat.format(parsedDate);
        sql += "'" + courseTimeString + "')";

        db.executeUpdate(sql);
        return true;
    } catch (Exception e) {
        System.out.println("Error in file: OnsiteCourseDAO.java");
        System.out.println(e);
        return false;
    }
}

    public boolean Set(OnsiteCourseDTO c) {
        try {
            String sql = "UPDATE onsitecourse SET ";
            sql += "location = '" + c.getLocation() + "',";
            sql += "days = '" + c.getDays() + "',";

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(c.getCourse_time());
            String courseTimeString = dateFormat.format(parsedDate);

            sql += "course_time = '" + courseTimeString + "'";
            sql += " WHERE courseID = " + c.getCourseID();

            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Error in file: OnsiteCourseDAO.java");
            System.out.println(e);
            return false;
        }
    }
 
    
    
}
