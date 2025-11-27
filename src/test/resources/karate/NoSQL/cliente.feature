Feature: Cliente

  Background:
    * url url.urlBase
    * def clientPath = path.client
    * def dataGenerator = Java.type ('karate.helpers.DataGenerate')
    * def data = dataGenerator.dataGenerateCliente()
    * def dataRequest = karate.toJson(data,true)
    * print data

  Rule: El cliente debe tener direccion,
  edad, genero, idCliente, nombre, y si es vip

  Scenario: Creación de un cliente
    * print dataRequest
    Given path clientPath
    When request dataRequest
    And method POST
    Then status 200
    And match response.name == '#string'

  Scenario: Traer un cliente
    * print dataRequest
    Given path clientPath
    And method GET
    Then status 200
    And match response.*.idCliente contains '825-74-5321'