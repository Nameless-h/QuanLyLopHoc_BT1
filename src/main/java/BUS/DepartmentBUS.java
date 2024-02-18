package BUS;

import java.util.ArrayList;

import DAO.DepartmentDAO;
import DTO.DepartmentDTO;

public class DepartmentBUS {
    private ArrayList<DepartmentDTO> listDepartment;

    public DepartmentBUS() {
        ListDepartment();
    }

    public void ListDepartment() {
        DepartmentDAO DepartmentDAO = new DepartmentDAO();
        listDepartment = new ArrayList<>();
        listDepartment = DepartmentDAO.getAllDepartment();
    }

    public ArrayList<DepartmentDTO> getList() {
        return this.listDepartment;
    }

    public DepartmentDTO GetDepartmentById(int id) {
        for (DepartmentDTO d : listDepartment) {
            if (d.getDepartmentID() == id)
                return d;
        }
        return null;
    }

    public boolean AddDepartment(DepartmentDTO d) {
        DepartmentDAO DepartmentDAO = new DepartmentDAO();
        if (DepartmentDAO.Add(d)) {
            this.listDepartment.add(d);
            return true;
        }
        return false;
    }

    public boolean UpdateDepartment(DepartmentDTO d) {
        for (int i = 0; i < this.listDepartment.size(); i++) {
            if (this.listDepartment.get(i).getDepartmentID() == d.getDepartmentID()) {
                DepartmentDAO DepartmentDAO = new DepartmentDAO();
                if (DepartmentDAO.Set(d)) {
                    this.listDepartment.set(i, d);
                    return true;
                }
            }
        }
        return false;
    }
}
