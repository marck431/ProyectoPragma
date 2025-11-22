package karate.helpers.bd;

import karate.Person.Cliente;
import karate.Person.Empleado;
import karate.Person.Persona;
import karate.helpers.DataGenerate;

import java.sql.*;


public class ConsultasPersona implements BaseDatos {
    @Override
    public String insertar(Persona persona) {

        try {
            Connection con = ConexionBD.getConnection();
            String sql = "INSERT INTO person (first_name,genero,direccion) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getGenero());
            ps.setString(3, persona.getDireccion());
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Insertado";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String insertar(Cliente cliente) {
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "INSERT INTO client (id,vip) VALUES (DEFAULT,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, cliente.isVip());
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Insertado: " + cliente.isVip();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String insertar(Empleado empleado) {
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "INSERT INTO employee (id,sueldo) VALUES (DEFAULT,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, empleado.getSueldo());
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Insertado: " + empleado.getSueldo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String actualizar(Persona persona, int id) {
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "UPDATE person SET first_name = ?, genero=?, direccion=? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getGenero());
            ps.setString(3, persona.getDireccion());
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Actualizado";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String actualizar(Cliente cliente, int id) {
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "UPDATE client SET vip = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, cliente.isVip());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Actualizado";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String actualizar(Empleado empleado, int id) {
        try {


            Connection con = ConexionBD.getConnection();
            String sql = "UPDATE employee SET vip = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, empleado.getSueldo());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Actualizado";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String eliminar(String tabla, int id) {
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "DELETE FROM " + tabla + " WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return "Eliminado";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String consultar(String tabla, int id) {
        try {


            Connection con = ConexionBD.getConnection();
            String sql = "SELECT * FROM " + tabla + " WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (tabla.equalsIgnoreCase("client")) {
                while (rs.next()) {
                    String vip = rs.getString("vip");
                    return vip;
                }
                rs.close();
                ps.close();
                con.close();
            }
            if (tabla.equalsIgnoreCase("employee")) {
                while (rs.next()) {
                    String sueldo = rs.getString("sueldo");
                    return sueldo;
                }
                rs.close();
                ps.close();
                con.close();
            }
            rs.close();
            ps.close();
            con.close();
            return "No encontro";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static String realizarConsulta(String persona, String metodo) {
        ConsultasPersona consultas = new ConsultasPersona();
        switch (persona) {
            case "cliente":
                if (metodo.equalsIgnoreCase("insertar")) {
                    return consultas.insertar(DataGenerate.dataGenerateCliente());
                }
                break;
            case "empleado":
                if (metodo.equalsIgnoreCase("insertar")) {
                    return consultas.insertar(DataGenerate.dataGenerateEmpleado());

                }
                break;
        }
        return "No encontro";
    }

    public static String realizarConsulta(String persona, String metodo, int id) {
        ConsultasPersona consultas = new ConsultasPersona();

        switch (persona) {
            case "cliente":
                if (metodo.equalsIgnoreCase("actualizar")) {

                    return consultas.actualizar(DataGenerate.dataGenerateCliente(), id);

                }
                if (metodo.equalsIgnoreCase("eliminar")) {
                    return consultas.eliminar("client", id);
                }
                if (metodo.equalsIgnoreCase("consultar")) {
                    return consultas.consultar("client", id);
                }
                break;
            case "empleado":

                if (metodo.equalsIgnoreCase("actualizar")) {
                    return consultas.actualizar(DataGenerate.dataGenerateEmpleado(), id);
                }
                if (metodo.equalsIgnoreCase("eliminar")) {
                    return consultas.eliminar("employee", id);
                }
                if (metodo.equalsIgnoreCase("consultar")) {
                    return consultas.consultar("employee", id);
                }
                break;
        }
        return "No encontro";

    }


}
