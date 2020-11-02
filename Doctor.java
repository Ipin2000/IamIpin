package Entity;


import Business.Validator;

import java.time.LocalDate;


public class Doctor implements Comparable<Doctor>
{
    private static int id = 1;

    private final int code;
    private String name;
    private String specialization;
    private int availability;
    private LocalDate dob;
    private String email;
    private String mobile;


    public Doctor(
            String name,
            String specialization,
            int availability,
            String dob,
            String email,
            String mobile)
    {
        setName(name);
        setSpecialization(specialization);
        setAvailability(availability);
        setDob(dob);
        setEmail(email);
        setMobile(mobile);
        code = id++;
    }

    public static int getCurrentID(){
        return id;
    }

    public LocalDate getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {

        if (Validator.isValidDateOfBirth(dob))
        {
            int[] dobDetails = Validator.getDobDetails(dob);
            this.dob = LocalDate.of(dobDetails[0], dobDetails[1], dobDetails[2]);
        }
        else
            throw new IllegalArgumentException();
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        if (Validator.isValidEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException();
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        if (Validator.isValidPhoneNumber(mobile))
            this.mobile = mobile;
        else
            throw new IllegalArgumentException();
    }


    public int getCode()
    {
        return code;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (Validator.isValidName(name))
            this.name = name;
        else
            throw new IllegalArgumentException();
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String specialization)
    {
        if (Validator.isValidSpec(specialization))
            this.specialization = specialization;
        else
            throw new IllegalArgumentException();
    }

    public int getAvailability()
    {
        return availability;
    }

    public void setAvailability(int availability)
    {
        if (Validator.isValidAvail(availability))
            this.availability = availability;
        else
            throw new IllegalArgumentException();

    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if ((o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return getCode() == doctor.getCode() &&
                getAvailability() == doctor.getAvailability() &&
                getName().equals(doctor.getName()) &&
                getSpecialization().equals(doctor.getSpecialization()) &&
                getDob().equals(doctor.getDob()) &&
                getEmail().equals(doctor.getEmail()) &&
                getMobile().equals(doctor.getMobile());
    }

    @Override
    public String toString()
    {
        return "Doctor{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availability=" + availability +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }


    @Override
    public int compareTo(Doctor o)
    {
        return getDob().compareTo(o.getDob());
    }
}
