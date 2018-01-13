package com.it355.projekat.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int porudzbinaId;

    private String username;
    private String naziv;
    private Date datum;

    public Orders() {
    }

    public Orders(String username, String naziv, Date datum) {
        this.username = username;
        this.naziv = naziv;
        this.datum = datum;
    }

    public int getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(int porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "porudzbinaId=" + porudzbinaId +
                ", username='" + username + '\'' +
                ", naziv='" + naziv + '\'' +
                ", datum=" + datum +
                '}';
    }
}
