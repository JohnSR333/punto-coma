package domain;

public enum Producto {
    IMPRESION_BN(200, 150),
    IMPRESION_COLOR(500, 400),
    ANILLADO(3000, 3000);

    private final int precio;
    private final int precioVolumen;

    Producto(int precio, int precioVolumen) {
        this.precio = precio;
        this.precioVolumen = precioVolumen;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecioVolumen() {
        return precioVolumen;
    }
}

