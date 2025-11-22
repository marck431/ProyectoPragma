Feature: Cliente

  Background:
    * def cliente =  Java.type('karate.helpers.bd.ConsultasPersona')


  Scenario: Insertar cliente
    * def insertarCliente = cliente.realizarConsulta('cliente','insertar')
    * print insertarCliente
    * match insertarCliente contains 'Insertado'

  Scenario: Eliminar cliente
    * def eliminarCliente = cliente.realizarConsulta('cliente','eliminar',10)
    * print eliminarCliente
    * match eliminarCliente contains 'Eliminado'