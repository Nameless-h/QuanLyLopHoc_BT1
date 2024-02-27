/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vi Hao
 */
public class PersonDTO {

    private int personID;
    private String lastName;
    private String firstName;
    private String hireDate;
    private String enrollmentDate;

    public PersonDTO(int personID, String lastName, String firstName, String hireDate, String enrollmentDate) {
        this.personID = personID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.enrollmentDate = enrollmentDate;
    }
    public PersonDTO() {
        this.personID = 0;
        this.lastName = "";
        this.firstName = "";
        this.hireDate = "";
        this.enrollmentDate = "";
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

}
