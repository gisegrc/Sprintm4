import Entidades.Administrativo;
import Entidades.Cliente;
import Entidades.Profesional;
import Entidades.Usuario;

import java.util.*;

public class Contenedor {
    List<Usuario> listadoUsuarios = new ArrayList<>();
    List<Capacitacion> listadoCapacitacion = new ArrayList<>();

    public void agregarCliente(Scanner scanner) {
        System.out.println("Ingrese el RUT del cliente:");
        String rut;
        int runNumerico;

        do {
            while (!scanner.hasNextLine()) {
                System.out.println("Ingrese un valor válido para el RUT:");
                scanner.next();
            }
            rut = scanner.nextLine();

            String[] rutParts = rut.split("-");
            runNumerico = Integer.parseInt(rutParts[0]);
            if (runNumerico > 99999999) {
                System.out.println("Ingrese un valor válido para el RUT (menor o igual a 99999999).");
            }
        } while (runNumerico > 99999999);

        System.out.println("Ingrese los nombres del cliente:");
        String nombres;
        do {
            nombres = scanner.nextLine();
        } while (nombres.length() < 5 || nombres.length() > 30);

        System.out.println("Ingrese los apellidos del cliente:");
        String apellidos;
        do {
            apellidos = scanner.nextLine();
        } while (apellidos.length() < 5 || apellidos.length() > 30);

        System.out.println("Ingrese el teléfono del cliente:");
        int telefono;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un valor válido para el teléfono (número entero):");
                scanner.next();
            }
            telefono = scanner.nextInt();
        } while (telefono == 0);
        scanner.nextLine();

        System.out.println("Ingrese la AFP del cliente:");
        String afp;
        do {
            afp = scanner.nextLine();
        } while (afp.length() < 4 || afp.length() > 30);

        System.out.println("Ingrese el sistema de salud del cliente (1 para Fonasa, 2 para Isapre):");
        int sistemaSalud;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un valor válido para el sistema de salud (número entero):");
                scanner.next();
            }
            sistemaSalud = scanner.nextInt();
        } while (sistemaSalud != 1 && sistemaSalud != 2);
        scanner.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccion;
        do {
            direccion = scanner.nextLine();
        } while (direccion.length() > 70);

        System.out.println("Ingrese la comuna del cliente:");
        String comuna;
        do {
            comuna = scanner.nextLine();
        } while (comuna.length() > 50);

        System.out.println("Ingrese la edad del cliente:");
        int edad;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un valor válido para la edad (número entero):");
                scanner.next();
            }
            edad = scanner.nextInt();
        } while (edad < 0 || edad >= 150);
        scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setRut(rut);
        cliente.setNombres(nombres);
        cliente.setApellidos(apellidos);
        cliente.setTelefono(telefono);
        cliente.setAfp(afp);
        cliente.setSistemaSalud(sistemaSalud);
        cliente.setDireccion(direccion);
        cliente.setComuna(comuna);
        cliente.setEdad(edad);

        listadoUsuarios.add(cliente);
    }

    public void agregarProfesional(Scanner scanner) {
        Profesional profesional = new Profesional();

        System.out.println("Ingrese el nombre del profesional:");
        String nombre = scanner.nextLine();
        profesional.setNombre(nombre);

        System.out.println("Ingrese el título del profesional:");
        String titulo;
        do {
            titulo = scanner.nextLine();
            if (titulo.length() < 10 || titulo.length() > 50) {
                System.out.println("El título debe tener entre 10 y 50 caracteres. Ingrese nuevamente:");
            }
        } while (titulo.length() < 10 || titulo.length() > 50);
        profesional.setTitulo(titulo);

        System.out.println("Ingrese la fecha de ingreso del profesional (dd/mm/yyyy):");
        String fechaIngreso = scanner.nextLine();
        profesional.setFechaIngreso(fechaIngreso);

        listadoUsuarios.add(profesional);
    }

    public void agregarAdministrativo(Scanner scanner) {
        Administrativo administrativo = new Administrativo();

        System.out.println("Ingrese el área del administrativo:");
        String area;
        do {
            area = scanner.nextLine();
            if (area.length() < 5 || area.length() > 20) {
                System.out.println("El área debe tener entre 5 y 20 caracteres. Ingrese nuevamente:");
            }
        } while (area.length() < 5 || area.length() > 20);
        administrativo.setArea(area);

        System.out.println("Ingrese la experiencia previa del administrativo (máximo 100 caracteres):");
        String experienciaPrevia = scanner.nextLine();
        if (experienciaPrevia.length() > 100) {
            experienciaPrevia = experienciaPrevia.substring(0, 100);
        }
        administrativo.setExperienciaPrevia(experienciaPrevia);

        listadoUsuarios.add(administrativo);
    }

    public void agregarCapacitacion(Scanner scanner) {
        Capacitacion capacitacion = new Capacitacion();

        int identificador;
        do {
            System.out.println("Ingrese el identificador:");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero entero para el identificador:");
                scanner.next();
            }
            identificador = scanner.nextInt();
            scanner.nextLine();
            capacitacion.setIdentificador(identificador);
        } while (identificador <= 0);

        String rutCliente;

        do {
            System.out.println("Ingrese el rut del cliente:");
            rutCliente = scanner.nextLine();
            capacitacion.setRutCliente(rutCliente);
        } while (rutCliente.isEmpty());

        String dia;
        boolean esDiaValido = false;
        do {
            System.out.println("Ingrese el día de la capacitación (lunes a domingo):");
            dia = scanner.nextLine();
            if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles")
                    || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes")
                    || dia.equalsIgnoreCase("sábado") || dia.equalsIgnoreCase("domingo")) {
                esDiaValido = true;
            } else {
                System.out.println("Ingrese un día válido.");
            }
        } while (!esDiaValido);
        capacitacion.setDia(dia);

        String hora;
        do {
            System.out.println("Ingrese la hora de la capacitación (HH:MM):");
            hora = scanner.nextLine();

            // Validar el formato HH:MM
            if (hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                capacitacion.setHora(hora);
                break;
            } else {
                System.out.println("Formato de hora invalido, favor ingresar en (HH:MM)");
            }
        } while (!hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$"));

        String lugar;
        do {
            System.out.println("Ingrese el lugar de la capacitación:");
            lugar = scanner.nextLine();

            if (lugar.isEmpty()) {
                System.out.println("El lugar es obligatorio. Por favor, ingrese un valor.");
            } else if (lugar.length() < 10 || lugar.length() > 50) {
                System.out.println("El lugar debe tener entre 10 y 50 caracteres.");
            } else {
                capacitacion.setLugar(lugar);
                break;
            }
        } while (lugar.isEmpty());


        String duracion;
        do {
            System.out.println("Ingrese la duración de la capacitacion:");
            duracion = scanner.nextLine();

            if (duracion.length() > 70) {
                System.out.println("maximo 70 caracteres.");
            } else {
                capacitacion.setDuracion(duracion);
                break;
            }
        } while (duracion.length() > 70);

        int cantidadAsistentes;
        do {
            System.out.println("Ingrese la cantidad de asistentes a la capacitación:");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero valido para la cantidad de asistentes:");
                scanner.next();
            }
            cantidadAsistentes = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (cantidadAsistentes >= 1000) {
                System.out.println("La cantidad de asistentes debe ser menor a 1000.");
            } else {
                capacitacion.setCantidadAsistentes(cantidadAsistentes);
                break;
            }
        } while (cantidadAsistentes >= 1000);

        listadoCapacitacion.add(capacitacion);
    }

    public void mostrarListaUsuarios() {
        System.out.println("");
        System.out.println("Lista de usuarios:");
        for (int i = 0; i < listadoUsuarios.size(); i++) {
            System.out.println(i + 1 + ". " + listadoUsuarios.get(i));
        }
    }

    public void eliminarUsuario(Scanner scanner) {
        mostrarListaUsuarios();

        System.out.println("Ingrese posición del usuario que desea eliminar:");
        int posicion = scanner.nextInt();
        scanner.nextLine();

        // Validar posicion
        if (posicion >= 1 && posicion <= listadoUsuarios.size()) {
            listadoUsuarios.remove(posicion - 1);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("La posición invalida.");
        }
    }

    public void listarUsuariosPorTipo() {
        Map<String, List<Usuario>> usuariosPorTipo = new HashMap<>();

        // Agrupar usuarios por tipo con lambda
        for (Usuario usuario : listadoUsuarios) {
            String tipo = usuario.getClass().getSimpleName();
            usuariosPorTipo.computeIfAbsent(tipo, k -> new ArrayList<>()).add(usuario);
        }

        // Mostrar usuarios por tipo
        for (Map.Entry<String, List<Usuario>> entry : usuariosPorTipo.entrySet()) {
            String tipo = entry.getKey();
            List<Usuario> usuarios = entry.getValue();

            System.out.println("Listado de usuarios " + tipo + ":");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

            System.out.println(); // Espacio en blanco entre tipos de usuarios
        }
    }

    public void listarCapacitaciones() {
        System.out.println("Listado de capacitaciones:");
        for (Capacitacion capacitacion : listadoCapacitacion) {
            System.out.println(capacitacion);
        }
    }

    public void llenarIngresosPrueba() {
        // Agregar usuarios de prueba
        Cliente cliente1 = new Cliente("12345678-9", "Juan", "Perez", 123456789, "AFP1", 1, "Dirección 1", "Comuna 1", 30);
        Cliente cliente2 = new Cliente("98765432-1", "Maria", "Gomez", 987654321, "AFP2", 2, "Dirección 2", "Comuna 2", 25);
        Profesional profesional1 = new Profesional("Ingeniero", "01/01/2010");
        Profesional profesional2 = new Profesional("Arquitecto", "01/01/2008");
        Administrativo administrativo1 = new Administrativo("Área 1", "Experiencia 1");

        listadoUsuarios.add(cliente1);
        listadoUsuarios.add(cliente2);
        listadoUsuarios.add(profesional1);
        listadoUsuarios.add(profesional2);
        listadoUsuarios.add(administrativo1);

        // Agregar capacitaciones de prueba
        Capacitacion capacitacion1 = new Capacitacion(1, "12345678-9", "01/01/2022", "10:00", "Lugar 1", "60", 50);
        Capacitacion capacitacion2 = new Capacitacion(2, "98765432-1", "02/02/2022", "14:00", "Lugar 2", "90", 30);

        listadoCapacitacion.add(capacitacion1);
        listadoCapacitacion.add(capacitacion2);
    }

}
