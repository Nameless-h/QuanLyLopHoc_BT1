/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseInstructorDTO;
import DTO.DepartmentDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JN_PC
 */
public class DepartmentDAO {
    private DBConnection db;

    public DepartmentDAO() {
        db = new DBConnection();
    }

    public ArrayList<DepartmentDTO> getAllDepartment() {
        ArrayList<DepartmentDTO> listTmp = new ArrayList<DepartmentDTO>();
        String sql = "SELECT * FROM department";
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                DepartmentDTO tmp;
                while (rs.next()) {
                    tmp = new DepartmentDTO();
                    tmp.setDepartmentID(rs.getInt("departmentID"));
                    tmp.setName(rs.getString("name"));
                    tmp.setBudget(rs.getFloat("budget"));
                    tmp.setStartDate(rs.getString("startDate"));
                    tmp.setAdminstrator(rs.getInt("adminstrator"));
                    listTmp.add(tmp);
                }
            }
        } catch (Exception ex) {
            CustomLogger.CustomLogger(DepartmentDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
        return listTmp;
    }

}
