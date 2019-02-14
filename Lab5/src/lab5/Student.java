/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author apple
 */
public class Student {

    //arguments: Name, Surname, Matriculation Number, Street, ZIP, City
    private String Name;
    private String Surname;
    private Integer MatriculationNumber;
    private String Street;
    private Integer ZIP;
    private String City;

    private Date date = new Date();

    //task2.a Constructors
    //automatically set an unique matriculateNumber
    public Student() {
        setMatriculationNumber(((int) date.getTime()) & 0x7fffffff);
    }

    //task2.a setters
    public void setName(String Name) {
        this.Name = Name;

    }

    public void setSurname(String Surname) {
        this.Surname = Surname;

    }

    public void setMatriculationNumber(int MatriculationNumber) {
        this.MatriculationNumber = MatriculationNumber;

    }

    public void setStreet(String Street) {
        this.Street = Street;

    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;

    }

    public void setCity(String City) {
        this.City = City;

    }
    
    //task2.a getters
    public String getName() {
        return this.Name ;

    }

    public String getSurname() {
        return this.Surname;

    }

    public int getMatriculationNumber() {
        return this.MatriculationNumber;

    }

    public String getStreet() {
        return this.Street;

    }

    public int getZIP() {
        return this.ZIP;

    }

    public String getCity() {
        return this.City;

    }
    
    //task2.b hashCode()
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + this.Name.hashCode();
        hash = 31 * hash + this.Surname.hashCode();
      //hash = 31 * hash + this.MatriculationNumber.hashCode();
        hash = 31 * hash + this.Street.hashCode();
        hash = 31 * hash + this.ZIP.hashCode();
        hash = 31 * hash + this.City.hashCode();
       
        return hash;
    }
    
    //task2.b equals()
    public boolean  equals(Student student)
    {
        return this.hashCode()==student.hashCode();
    }
    
}
