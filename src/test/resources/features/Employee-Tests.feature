# This file contains the tests cases to Create an Employee, Update an Employee and Delete an Employee
Feature: Actualizar Empleado

  @114 @115 @116
  Scenario: Actualizar Empleado correctamente
    Given Accedo a la lista de empleados "http://localhost:4200/employees-list"
    Then Selecciono Registrar Empleado
    When LLeno los datos con
      |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
      |Test Name|Test LastName|789456|1992-10-01|478921|Casado/a  |1    |Masculino|Sin experiencia|Arquitecto|Micaela Morado|Vivienda Av. suecia|2005-10-09|2025-10-09|3000  |Contrato basico|
    When Hago click en Crear Empleado
    And Selecciono el ultimo Empleado creado
    And Verifico que los datos del empleado sean
      |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
      |Test Name|Test LastName|789456|1992-10-01|478921|Casado/a  |1    |Masculino|Sin experiencia|Arquitecto|Micaela Morado|Vivienda Av. suecia|2005-10-09|2025-10-09|3000  |Contrato basico|
    And Selecciono la opcion de editar
    And LLeno los datos con
      |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
      |Test Name2|Test LastName2|1000001|1992-10-02|478922|Soltero/a  |2    |Femenino|Con experiencia|Maestro soldador|Pablo Morado|Edificio Palmas|2010-10-09|2030-10-09|6000  |Contrato basico 2|
    Then Hago click en guardar cambios
    And Selecciono el ultimo Empleado creado
    And Verifico que los datos del empleado sean
      |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
      |Test Name2|Test LastName2|1000001|1992-10-02|478922|Soltero/a  |2    |Femenino|Con experiencia|Maestro soldador|Pablo Morado|Edificio Palmas|2010-10-09|2030-10-09|6000  |Contrato basico 2|
    And Hago click en eliminar empleado
    And Selecciono el ultimo Empleado creado
    And Verifico que los datos del empleado no sean
      |name     |lastName     |ci    |birthDate |phone |civilState|noDep|gender   |experience     |position  |supervisor    |project            |initDate  |finishDate|salary|description    |
      |Test Name2|Test LastName2|1000001|1992-10-02|478922|Soltero/a  |2    |Femenino|Con experiencia|Maestro soldador|Pablo Morado|Edificio Palmas|2010-10-09|2030-10-09|6000  |Contrato basico 2|
