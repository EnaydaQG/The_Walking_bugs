Feature: Editar un equipo asignado a un empleado
  Scenario: Edición correcta de un equipo
    Given Accedo a lista de asignación "http://localhost:4200/employee-list-assignequip"
    When Hago click en botón Ver equipos del primero en la lista
    And Hago click en botón Editar del primero en la lista de equipos
    Then Hago click en selector de equipo para editar
    And Selecciono equipo para editar "Compresora"
    And Hago click en botón Guardar de edición de equipo
    And Verifico que el primer equipo sea  "Compresora"
    Then Cierro el navegador