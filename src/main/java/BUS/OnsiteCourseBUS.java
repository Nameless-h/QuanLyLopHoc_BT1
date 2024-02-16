package BUS;

import java.util.ArrayList;

import DAO.OnsiteCourseDAO;
import DTO.OnsiteCourseDTO;

public class OnsiteCourseBUS {
    private ArrayList<OnsiteCourseDTO> listOnsitecourse;

    public OnsiteCourseBUS() {
        ListOnsiteCourse();
    }

    public void ListOnsiteCourse() {
        OnsiteCourseDAO OnsitecourseDAO = new OnsiteCourseDAO();
        listOnsitecourse = new ArrayList<>();
        listOnsitecourse = OnsitecourseDAO.getAllOnsiteCourse();
    }

    public ArrayList<OnsiteCourseDTO> getList() {
        return this.listOnsitecourse;
    }

    public OnsiteCourseDTO GetOnsiteCourseById(int id) {
        for (OnsiteCourseDTO c : listOnsitecourse) {
            if (c.getCourseID() == id)
                return c;
        }
        return null;
    }

    public boolean AddOnsiteCourse(OnsiteCourseDTO c) {
        OnsiteCourseDAO OnsitecourseDAO = new OnsiteCourseDAO();
        if (OnsitecourseDAO.Add(c)) {
            this.listOnsitecourse.add(c);
            return true;
        }
        return false;
    }

    public boolean UpdateOnsiteCourse(OnsiteCourseDTO c) {
        for (int i = 0; i < this.listOnsitecourse.size(); i++) {
            if (this.listOnsitecourse.get(i).getCourseID() == c.getCourseID()) {
                OnsiteCourseDAO OnsitecourseDAO = new OnsiteCourseDAO();
                if (OnsitecourseDAO.Set(c)) {
                    this.listOnsitecourse.set(i, c);
                    return true;
                }
            }
        }
        return false;
    }
}
