package karate.helpers.bd;

import karate.Person.Cliente;
import karate.Person.Empleado;
import karate.Person.Persona;

import java.sql.SQLException;

public interface BaseDatos {
    String insertar(Cliente cliente) throws SQLException;

    String insertar(Empleado empleado) throws SQLException;

    String insertar(Persona persona) throws SQLException;

    String actualizar(Cliente cliente,int id) throws SQLException;

    String actualizar(Empleado empleado,int id) throws SQLException;

    String actualizar(Persona persona,int id) throws SQLException;

    String eliminar(String tabla,int id) throws SQLException;

    String consultar(String tabla,int id)throws SQLException;
}
