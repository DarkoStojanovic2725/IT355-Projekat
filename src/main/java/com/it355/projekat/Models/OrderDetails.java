package com.it355.projekat.Models;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detaljiId;

    private int proizvodId;

    private int porudzbinaId;

    private double cena;

    private int kolicina;

    public OrderDetails() {
    }

    public OrderDetails(int proizvodId, int porudzbinaId, double cena, int kolicina) {
        this.proizvodId = proizvodId;
        this.porudzbinaId = porudzbinaId;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public int getDetaljiId() {
        return detaljiId;
    }

    public void setDetaljiId(int detaljiId) {
        this.detaljiId = detaljiId;
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public int getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(int porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "detaljiId=" + detaljiId +
                ", proizvodId=" + proizvodId +
                ", porudzbinaId=" + porudzbinaId +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                '}';
    }
}
