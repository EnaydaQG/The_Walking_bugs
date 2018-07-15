# Login feature review the behavior in thie feature
Feature: Crear Empleado

  Scenario Outline: Crear Empleado correctamente
    Given Accedo a la lista de empleados "http://localhost:4200/employees-list"
    When Selecciono Registrar Empleado
    Then Lleno el campo Nombre con "<name>"
    Then Lleno el campo Apellido con "<lastName>"
    Then Lleno el campo Ci "<ci>"
    Then Lleno el campo Fecha de Nacimiento "<birthDate>"
    Then Lleno el campo telefono con "<phone>"
    Then Selecciono en Estado civil la opcion "<civilState>"
    Then Lleno el campo Numero de Dependientes con "<noDep>"
    Then Lleno el campo Genero con "<gender>"
    Then Lleno el campo Experiencia con "<experience>"
    Then Selecciono en Cargo de Empleado la opcion "<position>"
    Then Selecciono en Supervisor la opcion "<supervisor>"
    Then Selecciono en Proyecto la opcion "<project>"
    Then Lleno el campo Fecha de Inicio de Contrato con "<initDate>"
    Then Lleno el campo Fecha de Finalizacion de Contrato con "<finishDate>"
    Then Lleno el campo Fecha de Salario con "<salary>"
    Then Lleno el campo Fecha de Descripcion con "<description>"

  Examples:
  |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
  |Test Name|Test LastName|789456|1992-10-02|478921|Casado/a  |1    |Masculino|Sin experiencia|Arquitecto|Micaela Morado|Vivienda Av. suecia|2005-10-10|2025-10-10|3000  |Contrato basico|
