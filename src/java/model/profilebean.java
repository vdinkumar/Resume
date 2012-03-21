/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;



/**
 *
 * @author Administrator
 */
public class profilebean {

    String Name;
    String DOB;
    String Address;
    String Mobile;
    String Email;
     int Specialization_id;
    int Work_experience;
    String resume;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
   
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getSpecialization_id() {
        return Specialization_id;
    }

    public void setSpecialization_id(int Specialization_id) {
        this.Specialization_id = Specialization_id;
    }

    public int getWork_experience() {
        return Work_experience;
    }

    public void setWork_experience(int Work_experience) {
        this.Work_experience = Work_experience;
    }


}
