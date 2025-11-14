package domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final Cliente cliente;
    private final List<ItemPedido> items = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.EN_CREACION;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemPedido(producto, cantidad));
    }

    public void confirmar() {
        estado = EstadoPedido.CONFIRMADO;
    }

    public int totalBruto() {
        return items.stream().mapToInt(ItemPedido::subtotal).sum();
    }

    public int descuento() {
        return (totalBruto() >= 20000) ? 2000 : 0;
    }

    public int totalFinal() {
        return totalBruto() - descuento();
    }
}


