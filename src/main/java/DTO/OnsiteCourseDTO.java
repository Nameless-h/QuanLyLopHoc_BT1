/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vi Hao
 */
public class OnsiteCourseDTO {
    private int courseID ;
    private String location;
    private String days;
    private String course_time;

    public OnsiteCourseDTO(int courseID, String location, String days, String course_time) {
        this.courseID = courseID;
        this.location = location;
        this.days = days;
        this.course_time = course_time;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }
    
    
}
