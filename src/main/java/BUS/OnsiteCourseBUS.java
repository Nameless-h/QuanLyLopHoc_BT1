package BUS;

import java.util.ArrayList;

import DAO.OnsiteCourseDAO;
import DTO.OnsiteCourseDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            if (c.getCourseID() == id) {
                return c;
            }
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

    public boolean validateData(OnsiteCourseDTO c) throws ParseException {
        if (c.getLocation().isEmpty() || c.getCourse_time().isEmpty() || c.getDays().isEmpty()) {
            return false;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(c.getCourse_time());
            return c.getCourse_time().equals(dateFormat.format(parsedDate));
        } catch (ParseException e) {
            return false;
        }
    }
}
