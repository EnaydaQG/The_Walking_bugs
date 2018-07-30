Feature: gestion de proyectos
  Scenario: Registrar un proyecto nuevo
    Given  ingreso a la lista de proyectos registrados "http://localhost:4200/projects"
    Then   Hago click en Create new Project
    When   Ingreso el nombre de proyecto y gestion con
      |name          | gestion    |
      |nombreTestAuto| 2018-2020  |
    And   guardo haciendo  click en Save
    Then   Verificar que se muestra el proyecto creado con nombre "nombreTestAuto"
  # Test Eliminar proyecto
    When  hago click en el boton editar del proyecto creado.
    And Verifico que  el nombre sea del proyecto editado "nombreTestAuto"
    Then hacer click en el boton elminar
    And verificar que no existe proyecto con nombre "nombreTestAuto"

