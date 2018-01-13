package com.it355.projekat.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proizvodId")
    private int proizvodId;

    @NotEmpty(message = "The product name must not be empty")
    @Column(name = "nazivProizvoda")
    private String nazivProizvoda;

    @Column(name = "opis")
    private String opis;

    @Column(name = "kategorija")
    private String kategorija;

    @Min(value = 0, message = "The product price must not be less then zero")
    @Column(name = "cena")
    private double cena;

    @Column(name = "stanje")
    private String stanje;

    @Min(value = 0, message = "The product unit must not be less then zero")
    @Column(name = "dostupnaKolicina")
    private int dostupnaKolicina;

    @Column(name = "proizvodjac")
    private String proizvodjac;

    @Column(name = "slika")
    private String slika;

    public Product() {
    }

    public Product(String nazivProizvoda, String opis, String kategorija, double cena, String stanje, int dostupnaKolicina, String proizvodjac, String slika) {
        this.nazivProizvoda = nazivProizvoda;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cena = cena;
        this.stanje = stanje;
        this.dostupnaKolicina = dostupnaKolicina;
        this.proizvodjac = proizvodjac;
        this.slika = slika;
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    public int getDostupnaKolicina() {
        return dostupnaKolicina;
    }

    public void setDostupnaKolicina(int dostupnaKolicina) {
        this.dostupnaKolicina = dostupnaKolicina;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proizvodId=" + proizvodId +
                ", nazivProizvoda='" + nazivProizvoda + '\'' +
                ", opis='" + opis + '\'' +
                ", kategorija='" + kategorija + '\'' +
                ", cena=" + cena +
                ", stanje='" + stanje + '\'' +
                ", dostupnaKolicina=" + dostupnaKolicina +
                ", proizvodjac='" + proizvodjac + '\'' +
                ", slika='" + slika + '\'' +
                '}';
    }
}
