package com.unc.dao;

import com.unc.model.AffConsultation;
import com.unc.model.Consultation;
import com.unc.model.Medecin;

import java.util.List;

public interface IConsultation {
    public void save(Consultation consultation);
    public Consultation getConsultation(int id);
    public List<AffConsultation> readAll();
    public void delete(Consultation consultation);
    public void update(Consultation consultation);
}
