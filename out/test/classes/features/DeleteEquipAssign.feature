Feature: Eliminar un equipo asignado a un empleado
  Scenario: Eliminación correcta de equipo
    Given Accedo a lista de asignación "http://localhost:4200/employee-list-assignequip"
    When Hago click en botón Ver equipos del primero en la lista
    And Hago click en botón Añadir de lista de equipos
    Then Hago click en selector de equipo
    And Selecciono equipo "Dragas"
    And Hago click en botón Guardar de selección de equipo
    Then Hago click en Editar del último equipo
    And Hago click en botón Eliminar del equipo
    And Verifico que no se encuentre el equipo  "Dragas"
    #Then Cierro el navegador
