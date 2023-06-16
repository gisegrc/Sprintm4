package Entidades;

import Service.Asesoria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public abstract class Usuario implements Asesoria {
    private String nombre;
    private String fechaNacimiento;
    private String run;

    public Usuario() {
    }

    public Usuario(String nombre, String fechaNacimiento, String run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public String mostrarEdad() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM yyyy", new Locale("es"));
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
        long edad = ChronoUnit.YEARS.between(fechaNac, LocalDate.now());
        return "El usuario tiene " + edad + " anios";
    }

    @Override
    public String analizarUsuario() {
        return "Nombre: " + nombre + " " + "RUN: " + run;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "\nNombre: " + nombre  +
                "\nEdad: " + mostrarEdad() +
                "\nRut: " + run +
                "\n ";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() >= 10 && nombre.length() <= 50) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres.");
        }
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(fechaNacimiento, formatter);
            this.fechaNacimiento = fechaNacimiento;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha de nacimiento debe tener el formato DD/MM/AAAA.");
        }
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        int runNumerico = Integer.parseInt(run.replaceAll("[^0-9]", ""));
        if (runNumerico > 0 && runNumerico < 99999999) {
            this.run = run;
        } else {
            throw new IllegalArgumentException("El RUN debe ser un número menor a 99.999.999.");
        }
    }
}
