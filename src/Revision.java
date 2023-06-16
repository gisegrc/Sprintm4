public class Revision {
    private int idRevision;
    private int idVisita;
    private String nombre;
    private String detalle;
    private int estado;

    public Revision() {
    }

    public Revision(int idRevision, String nombre, String detalle, int estado) {
        this.idRevision = idRevision;
        this.nombre = nombre;
        this.detalle = detalle;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "idRevision=" + idRevision +
                ", idVisita=" + idVisita +
                ", nombre='" + nombre + '\'' +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                '}';
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        if (String.valueOf(idRevision).isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor.");
        } else {
            this.idRevision = idRevision;
        }
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        if (String.valueOf(idVisita).isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor.");
        } else {
            this.idVisita = idVisita;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor.");
        } else if (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("Debe tener entre 10 y 50 caracteres");
        } else {
            this.nombre = nombre;
        }
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        if (detalle.length() > 100) {
            System.out.println("Debe tener máximo 100 caracteres.");
        } else {
            this.detalle = detalle;
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            System.out.println("El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba). Por favor, ingrese un valor válido.");
        } else {
            this.estado = estado;
        }
    }
}
