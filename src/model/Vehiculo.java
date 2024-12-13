package model;

public class Vehiculo {
    private String matricula;
    private String modelo;
    private double precioPorDia;

    public Vehiculo(String matricula, String modelo, double precioPorDia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    @Override
    public String toString() {
        return modelo + " (" + matricula + ") - $" + precioPorDia + "/día";
    }
}
