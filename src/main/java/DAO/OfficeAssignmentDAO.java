/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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

    public OfficeAssignmentDAO(){
        db = new DBConnection();
    }
    
    public ArrayList<OfficeAssignmentDTO> getAllOfficeAssignment(){
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
}
