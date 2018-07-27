Feature: Registrar Accidentado

  Scenario Outline: ingresar a la lista de accidentes
    Given Accedo a la lista de Accidentes "http://localhost:4200/accident-list"
    Then Selecciono Registrar a empleado accidentado
    When seleccionar el boton para registrar accidente
    And Lleno el campo con titulo de accidente "<titulo Accidente>"
    And Lleno el campo lugar del accidente "<lugar Accidente>"
    And Lleno el campo  grabedad del accidente"<grabedad del accidente>"
    And Lleno el campo  decripcion del accidente"<descripcion del accidente>"
    And Lleno el campo fecha del accidente"<fecha del accidente>"
    And Lleno el campo hora del accidente  "<hora del accidente>"
    And Selecciono  el campo Tipo de accidnetes "<Tipo de accidente>"
    And Selecciono el area donde suscedio el accidente "<Area>"
    Then Hago click en SAVE
    And Selecciono el ultimo Accidente registrado
    Then Cierro el navegador

    Examples:
      |titulo Accidente  |lugar Accidente |grabedad del accidente |descripcion del accidente    |fecha del accidente|hora del accidente            |Tipo de accidente   | Area              |
      |test Accidente    |Test altura     |Test fractura          |TEST deslizamiento con carga |2018-07-13 02:00   |2018-06-18T07:00:00.000+0000  | ACCIDENTES RESBALON|Construccion gruesa|
