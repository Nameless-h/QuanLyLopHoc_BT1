/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vi Hao
 */
public class OfficeAssignmentDTO {

    private int instructorID;
    private String location;
    private String time_stamp;

    public OfficeAssignmentDTO() {
        this.instructorID = 0;
        this.location = "";
        this.time_stamp = "";
    }

    public OfficeAssignmentDTO(int instructorID, String location, String time_stamp) {
        this.instructorID = instructorID;
        this.location = location;
        this.time_stamp = time_stamp;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

}
