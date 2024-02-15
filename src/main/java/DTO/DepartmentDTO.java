/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vi Hao
 */
public class DepartmentDTO {

    private int departmentID;
    private String name;
    private float budget;
    private String startDate;
    private int administrator;

    public DepartmentDTO() {
        this.departmentID = 0;
        this.name = "";
        this.budget = 0.0f;
        this.startDate = "";
        this.administrator=  0;
    }

    public DepartmentDTO(int departmentID, String name, float budget, String startDate, int administrator) {
        this.departmentID = departmentID;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAdminstrator() {
        return administrator;
    }

    public void setAdminstrator(int administrator) {
        this.administrator = administrator;
    }

}
