package BUS;

import DTO.PersonDTO;
import java.util.ArrayList;

import DAO.PersonDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vi Hao
 */
public class PersonBUS {
    private ArrayList<PersonDTO> listps;

    public PersonBUS() {
        ListPerson();
    }

    public void ListPerson() {
        PersonDAO psDAO = new PersonDAO();
        listps = new ArrayList<>();
        listps = psDAO.getAllPerson();
    }

    public ArrayList<PersonDTO> getList() {
        return this.listps;
    }

    public PersonDTO GetPersonById(int id) {
        for (PersonDTO ps : this.listps) {
            if (ps.getPersonID() == id)
                return ps;
        }
        return null;
    }
    
    public void GetPersonBySearch(String input) {
         PersonDAO psDAO = new PersonDAO();
        listps = psDAO.getAllPersonBySearch(input);
    }

    public boolean AddPerson(PersonDTO ps) {
        PersonDAO psDAO = new PersonDAO();
        if (psDAO.Add(ps)) {
            this.listps.add(ps);
            return true;
        }
        return false;
    }

    public boolean UpdatePerson(PersonDTO ps) {
        for (int i = 0; i < this.listps.size(); i++) {
            if (this.listps.get(i).getPersonID() == ps.getPersonID()) {
                PersonDAO psDAO = new PersonDAO();
                if (psDAO.Set(ps)) {
                    this.listps.set(i, ps);
                    return true;
                }
            }
        }
        return false;
    }

}
