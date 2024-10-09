package org.example.kebab.Clases;

public class Productos {
    private int id_producto;
    private String nombrePlato;
    private double precioPlato;
    private String nombreBebida;
    private double precioBebida;
    private boolean patatas;
    private double total;

    public Productos(int id_producto, String nombrePlato, double precioPlato, String nombreBebida, double precioBebida, boolean patatas) {
        this.id_producto = id_producto;
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
        this.patatas = patatas;
    }

    public Productos(String nombrePlato, double precioPlato, String nombreBebida, double precioBebida, boolean patatas) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
        this.patatas = patatas;
    }

    public Productos(String nombrePlato, double precioPlato) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
    }

    public Productos(double precioBebida, String nombreBebida) {
        this.precioBebida = precioBebida;
        this.nombreBebida = nombreBebida;
    }

    public Productos(String nombrePlato, double precioPlato, String nombreBebida, double precioBebida) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
    }

    public Productos(boolean patatas) {
        this.patatas = patatas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(double precioBebida) {
        this.precioBebida = precioBebida;
    }

    public boolean isPatatas() {
        return patatas;
    }

    public void setPatatas(boolean patatas) {
        this.patatas = patatas;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id_producto=" + id_producto +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", precioPlato=" + precioPlato +
                ", nombreBebida='" + nombreBebida + '\'' +
                ", precioBebida=" + precioBebida +
                ", patatas=" + patatas +
                '}';
    }
}
