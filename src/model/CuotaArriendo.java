package model;

public class CuotaArriendo {
    private int numCuota;
    private int valorCuota;
    private boolean pagada;

    public CuotaArriendo(int numCuota, int valorCuota) {
        this.numCuota = numCuota;
        this.valorCuota = valorCuota;
        this.pagada = false;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return "Cuota #" + numCuota + ": $" + valorCuota + (pagada ? " (Pagada)" : " (Pendiente)");
    }
}

