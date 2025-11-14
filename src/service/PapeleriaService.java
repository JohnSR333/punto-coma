package service;

import domain.Cliente;
import domain.Pedido;
import domain.Producto;

public class PapeleriaService {

    public Pedido crearPedido(Cliente cliente) {
        return new Pedido(cliente);
    }

    public void agregarItem(Pedido pedido, Producto producto, int cantidad) {
        pedido.agregarItem(producto, cantidad);
    }

    public void confirmar(Pedido pedido) {
        pedido.confirmar();
    }

    public String resumen(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        sb.append("======= RESUMEN DEL PEDIDO =======\n");
        sb.append("Cliente: ").append(pedido.getCliente().getNombre())
                .append(" | Tel: ").append(pedido.getCliente().getTelefono()).append("\n");
        sb.append("Estado: ").append(pedido.getEstado()).append("\n");
        sb.append("----------------------------------\n");

        for (var item : pedido.getItems()) {
            sb.append(item).append("\n");
        }

        sb.append("----------------------------------\n");
        sb.append("Total bruto: ").append(String.format("%,d\n", pedido.totalBruto()));
        sb.append("Descuento: ").append(String.format("%,d\n", pedido.descuento()));
        sb.append("Total final: ").append(String.format("%,d\n", pedido.totalFinal()));

        return sb.toString();
    }
}

