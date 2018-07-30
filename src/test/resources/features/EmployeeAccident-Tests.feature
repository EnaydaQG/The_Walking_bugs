# Este archivo contiene casos de prueba para crear el detalle de los empleados asignados
Feature: Registrar Empleado Accidentado
  Scenario: Registrar empleado accidentado
    Given Accedo a la vista de todos los accidentes
    And Selecciono ver el detalle del primer accidente
    And Cuando hago click en agregar empleados accidentados
    And LLeno los datos del accidentado
      |idEmployee |zonaLesion     |detalleLesion |tipoLesion |fullName  |
      |35         |parte superior |no datos      |leve       |Juan Rojas|
    When Hago click en el boton save
    Then Recargo la pagina
    And Reviso que el empleado a sido creado

  Scenario: Editar empleado Accidentado
    Given Accedo a la vista de todos los accidentes
    And Selecciono ver el detalle del primer accidente
    And Cuando hago click en editar empleado accidentado
    And LLeno los datos del empleado accidentado a editar
      |zonaLesion     |detalleLesion |tipoLesion |fullName  |
      |parte inferior |preguntar     |grave      |Juan Rojas|
    When Hago click en el boton save de editar
    Then Recargo la pagina
    And Reviso que el empleado a sido editado

  Scenario: Eliminar empleado Accidentado
    Given Accedo a la vista de todos los accidentes
    And Selecciono ver el detalle del primer accidente
    And Cuando hago click en eliminar empleado accidentado
    When Hago click en el boton delete para confirmar la seleccion
    Then Reviso que se elimino el detalle del empleado accidentado


  Scenario: Seleccionar Causa
    Given Accedo a la vista de todos los accidentes
    And Selecciono ver el detalle del primer accidente
    When Hago click en el checkbox primero
    And Recargo la pagina
    Then Reviso si esta seleccionado la primera causa

  Scenario: Deseleccionar Causa
    Given Accedo a la vista de todos los accidentes
    And Selecciono ver el detalle del primer accidente
    When Hago click en el checkbox primero
    And Recargo la pagina
    Then Reviso si esta deseleccionado la primera causa
