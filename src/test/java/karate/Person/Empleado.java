package karate.Person;

public class Empleado extends Persona {
    private String idEmpleado;
    private double sueldo;

    public Empleado(String nombre, String genero, int edad, String direccion, String idEmpleado, double sueldo) {
        super(nombre, genero, edad, direccion);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
