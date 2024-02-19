/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.CourseBUS;
import BUS.CourseInstructorBUS;
import BUS.PersonBUS;
import DTO.CourseInstructorDTO;
import GUI.CourseInstructor.AddInstructorForm;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vi Hao
 */
public class MainForm extends javax.swing.JFrame {

    private CourseInstructorBUS cour_instrucBUS;
    private CourseBUS courseBUS;
    private PersonBUS personBUS;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        FlatMacLightLaf.setup();
        initComponents();
        runMain();
        cour_instrucBUS = new CourseInstructorBUS();
        courseBUS = new CourseBUS();
        personBUS = new PersonBUS();
        loadDataIntoTableModel();
    }

    public void addPlaceHolderStyle(JTextField jtf) {
        Font f = jtf.getFont();
        f = f.deriveFont(Font.ITALIC);
        jtf.setFont(f);
        jtf.setForeground(Color.gray);
    }

    public void removePlaceHolderStyle(JTextField jtf) {
        Font f = jtf.getFont();
        f = f.deriveFont(Font.PLAIN | Font.BOLD);
        jtf.setFont(f);
        jtf.setForeground(Color.black);
    }

    public void loadDataIntoTableModel() {
        System.out.println("GUI.MainForm.loadDataIntoTableModel()");
        this.cour_instrucBUS.ListCourseInstructor();
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);
        ArrayList<CourseInstructorDTO> listCourse = cour_instrucBUS.getList();
        for (CourseInstructorDTO tmp : listCourse) {
            model.addRow(new Object[] { tmp.getCourseID(), courseBUS.GetCourseById(tmp.getCourseID()).getTitle(),
                    tmp.getPersonID(), personBUS.GetPersonById(tmp.getPersonID()).getFirstName() + " "
                            + personBUS.GetPersonById(tmp.getPersonID()).getLastName() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainTbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mainTbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTbl = new javax.swing.JTable();
        information_panel = new javax.swing.JPanel();
        txtInstructID = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtIntructName = new javax.swing.JTextField();
        txtCourseID = new javax.swing.JTextField();
        txtCredit = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jtf_search = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        mainTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Course name", "Instructor ID", "Instructor name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mainTbl.setColumnSelectionAllowed(true);
        mainTbl.setCellSelectionEnabled(false);
        mainTbl.setRowSelectionAllowed(true);
        mainTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTblClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainTbl);
        mainTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (mainTbl.getColumnModel().getColumnCount() > 0) {
            mainTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
            mainTbl.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        information_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        information_panel.setName(""); // NOI18N

        txtInstructID.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructor ID"));

        txtCourseName.setBorder(javax.swing.BorderFactory.createTitledBorder("Course name"));
        txtCourseName.setPreferredSize(new java.awt.Dimension(69, 40));

        txtIntructName.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructor name"));
        txtIntructName.setPreferredSize(new java.awt.Dimension(69, 40));

        txtCourseID.setBorder(javax.swing.BorderFactory.createTitledBorder("Course ID"));

        txtCredit.setBorder(javax.swing.BorderFactory.createTitledBorder("Credit"));

        javax.swing.GroupLayout information_panelLayout = new javax.swing.GroupLayout(information_panel);
        information_panel.setLayout(information_panelLayout);
        information_panelLayout.setHorizontalGroup(
            information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(information_panelLayout.createSequentialGroup()
                        .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCourseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIntructName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstructID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        information_panelLayout.setVerticalGroup(
            information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstructID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(information_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIntructName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        information_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCourseName, txtIntructName});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jtf_search.setText("Search by ID/name");
        jtf_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_searchFocusLost(evt);
            }
        });
        jtf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_searchActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setLabel("Edit");

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setLabel("Add");
        addBtn.setName(""); // NOI18N
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delBtn.setLabel("Delete");
        delBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editBtn)
                .addGap(5, 5, 5)
                .addComponent(addBtn)
                .addGap(5, 5, 5)
                .addComponent(delBtn)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn)
                    .addComponent(addBtn)
                    .addComponent(delBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editBtn, jtf_search});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(information_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(information_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý phân công", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-assignment-48.png")), jPanel3, "Quản lý phân công"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý kết quả", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-grade-48.png")), jPanel2, "Quản lý kết quả"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý khóa học", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-course-48.png")), jPanel1, "Quản lý khóa học"); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        AddInstructorForm frm = new AddInstructorForm(this);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {

            };
        });
        
    }// GEN-LAST:event_addBtnActionPerformed

    private void mainTblClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_mainTblClicked
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        int selectedRow = mainTbl.getSelectedRow();

        // Check if a valid cell is clicked
        if (selectedRow != -1) {
            Object courseID = model.getValueAt(selectedRow, 0);
            Object courseName = model.getValueAt(selectedRow, 1);
            Object personID = model.getValueAt(selectedRow, 2);
            Object personName = model.getValueAt(selectedRow, 3);

            txtCourseID.setText(courseID.toString());
            txtCourseName.setText(courseName.toString());
            txtCredit.setText(courseBUS.GetCourseById((int) courseID).getCredits());
            txtInstructID.setText(personID.toString());
            txtIntructName.setText(personName.toString());
        }
    }// GEN-LAST:event_mainTblClicked

    private void jtf_searchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtf_searchActionPerformed
        // TODO add your handling code here:
        String input = jtf_search.getText().toLowerCase().trim();
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);
        // You can replace this with actual data loading logic from a database or
        // another source
        ArrayList<CourseInstructorDTO> listCourse = cour_instrucBUS.getList();
        for (CourseInstructorDTO tmp : listCourse) {
            String course_title = courseBUS.GetCourseById(tmp.getCourseID()).getTitle();
            String person_name = personBUS.GetPersonById(tmp.getPersonID()).getFirstName() + " "
                    + personBUS.GetPersonById(tmp.getPersonID()).getLastName();
            String course_id = Integer.toString(tmp.getCourseID());
            String person_id = Integer.toString(tmp.getPersonID());

            if (course_title.toLowerCase().contains(input) ||
                    person_name.toLowerCase().contains(input) ||
                    course_id.contains(input) ||
                    person_id.contains(input)) {
                model.addRow(new Object[] { tmp.getCourseID(), course_title, tmp.getPersonID(), person_name });
            }
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainTbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mainTbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        System.out.println(input);
    }// GEN-LAST:event_jtf_searchActionPerformed

    private void jtf_searchFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jtf_searchFocusGained
        // TODO add your handling code here:
        if (jtf_search.getText().equals("Search by ID/name")) {
            jtf_search.setText(null);
            jtf_search.requestFocus();
            removePlaceHolderStyle(jtf_search);
        }
    }// GEN-LAST:event_jtf_searchFocusGained

    private void jtf_searchFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jtf_searchFocusLost
        // TODO add your handling code here:
        if (jtf_search.getText().length() == 0) {
            addPlaceHolderStyle(jtf_search);
            jtf_search.setText("Search by ID/name");
        }
    }// GEN-LAST:event_jtf_searchFocusLost

    private void delBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_delBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        int selectedRow = mainTbl.getSelectedRow();

        // Check if a valid cell is clicked
        if (selectedRow != -1) {
            mainTbl.setRowSelectionInterval(selectedRow, selectedRow);
            Object courseID = model.getValueAt(selectedRow, 0);
            Object courseName = model.getValueAt(selectedRow, 1);
            Object personID = model.getValueAt(selectedRow, 2);
            Object personName = model.getValueAt(selectedRow, 3);

            int res = JOptionPane.showConfirmDialog(null, "Are you sure want to continue", "Delete confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (res != 0) {
                return;
            }

            CourseInstructorDTO ciDTO = new CourseInstructorDTO((int) courseID, (int) personID);
            cour_instrucBUS.DeleteCourseInstructor(ciDTO);
            loadDataIntoTableModel();
            System.out.println(courseID);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row in table to delete");
        }
    }// GEN-LAST:event_delBtnMouseClicked

    private String string;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new FlatMacLightLaf());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInstructorForm.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    public void runMain() {
        setTitle("testing");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        addPlaceHolderStyle(jtf_search);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel information_panel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jtf_search;
    private javax.swing.JTable mainTbl;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JTextField txtInstructID;
    private javax.swing.JTextField txtIntructName;
    // End of variables declaration//GEN-END:variables
}
