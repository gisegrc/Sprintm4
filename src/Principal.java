import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contenedor contenedor = new Contenedor();
        contenedor.llenarIngresosPrueba();

        int opcion;

        do {
            System.out.println(" ");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar profesional");
            System.out.println("3. Agregar administrativo");
            System.out.println("4. Almacenar Capacitacion");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Listar usuarios por tipo");
            System.out.println("8. Listar capacitaciones");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            System.out.println(" ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    contenedor.agregarCliente(scanner);
                    break;
                case 2:
                    contenedor.agregarProfesional(scanner);
                    break;
                case 3:
                    contenedor.agregarAdministrativo(scanner);
                    break;
                case 4:
                    contenedor.agregarCapacitacion(scanner);
                    break;
                case 5:
                    contenedor.eliminarUsuario(scanner);
                    break;
                case 6:
                    contenedor.mostrarListaUsuarios();
                    break;
                case 7:
                    contenedor.listarUsuariosPorTipo();
                    break;
                case 8:
                    contenedor.listarCapacitaciones();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion inválida. Intentelo otra vez.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }
}
