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
import java.util.ArrayList;
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


}
