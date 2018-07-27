# Login feature review the behavior in thie feature
Feature: Crear Empleado

  Scenario Outline: Crear Empleado correctamente
    Given Accedo a la lista de empleados "http://localhost:4200/employees-list"
    Then Selecciono Registrar Empleado
    When Lleno el campo Nombre con "<name>"
    And Lleno el campo Apellido con "<lastName>"
    And Lleno el campo Ci "<ci>"
    And Lleno el campo Fecha de Nacimiento "<birthDate>"
    And Lleno el campo telefono con "<phone>"
    And Selecciono en Estado civil la opcion "<civilState>"
    And Lleno el campo Numero de Dependientes con "<noDep>"
    And Lleno el campo Genero con "<gender>"
    And Lleno el campo Experiencia con "<experience>"
    And Selecciono en Cargo de Empleado la opcion "<position>"
    And Selecciono en Supervisor la opcion "<supervisor>"
    And Selecciono en Proyecto la opcion "<project>"
    And Lleno el campo Fecha de Inicio de Contrato con "<initDate>"
    And Lleno el campo Fecha de Finalizacion de Contrato con "<finishDate>"
    And Lleno el campo de Salario con "<salary>"
    And Lleno el campo de Descripcion con "<description>"
    Then Hago click en Crear Empleado
    And Selecciono el ultimo Empleado creado
    And Verifico si el nombre es "<name>"
    And Verifico si el apellido es "<lastName>"
    And Verifico si el ci es "<ci>"
    And Verifico si la fecha de nacimiento es "<birthDate>"
    And Verifico si el telefono es "<phone>"
    And Verifico si el estado civil es "<civilState>"
    And Verifico si el no de dependientes es "<noDep>"
    And Verifico si el gender es "<gender>"
    And Verifico si la experiencia es "<experience>"
    And Verifico si el cargo es "<position>"
    And Verifico si el supervisor es "<supervisor>"
    And Verifico si el proyecto es "<project>"
    And Verifico si la fecha de inicio es "<initDate>"
    And Verifico si la fecha de finalzacion es "<finishDate>"
    And Verifico si el salario es "<salary>"
    And Verifico si la descripcion es "<description>"
    Then Cierro el navegador

  Examples:
  |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
  |Test Name|Test LastName|789456|1992-10-01|478921|Casado/a  |1    |Masculino|Sin experiencia|Arquitecto|Micaela Morado|Vivienda Av. suecia|2005-10-09|2025-10-09|3000  |Contrato basico|
