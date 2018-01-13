package com.it355.projekat.Models;

public class ProizvodZaKorpu {
    private Product product;
    private int kolicina;

    public ProizvodZaKorpu(){
        super();
    }

    public ProizvodZaKorpu(Product product, int kolicina) {
        super();
        this.product = product;
        this.kolicina = kolicina;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
