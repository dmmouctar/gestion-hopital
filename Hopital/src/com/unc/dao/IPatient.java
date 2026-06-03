package com.unc.dao;

import com.unc.model.Patient;

import java.util.List;

public interface IPatient {
    public void save(Patient patient);
    public Patient getPatient(int id);
    public List<Patient> readAll();
    public void delete(Patient patient);
    public void update(Patient patient);
}
