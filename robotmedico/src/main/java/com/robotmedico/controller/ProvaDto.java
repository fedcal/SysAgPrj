package com.robotmedico.controller;

public class ProvaDto {
    private String saluto;
    private int numero;

    public ProvaDto(String saluto, int numero) {
        this.saluto = saluto;
        this.numero = numero;
    }

    public ProvaDto() {
    }

    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(String saluto) {
        this.saluto = saluto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
