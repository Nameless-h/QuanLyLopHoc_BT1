package BUS;

import java.util.ArrayList;

import DAO.DepartmentDAO;
import DTO.DepartmentDTO;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

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
    
    public void LoadCourseToComboBox(JComboBox cb) {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        cb.setModel(dcm);
        dcm.addElement(new Object[]{0,"All"});
        for(DepartmentDTO d : this.listDepartment) {
            dcm.addElement(new Object[]{d.getDepartmentID(),d.getName()});
        }
        cb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null && value instanceof Object[]) {
                    value = ((Object[]) value)[1]; // Lấy giá trị (value) từ đối tượng mảng
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }
}
