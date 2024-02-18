package BUS;

import java.util.ArrayList;

import DAO.OnlineCourseDAO;
import DTO.OnlineCourseDTO;

public class OnlineCourseBUS {
    private ArrayList<OnlineCourseDTO> listOnlinecourse;

    public OnlineCourseBUS() {
        ListOnlineCourse();
    }

    public void ListOnlineCourse() {
        OnlineCourseDAO OnlinecourseDAO = new OnlineCourseDAO();
        listOnlinecourse = new ArrayList<>();
        listOnlinecourse = OnlinecourseDAO.getAllOnlineCourse();
    }

    public ArrayList<OnlineCourseDTO> getList() {
        return this.listOnlinecourse;
    }

    public OnlineCourseDTO GetOnlineCourseById(int id) {
        for (OnlineCourseDTO c : listOnlinecourse) {
            if (c.getCourseID() == id)
                return c;
        }
        return null;
    }

    public boolean AddOnlineCourse(OnlineCourseDTO c) {
        OnlineCourseDAO OnlinecourseDAO = new OnlineCourseDAO();
        if (OnlinecourseDAO.Add(c)) {
            this.listOnlinecourse.add(c);
            return true;
        }
        return false;
    }

    public boolean UpdateOnlineCourse(OnlineCourseDTO c) {
        for (int i = 0; i < this.listOnlinecourse.size(); i++) {
            if (this.listOnlinecourse.get(i).getCourseID() == c.getCourseID()) {
                OnlineCourseDAO OnlinecourseDAO = new OnlineCourseDAO();
                if (OnlinecourseDAO.Set(c)) {
                    this.listOnlinecourse.set(i, c);
                    return true;
                }
            }
        }
        return false;
    }
}
