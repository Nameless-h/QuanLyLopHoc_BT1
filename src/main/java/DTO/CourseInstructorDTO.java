/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vi Hao
 */
public class CourseInstructorDTO {

    private int courseID;
    private int personID;

    public CourseInstructorDTO() {

        this.courseID = 0;
        this.personID = 0;
    }

    public CourseInstructorDTO(int courseID, int personID) {
        this.courseID = courseID;
        this.personID = personID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

}
