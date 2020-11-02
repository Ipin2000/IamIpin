package Business;

import Entity.Doctor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Management
{
    private final List<Doctor> data;

    public Management()
    {
        data = new LinkedList<>();
    }

    public List<Doctor> getData()
    {
        return data;
    }

    public void add(Doctor temp)
    {
        data.add(temp);
    }

    public Doctor getDocByID(int code)
    {
        return data.stream().filter(doctor -> doctor.getCode() == code).findFirst().orElse(null);
    }

    public boolean delDoc(Doctor doctor)
    {
        if (doctor == null || !data.contains(doctor)) return false;
        data.remove(doctor);
        return true;
    }

    public List<Doctor> getDocsByName(String name)
    {
        return data.stream().filter(doctor -> doctor.getName().contains(name)).collect(Collectors.toList());
    }

}
