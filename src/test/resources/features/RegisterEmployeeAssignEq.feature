Feature: Registrar empleado para asignación de equipo
  Scenario: Registro de asignación de equipo correcto
    Given Accedo a lista de asignación "http://localhost:4200/employee-list-assignequip"
    When Hago click en botón Añadir de asignación
    Then Hago click en selector de empleado
    And Selecciono al empleado "Miranda Clark"
    Then Hago click para desplegar Datepicker
    And Selecciono la fecha actual
    Then Lleno el campo descripción con "Ingreso automatizado de descripcion"
    And Hago click en botón Guardar de asignación
    And Verifico que el último registro sea igual a los siguientes campos
      |Empleado |Miranda Clark|
      |Descripcion | Ingreso automatizado de descripcion|
    Then Cierro el navegador
