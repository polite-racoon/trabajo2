package model;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int precioPorDia;
    private char condicion = 'D'; // D = Disponible, A = Arrendado

    public Vehiculo(String patente, String marca, String modelo, int precioPorDia) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + condicion + ")";
    }
}
