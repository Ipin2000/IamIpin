package UI;

import Business.Validator;
import Entity.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class Hub
{
    //display menu
    public static int menu()
    {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search by Name");
        System.out.println("5. Search by ID");
        System.out.println("6. Sort");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        return InputChecker.checkInputIntLimit(1, 7);
    }

    //allow user add doctor
    public static Doctor createDocData()
    {
        String name,specialization,dob, email, pNumber;
        int availability;

        System.out.print("Enter name: ");
        do
        {
            name = InputChecker.checkInputString();
        } while (!Validator.isValidName(name));


        System.out.print("Enter specialization: ");
        do
        {
            specialization = InputChecker.checkInputString();
        } while (!Validator.isValidSpec(specialization));

        System.out.print("Enter availability: ");
        do
        {
            availability = InputChecker.checkInputInt();
        } while (!Validator.isValidAvail(availability));

        System.out.print("Enter Date of Birth in format [DAY]/[MONTH]/[YEAR]: ");
        do
        {
            dob = InputChecker.checkInputString();
        } while (!Validator.isValidDateOfBirth(dob));

        System.out.print("Enter email: ");
        do
        {
            email = InputChecker.checkInputString();
        } while (!Validator.isValidEmail(email));

        System.out.print("Enter cell number in format (XXX)-XXX-XXXX: ");
        do
        {
            pNumber = InputChecker.checkInputString();
        } while (!Validator.isValidPhoneNumber(pNumber));


        return new Doctor(name, specialization, availability,dob,email,pNumber);
    }

    public static void updateDocInfo(Doctor doctor,
                                     String name,
                                     String specialization,
                                     int availability, String dob, String email, String pNumber)
    {
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        doctor.setDob(dob);
        doctor.setEmail(email);
        doctor.setMobile(pNumber);
        System.err.println("Update successful");
    }


}
