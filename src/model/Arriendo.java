package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Arriendo {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fechaArriendo;
    private int dias;
    private double montoTotal;
    private List<CuotaArriendo> cuotas;

    public Arriendo(Cliente cliente, Vehiculo vehiculo, Date fechaArriendo, int dias, double montoTotal, int numCuotas) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaArriendo = fechaArriendo;
        this.dias = dias;
        this.montoTotal = montoTotal;
        this.cuotas = new ArrayList<>();
        for (int i = 0; i < numCuotas; i++) {
            int valorCuota = (int) Math.ceil(montoTotal / numCuotas);
            CuotaArriendo cuota = new CuotaArriendo(i + 1, valorCuota);
            cuotas.add(cuota);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public int getDias() {
        return dias;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public List<CuotaArriendo> getCuotas() {
        return cuotas;
    }

    @Override
    public String toString() {
        return cliente.getNombre() + " - " + vehiculo.getModelo() + " (" + dias + " días)";
    }
}
