import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RegistroFacturasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pregunta por el tipo de servicio
        System.out.println("Seleccione el tipo de servicio:");
        System.out.println("1. Compra de repuestos");
        System.out.println("2. Mantenimiento");
        System.out.println("3. Lavado");
        int tipoServicio = scanner.nextInt();

        // Pide el código del vendedor
        System.out.print("Ingrese el código del vendedor: ");
        int codigoVendedor = scanner.nextInt();

        // Pide el DNI del cliente y su nombre
        System.out.print("Ingrese el DNI del cliente: ");
        String dniCliente = scanner.next();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        scanner.nextLine(); // Limpia el buffer de entrada

        ArrayList<String> productosSeleccionados = new ArrayList<>();
        double total = 0.0;

        // Dependiendo del tipo de servicio, muestra los productos disponibles
        switch (tipoServicio) {
            case 1: // Compra de repuestos
                System.out.println("Productos disponibles para Compra de Repuestos:");
                System.out.println("1 - Nombre: Biela motor, Modelo: Aveo, Precio: 580 soles");
                System.out.println("2 - Nombre: Inyector gasolina, Modelo: Blazer, Precio: 850 soles");
                System.out.println("3 - Nombre: Pastillas de freno, Modelo: Cavalier, Precio: 720 soles");
                System.out.println("4 - Nombre: Filtro de aire, Modelo: trax, Precio: 360 soles");

                while (true) {
                    System.out.print("Seleccione un producto (1-4) o 0 para finalizar: ");
                    int opcion = scanner.nextInt();

                    if (opcion == 0) {
                        break;
                    }

                    if (opcion >= 1 && opcion <= 4) {
                        switch (opcion) {
                            case 1:
                                productosSeleccionados.add("Biela motor - Aveo");
                                total += 580.0;
                                break;
                            case 2:
                                productosSeleccionados.add("Inyector gasolina - Blazer");
                                total += 850.0;
                                break;
                            case 3:
                                productosSeleccionados.add("Pastillas de freno - Cavalier");
                                total += 720.0;
                                break;
                            case 4:
                                productosSeleccionados.add("Filtro de aire - trax");
                                total += 360.0;
                                break;
                        }
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione un producto válido.");
                    }
                }
                break;

            case 2: // Mantenimiento
                System.out.println("Productos disponibles para Mantenimiento:");
                String[] mantenimientos = {
                        "Mantenimiento básico de motor - Costo S/ 2500.00",
                        "Mantenimiento básico de eléctrico - Costo S/ 750.00",
                        "Mantenimiento básico de transmisión - Costo S/ 1000.00",
                        "Mantenimiento básico de freno - Costo S/ 500.00",
                        "Mantenimiento básico de dirección - Costo S/ 500.00",
                        "Mantenimiento básico de suspensión - Costo S/ 1200.00",
                        "Mantenimiento básico de carrocería - Costo S/ 500.00"
                };

                for (int i = 0; i < mantenimientos.length; i++) {
                    System.out.println((i + 1) + ". " + mantenimientos[i]);
                }

                while (true) {
                    System.out.print("Seleccione un producto (1-" + mantenimientos.length + ") o 0 para finalizar: ");
                    int opcion = scanner.nextInt();

                    if (opcion == 0) {
                        break;
                    }

                    if (opcion >= 1 && opcion <= mantenimientos.length) {
                        productosSeleccionados.add(mantenimientos[opcion - 1]);
                        switch (opcion) {
                            case 1:
                                total += 2500.0;
                                break;
                            case 2:
                                total += 750.0;
                                break;
                            case 3:
                                total += 1000.0;
                                break;
                            case 4:
                                total += 500.0;
                                break;
                            case 5:
                                total += 500.0;
                                break;
                            case 6:
                                total += 1200.0;
                                break;
                            case 7:
                                total += 500.0;
                                break;
                        }
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione un producto válido.");
                    }
                }
                break;

            case 3: // Lavado
                System.out.println("Productos disponibles para Lavado:");
                System.out.println("1 - Lavado interno - Precio: 40 soles");
                System.out.println("2 - Lavado externo - Precio: 15 soles");
                System.out.println("3 - Lavado completo - Precio: 80 soles");

                while (true) {
                    System.out.print("Seleccione un producto (1-3) o 0 para finalizar: ");
                    int opcion = scanner.nextInt();

                    if (opcion == 0) {
                        break;
                    }

                    if (opcion >= 1 && opcion <= 3) {
                        switch (opcion) {
                            case 1:
                                productosSeleccionados.add("Lavado interno");
                                total += 40.0;
                                break;
                            case 2:
                                productosSeleccionados.add("Lavado externo");
                                total += 15.0;
                                break;
                            case 3:
                                productosSeleccionados.add("Lavado completo");
                                total += 80.0;
                                break;
                        }
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione un producto válido.");
                    }
                }
                break;

            default:
                System.out.println("Tipo de servicio no válido.");
                return;
        }

        // Pregunta por el tipo de moneda
        System.out.print("Seleccione el tipo de moneda (soles/dólares): ");
        String tipoMoneda = scanner.next();

        // Calcula el total en dólares si se selecciona "dólares"
        if (tipoMoneda.equalsIgnoreCase("dólares")) {
            total /= 3.70;
        }

        // Genera una cotización
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());

        System.out.println("\nCotización COT-00001");
        System.out.println("Vendedor: " + codigoVendedor);
        System.out.println("Fecha: " + fechaActual);
        System.out.println("Cliente: " + nombreCliente + " (DNI: " + dniCliente + ")");
        System.out.println("Tipo de Servicio: " + obtenerTipoServicio(tipoServicio));
        System.out.println("Productos Seleccionados:");
        for (int i = 0; i < productosSeleccionados.size(); i++) {
            System.out.println((i + 1) + ". " + productosSeleccionados.get(i));
        }
        System.out.println("Total: " + total + " " + tipoMoneda);
    }

    public static String obtenerTipoServicio(int tipoServicio) {
        switch (tipoServicio) {
            case 1:
                return "Compra de repuestos";
            case 2:
                return "Mantenimiento";
            case 3:
                return "Lavado";
            default:
                return "Desconocido";
        }
    }
}
