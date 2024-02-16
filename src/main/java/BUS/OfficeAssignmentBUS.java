package BUS;

import java.util.ArrayList;

import DAO.OfficeAssignmentDAO;
import DTO.OfficeAssignmentDTO;

public class OfficeAssignmentBUS {
    private ArrayList<OfficeAssignmentDTO> listOfficeAssignment;

    public OfficeAssignmentBUS() {
        ListOfficeAssignment();
    }

    public void ListOfficeAssignment() {
        OfficeAssignmentDAO OfficeAssignmentDAO = new OfficeAssignmentDAO();
        listOfficeAssignment = new ArrayList<>();
        listOfficeAssignment = OfficeAssignmentDAO.getAllOfficeAssignment();
    }

    public ArrayList<OfficeAssignmentDTO> getList() {
        return this.listOfficeAssignment;
    }

    public OfficeAssignmentDTO GetOfficeAssignmentById(int id) {
        for (OfficeAssignmentDTO o : listOfficeAssignment) {
            if (o.getInstructorID() == id)
                return o;
        }
        return null;
    }

    public boolean AddOfficeAssignment(OfficeAssignmentDTO o) {
        OfficeAssignmentDAO OfficeAssignmentDAO = new OfficeAssignmentDAO();
        if (OfficeAssignmentDAO.Add(o)) {
            this.listOfficeAssignment.add(o);
            return true;
        }
        return false;
    }

    public boolean UpdateOfficeAssignment(OfficeAssignmentDTO o) {
        for (int i = 0; i < this.listOfficeAssignment.size(); i++) {
            if (this.listOfficeAssignment.get(i).getInstructorID() == o.getInstructorID()) {
                OfficeAssignmentDAO OfficeAssignmentDAO = new OfficeAssignmentDAO();
                if (OfficeAssignmentDAO.Set(o)) {
                    this.listOfficeAssignment.set(i, o);
                    return true;
                }
            }
        }
        return false;
    }
}
