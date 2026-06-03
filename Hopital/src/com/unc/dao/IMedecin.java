package com.unc.dao;

import com.unc.model.Medecin;


import java.util.List;

public interface IMedecin {
    public void save(Medecin medecin);
    public Medecin getMedecin(int id);
    public List<Medecin> readAll();
    public void delete(Medecin medecin);
    public void update(Medecin medecin);
}
