/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseDTO;
import DTO.DepartmentDTO;
import DTO.OfficeAssignmentDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class OfficeAssignmentDAO {
    private DBConnection db;

    public OfficeAssignmentDAO() {
        db = new DBConnection();
    }

    public ArrayList<OfficeAssignmentDTO> getAllOfficeAssignment() {
        ArrayList<OfficeAssignmentDTO> listTmp = new ArrayList<OfficeAssignmentDTO>();
        String sql = "SELECT * FROM officeassignment";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                OfficeAssignmentDTO tmp;
                while (rs.next()) {
                    tmp = new OfficeAssignmentDTO();
                    tmp.setInstructorID(rs.getInt("instructorID "));
                    tmp.setLocation(rs.getString("location"));
                    tmp.setTime_stamp(rs.getTimestamp("time_stamp").toString());
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(OfficeAssignmentDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

    public boolean Add(OfficeAssignmentDTO o) {
        try {
            String sql = "INSERT INTO officeassignment(location,time_stamp) VALUES ('";
            sql += o.getLocation() + "',";
            sql += o.getTime_stamp() + ")";
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: OfficeAssignmentDAO.java");
            System.out.println(e);
            return false;
        }
    }

    public boolean Set(OfficeAssignmentDTO o) {
        try {
            String sql = "UPDATE officeassignment SET ";
            sql += "location = '" + o.getLocation() + "',";
            sql += "time_stamp = " + o.getTime_stamp();
            sql += " WHERE instructorID = " + o.getInstructorID();
            db.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in file: OfficeAssignmentDAO.java");
            System.out.println(e);
            return false;
        }
    }
}
