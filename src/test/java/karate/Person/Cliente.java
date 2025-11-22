package karate.Person;

public class Cliente extends Persona {
    private String idCliente;
    private boolean vip;


    public Cliente(String nombre, String genero, int edad, String direccion, String idCliente, boolean vip) {
        super(nombre, genero, edad, direccion);
        this.idCliente = idCliente;
        this.vip = vip;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}
