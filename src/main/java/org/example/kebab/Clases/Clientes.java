package org.example.kebab.Clases;

public class Clientes {
    private int id_cliente;
    private String email;
    private String contrasena;

    public Clientes(int id_cliente, String email, String contrasena) {
        this.id_cliente = id_cliente;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Clientes(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
