package BUS;

import java.util.ArrayList;

import DAO.CourseInstructorDAO;
import DTO.CourseInstructorDTO;

public class CourseInstructorBUS {
    private ArrayList<CourseInstructorDTO> listcourseInstructor;

    public CourseInstructorBUS() {
        ListCourseInstructor();
    }

    public void ListCourseInstructor() {
        CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
        listcourseInstructor = new ArrayList<>();
        listcourseInstructor = courseInstructorDAO.getAllCourseInstructor();
    }

    public ArrayList<CourseInstructorDTO> getList() {
        return this.listcourseInstructor;
    }
    
    public boolean AddCourseInstructor(CourseInstructorDTO c) {
        CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
        if (courseInstructorDAO.Add(c)) {
            this.listcourseInstructor.add(c);
            return true;
        }
        return false;
    }

    public boolean DeleteCourseInstructor(CourseInstructorDTO c) {
        for (CourseInstructorDTO tmp : this.listcourseInstructor) {
            if (tmp.getCourseID() == c.getCourseID() && tmp.getPersonID() == c.getPersonID()) {
                CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
                if (courseInstructorDAO.Delete(tmp)) {
                    this.listcourseInstructor.remove(tmp);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean CheckExistCourseInstructor(int cID,int pID) {
        for(CourseInstructorDTO c : this.listcourseInstructor) {
            if(c.getCourseID() == cID && c.getPersonID() == pID)
                return true;
        }
        return false;
    }
}
