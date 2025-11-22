package karate.helpers;

import com.github.javafaker.Faker;
import karate.Person.Cliente;
import karate.Person.Empleado;
import karate.Person.Persona;

import java.util.Locale;

public class DataGenerate {
    public static Faker faker = new Faker(new Locale("es", "CO"));

    private Persona persona;
    private Cliente cliente;
    private Empleado empleado;
    private String nombre = faker.name().name();
    private String genero = faker.options().option("Male", "Female");
    private int edad = faker.number().numberBetween(18, 60);
    private String direccion = faker.address().streetAddress();
    private String id = faker.idNumber().valid();

    public Cliente dataClient() {
        boolean vip = faker.bool().bool();
        cliente = new Cliente(this.nombre, this.genero, this.edad, this.direccion, id, vip);
        return cliente;
    }

    public Empleado dataEmployee() {
        double salario = faker.number().randomDouble(0, 1300000, 4000000);
        empleado = new Empleado(this.nombre, this.genero, this.edad, this.direccion, id, salario);
        return empleado;
    }


    public static Cliente dataGenerateCliente() {
        DataGenerate generate = new DataGenerate();
                return generate.dataClient();
        }

    public static Empleado dataGenerateEmpleado() {
        DataGenerate generate = new DataGenerate();
        return generate.dataEmployee();
    }


}
