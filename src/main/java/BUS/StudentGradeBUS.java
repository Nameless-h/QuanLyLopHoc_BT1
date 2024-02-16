package BUS;

import java.util.ArrayList;

import DAO.StudentGradeDAO;
import DTO.StudentGradeDTO;

public class StudentGradeBUS {
    private ArrayList<StudentGradeDTO> listStudentGrade;

    public StudentGradeBUS() {
        ListStudentGrade();
    }

    public void ListStudentGrade() {
        StudentGradeDAO StudentGradeDAO = new StudentGradeDAO();
        listStudentGrade = new ArrayList<>();
        listStudentGrade = StudentGradeDAO.getAllStudentGrade();
    }

    public ArrayList<StudentGradeDTO> getList() {
        return this.listStudentGrade;
    }

    public StudentGradeDTO GetStudentGradeById(int id) {
        for (StudentGradeDTO s : listStudentGrade) {
            if (s.getEnrollmentID() == id)
                return s;
        }
        return null;
    }

    public boolean AddStudentGrade(StudentGradeDTO s) {
        StudentGradeDAO StudentGradeDAO = new StudentGradeDAO();
        if (StudentGradeDAO.Add(s)) {
            this.listStudentGrade.add(s);
            return true;
        }
        return false;
    }

    public boolean UpdateStudentGrade(StudentGradeDTO s) {
        for (int i = 0; i < this.listStudentGrade.size(); i++) {
            if (this.listStudentGrade.get(i).getEnrollmentID() == s.getEnrollmentID()) {
                StudentGradeDAO StudentGradeDAO = new StudentGradeDAO();
                if (StudentGradeDAO.Set(s)) {
                    this.listStudentGrade.set(i, s);
                    return true;
                }
            }
        }
        return false;
    }
}
