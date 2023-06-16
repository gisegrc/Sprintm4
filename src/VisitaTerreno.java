public class VisitaTerreno {
    private int idVisita;
    private String rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String comentarios;

    public VisitaTerreno() {
    }

    public VisitaTerreno(int idVisita, String rutCliente, String dia, String hora, String lugar, String comentarios) {
        this.idVisita = idVisita;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "VisitaTerreno{" +
                "idVisita=" + idVisita +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
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

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        if (rutCliente.isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor.");
        } else {
            this.rutCliente = rutCliente;
        }
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (dia.isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor DD/MM/AAAA.");
        } else {
            this.dia = dia;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (hora.isEmpty()) {
            System.out.println("La hora de la visita en terreno es obligatoria. Por favor, ingrese un valor.");
        } else if (!hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            System.out.println("La hora de la visita en terreno debe tener el formato HH:MM. Por favor, ingrese un valor válido.");
        } else {
            this.hora = hora;
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar.isEmpty()) {
            System.out.println("Dato obligatorio. Por favor, ingrese un valor.");
        } else if (lugar.length() < 10 || lugar.length() > 50) {
            System.out.println("Debe tener entre 10 y 50 caracteres.");
        } else {
            this.lugar = lugar;
        }
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios.length() > 100) {
            System.out.println("Deben tener máximo 100 caracteres.");
        } else {
            this.comentarios = comentarios;
        }
    }
}
