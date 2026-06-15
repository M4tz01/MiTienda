package com.example.mitienda;

import javafx.beans.property.*;

public class Producto {
    private final StringProperty codigo;
    private final StringProperty nombre;
    private final StringProperty categoria;
    private final DoubleProperty precio;
    private final IntegerProperty stock;
    private final StringProperty estado;

    public Producto(String codigo, String nombre, String categoria, double precio, int stock, String estado) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.categoria = new SimpleStringProperty(categoria);
        this.precio = new SimpleDoubleProperty(precio);
        this.stock = new SimpleIntegerProperty(stock);
        this.estado = new SimpleStringProperty(estado);
    }

    // Getters y Properties necesarios para el mapeo automático del TableView
    public String getCodigo() { return codigo.get(); }
    public StringProperty codigoProperty() { return codigo; }

    public String getNombre() { return nombre.get(); }
    public StringProperty nombreProperty() { return nombre; }

    public String getCategoria() { return categoria.get(); }
    public StringProperty categoriaProperty() { return categoria; }

    public double getPrecio() { return precio.get(); }
    public DoubleProperty precioProperty() { return precio; }

    public int getStock() { return stock.get(); }
    public IntegerProperty stockProperty() { return stock; }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
}