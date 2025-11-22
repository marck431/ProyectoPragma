Feature: Empleado

  Background:
    * url url.urlBase
    * def employeePath = path.employee
    * def dataGenerator = Java.type ('karate.helpers.DataGenerate')
    * def data = dataGenerator.dataGenerateEmpleado()
    * def dataRequest = karate.toJson(data,true)
    * print data

  Scenario: Creación de un Empleado
    * print dataRequest
    Given path employeePath
    When request dataRequest
    And method POST
    Then status 200
    And match response.name == '#string'

  Scenario: Traer un Empleado
    * print dataRequest
    Given path employeePath
    And method GET
    Then status 200
    And match response.*.idEmpleado contains '400-01-6833'