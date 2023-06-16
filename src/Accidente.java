public class Accidente {
    private int id;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente() {
    }

    public Accidente(int id, int rutCliente, String dia, String hora, String lugar, String origen, String consecuencias) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "id=" + id +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", origen='" + origen + '\'' +
                ", consecuencias='" + consecuencias + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (String.valueOf(id).isEmpty()) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else {
            this.id = id;
        }
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (String.valueOf(rutCliente).isEmpty()) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else {
            this.rutCliente = rutCliente;
        }
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (dia.isEmpty()) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else {
            this.dia = dia;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (hora.isEmpty()) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else if (!hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            System.out.println("Debe tener el formato HH:MM.");
        } else {
            this.hora = hora;
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar.isEmpty()) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else if (lugar.length() < 10 || lugar.length() > 50) {
            System.out.println("Debe tener entre 10 y 50 caracteres.");
        } else {
            this.lugar = lugar;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen.length() > 100) {
            System.out.println("Dato obligatorio. Favor ingrese un valor.");
        } else {
            this.origen = origen;
        }
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias.length() > 100) {
            System.out.println("Debe tener máximo 100 caracteres.");
        } else {
            this.consecuencias = consecuencias;
        }
    }
}
