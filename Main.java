package UI;

import Business.Management;
import Business.Validator;
import Entity.Doctor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        Management hosManagement = new Management();
        //loop until user want to exit

        while (true)
        {
            int choice = Hub.menu();
            Doctor temp;
            int code;
            switch (choice)
            {
                //Create
                case 1:
                    temp = Hub.createDocData();

                    hosManagement.add(temp);
                    System.out.println("Add successful.");
                    break;

                //Edit
                case 2:
                    //allow user update doctor

                    System.out.println("START UPDATE SECTION");

                    System.out.print("Enter code: ");
                    int codeUpdate = InputChecker.checkInputInt();
                    temp = hosManagement.getDocByID(codeUpdate);

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


                    Hub.updateDocInfo(temp, name, specialization, availability, dob,email,pNumber);

                    break;
                //Delete
                case 3:
                    System.out.print("Enter code: ");
                    code = InputChecker.checkInputInt();
                    temp = hosManagement.getDocByID(code);
                    if (hosManagement.delDoc(temp))
                        System.err.println("Delete successful.");
                    else
                        System.err.println("Not found.");
                    break;
                //Search by Name
                case 4:
                    System.out.print("Enter name: ");
                    String nameSearch = InputChecker.checkInputString();
                    List<Doctor> data = hosManagement.getDocsByName(nameSearch);
                    if (data.isEmpty())
                        System.err.println("List empty.");
                    else
                        data.forEach(System.out::println);
                    break;
                //Search By ID
                case 5:
                    System.out.print("Enter ID: ");
                    int idSearch = InputChecker.checkInputInt();
                    Doctor doc = hosManagement.getDocByID(idSearch);
                    if (doc == null)
                        System.err.println("List empty.");
                    else
                        System.out.println(doc);
                    break;

                // sort
                case 6:
                    List<Doctor> docList = new ArrayList<>(hosManagement.getData());
                    docList.sort(Comparator.comparing(Doctor::getDob));
                    docList.forEach(System.out::println);
                    break;

                default:
                    return;
            }


        }

    }
}
