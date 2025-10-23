
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BilleteraParque billetera = new BilleteraParque(100);
        int opcion;

        do { 
            System.out.println("Administrador de billeteras para parques temáticos");

            System.out.println("1. Agregar tickets \n 2. Establecer tickets \n 3. Comprar premio \n 4. Establecer festivo \n 5. Salir");
            System.out.println("Tu billetera tiene " + billetera.getTickets() + " boletos" );
            System.out.println("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 : 
                    System.out.println("Cuantos boletos se agregan?");
                    int agregarTickets = scanner.nextInt();
                    billetera.agregarTickets(agregarTickets);
                    break;
                case 2 :
                    System.out.println("Establecer saldo de tickets en: ");
                    int nuevoTotal = scanner.nextInt();
                    billetera.setTickets(nuevoTotal);
                    break;
                case 3 : 
                    int precioCamiseta = 150;
                    int precioSombrero = 350;
                    int precioTenis = 600;

                    if (BilleteraParque.getFestivo()) {
                        System.out.println("Precios de vacaciones!");
                        precioCamiseta /= 2;
                        precioSombrero /= 2;
                        precioTenis /= 2;
                    }

                    System.out.println("1. Camiseta (" + precioCamiseta + " tickets)");
                    System.out.println("2. Sombrero (" + precioSombrero + " tickets)");
                    System.out.println("3. Tenis (" + precioTenis + " tickets)");
                    System.out.print("Qué premio desea comprar? ");
                    int opcionPremio = scanner.nextInt();

                    int precioSeleccionado = 0;
                    String nombrePremio = "";

                    switch (opcionPremio) {
                        case 1:
                            precioSeleccionado = precioCamiseta;
                            nombrePremio = "camiseta";
                            break;
                        case 2:
                            precioSeleccionado = precioSombrero;
                            nombrePremio = "sombrero";
                            break;
                        case 3:
                            precioSeleccionado = precioTenis;
                            nombrePremio = "tenis";
                            break;
                    }

                    if (billetera.removerTickets(precioSeleccionado)) {
                        System.out.println("Compré un " + nombrePremio + " por " + precioSeleccionado + " tickets.");
                    } else {
                        System.out.println("No hay suficientes boletos para comprar un " + nombrePremio);
                    }
                    break;
                case 4 :
                    BilleteraParque.setFestivo(); 
                    if (BilleteraParque.getFestivo()) {
                        System.out.println("Ahora es un día festivo");
                    } else {
                        System.out.println("Ya no es un día festivo");
                    }
                    break;
                case 5 : 
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion invalida. Intenta de nuevo con un numero en la lista");
            }
        } while (opcion != 5);
    }
}
