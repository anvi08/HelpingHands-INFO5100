/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package profile.donor;

import utilities.DbConnection;

/**
 *
 * @author abhis
 */
public class DonorDirectory {
    private Donor donor;
    
    public DonorDirectory(Donor donor){
        this.donor = donor;
    }
    
    public void addDonors(){
        
        String firstName = donor.getFirstName();
        String lastName = donor.getLastName();
        String pass = donor.getLastName();
        String type = donor.getType();

        String country = donor.getCountry();
        String email = donor.getEmail();    
        String sql = "INSERT INTO `donortable`(`First_Name`,`Last_Name`, `Email`,`Password`,`Type`,`Country`) "
        + "VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + pass + "','" + type + "','" + country + "')";//        fetch();
        System.out.print(sql);
        DbConnection.query(sql);    
    }

}
