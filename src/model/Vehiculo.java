package model;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int precioPorDia;

    public Vehiculo(String matricula, String marca, String modelo, int precioPorDia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + matricula + ") - $" + precioPorDia + "/día";
    }
}
