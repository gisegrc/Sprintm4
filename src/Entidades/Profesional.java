package Entidades;

public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;

    public Profesional() {
    }

    public Profesional(String titulo, String fechaIngreso) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }

    @Override
    public String analizarUsuario() {
        return "Su titulo es:  " + titulo +
                "\nFecha de ingreso: " + fechaIngreso +
                "\n ";

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
