package app;

import domain.Cliente;
import domain.Producto;
import service.PapeleriaService;
import domain.Pedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PapeleriaService service = new PapeleriaService();

        System.out.println("=== PAPELERÍA PUNTO & COMA ===");

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(nombre, telefono);
        Pedido pedido = service.crearPedido(cliente);

        boolean seguir = true;

        while (seguir) {
            System.out.println("\nSeleccione un producto:");
            System.out.println("1. Impresión Blanco y Negro");
            System.out.println("2. Impresión Color");
            System.out.println("3. Anillado");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();

            Producto producto = null;

            switch (opcion) {
                case 1 -> producto = Producto.IMPRESION_BN;
                case 2 -> producto = Producto.IMPRESION_COLOR;
                case 3 -> producto = Producto.ANILLADO;
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            System.out.print("Cantidad: ");
            int cant = sc.nextInt();

            service.agregarItem(pedido, producto, cant);

            System.out.print("¿Agregar otro producto? (s/n): ");
            seguir = sc.next().equalsIgnoreCase("s");
        }

        service.confirmar(pedido);

        System.out.println("\n" + service.resumen(pedido));
    }
}
