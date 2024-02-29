/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StudentGradeDTO;
import Database.DBConnection;
import Utility.CustomLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import DAO.StudentGradeDAO;

/**
 *
 * @author JN_PC
 */
public class StudentGradeDAO {
    private DBConnection db;
    private Connection connection;

    public StudentGradeDAO() {
        db = new DBConnection();
         try {
            // Tạo kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/course_management", "root", "");
        } catch (SQLException ex) {
            // Xử lý lỗi kết nối
            CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
        }
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
    
    public boolean Delete(int enrollmentID) {
    try {
        String sql = "DELETE FROM studentgrade WHERE enrollmentID = " + enrollmentID;
        db.executeUpdate(sql);
        return true;
    } catch (Exception e) {
        System.out.println("Error in file: StudentGradeDAO.java");
        System.out.println(e);
        return false;
    }
}
    
    public StudentGradeDTO getStudentGradeByEnrollmentID(int enrollmentID) {
        StudentGradeDTO studentGrade = null;
        String sql = "SELECT * FROM studentgrade WHERE enrollmentID = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, enrollmentID);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            studentGrade = new StudentGradeDTO();
            studentGrade.setEnrollmentID(rs.getInt("enrollmentID"));
            studentGrade.setCourseID(rs.getInt("courseID"));
            studentGrade.setGrade(rs.getFloat("grade"));
            studentGrade.setStudentID(rs.getInt("studentID"));
        }
    } catch (SQLException ex) {
        CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
    }
    return studentGrade; 
}
    
    public StudentGradeDTO getStudentGradeByStudentID(int studentID) {
    StudentGradeDTO studentGrade = null;
    String sql = "SELECT * FROM studentgrade WHERE studentID = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, studentID);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            studentGrade = new StudentGradeDTO();
            studentGrade.setEnrollmentID(rs.getInt("enrollmentID"));
            studentGrade.setCourseID(rs.getInt("courseID"));
            studentGrade.setGrade(rs.getFloat("grade"));
            studentGrade.setStudentID(rs.getInt("studentID"));
        }
    } catch (SQLException ex) {
        CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
    }
    return studentGrade; 
}
    public ArrayList<StudentGradeDTO> getStudentGradesByStudentID(int studentID) {
        ArrayList<StudentGradeDTO> studentGrades = new ArrayList<>();
        String sql = "SELECT * FROM studentgrade WHERE studentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentID);
            ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            StudentGradeDTO studentGrade = new StudentGradeDTO();
            studentGrade.setEnrollmentID(rs.getInt("enrollmentID"));
            studentGrade.setCourseID(rs.getInt("courseID"));
            studentGrade.setGrade(rs.getFloat("grade"));
            studentGrade.setStudentID(rs.getInt("studentID"));
            studentGrades.add(studentGrade);
        }
    } catch (SQLException ex) {
        CustomLogger.CustomLogger(StudentGradeDAO.class.getName(), ex.getMessage(), Level.SEVERE);
    }
    return studentGrades; 
}

    
//    public static void main(String[] args) {
//     StudentGradeDAO dao = new StudentGradeDAO(); // Điều chỉnh để tạo đối tượng DAO phù hợp với ứng dụng của bạn
//        StudentGradeDTO studentGrade = new StudentGradeDTO();
//        // Thiết lập các giá trị cho đối tượng StudentGradeDTO
//        studentGrade.setEnrollmentID(16); // Giá trị tùy chọn
//        studentGrade.setCourseID(4); // Giá trị tùy chọn
//        studentGrade.setStudentID(5); // Giá trị tùy chọn
//        studentGrade.setGrade(9); // Giá trị tùy chọn
//
//        // Thử gọi phương thức Set
//        boolean success = dao.Set(studentGrade);
//        if (success) {
//            System.out.println("Set successful.");
//        } else {
//            System.out.println("Set failed.");
//        }
//}
    
  
}
