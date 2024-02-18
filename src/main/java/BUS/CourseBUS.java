package BUS;

import java.util.ArrayList;

import DAO.CourseDAO;
import DTO.CourseDTO;

public class CourseBUS {
    private ArrayList<CourseDTO> listcourse;

    public CourseBUS() {
        ListCourse();
    }

    public void ListCourse() {
        CourseDAO courseDAO = new CourseDAO();
        listcourse = new ArrayList<>();
        listcourse = courseDAO.getAllCourse();
    }

    public ArrayList<CourseDTO> getList() {
        return this.listcourse;
    }

    public CourseDTO GetCourseById(int id) {
        for (CourseDTO c : listcourse) {
            if (c.getCourseID() == id)
                return c;
        }
        return null;
    }
    
    public void GetCourseBySearch(String input) {
        CourseDAO courseDAO = new CourseDAO();
        listcourse = courseDAO.getAllCourseBySearch(input);
    }

    public boolean AddCourse(CourseDTO c) {
        CourseDAO courseDAO = new CourseDAO();
        if (courseDAO.Add(c)) {
            this.listcourse.add(c);
            return true;
        }
        return false;
    }

    public boolean UpdateCourse(CourseDTO c) {
        for (int i = 0; i < this.listcourse.size(); i++) {
            if (this.listcourse.get(i).getCourseID() == c.getCourseID()) {
                CourseDAO courseDAO = new CourseDAO();
                if (courseDAO.Set(c)) {
                    this.listcourse.set(i, c);
                    return true;
                }
            }
        }
        return false;
    }
}
