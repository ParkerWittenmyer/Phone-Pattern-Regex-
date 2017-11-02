/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonepattern;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/**
 *
 * @author pwittenmyer
 */
public class PhonePattern {

    
    public static void main(String[] args) {
        Pattern phone;
        phone = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?[. ]?(\\d{3})[- ]?[. ]?(\\d{4})"); 
//regex expression(above) that will compile the number, if possible, using tokens.
        try (Scanner input = new Scanner(System.in)) { //opens the scanner for user input.
            System.out.println("Enter a phone number: "); //prints out a line of directions for the user.
            String number = input.nextLine(); //sets the user's input to the varible 'number'
            while(!phone.equals("")) //this while loop runs while the input for the phone pattern is not empty.
            {
                Matcher phoneM = phone.matcher(number);
                if(phoneM.matches())//this loop runs if the input can work in the pattern.
                {
                    String areacode = phoneM.group(1); //First 3 digits
                    String prefix = phoneM.group(2); //Second 3 digits
                    String linenumber = phoneM.group(3); //Last 4 digits
                    System.out.println("US style phone number: " + areacode + "-" + prefix + "-" + linenumber);
                } //end if statement
                else
                {
                    System.out.println("Please enter a valid phone number.");
                }
                number = input.nextLine();
            } //end while statement
        }
    } //ends main method
}
