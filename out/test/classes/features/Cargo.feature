# This Feature: contains the tests cases to Create an Position, Update an Position and Delete an Position

Feature:Crear Actualizar y Eliminar posicion

  @120 @121 @122
  Scenario: Crear un cargo
    Given Accedo a la lista de posiciones "http://localhost:4200/positionList"
    Then Hago click en Crear Cargo
    When LLeno los datos para posición con
      |code      |name      |higherWorkPosition |area        |process      |purpose|
      |codeTest01|nameTest02|Gerente de proyecto|Electricidad|processTest05|purposeTest06|
    When Hago click en guardar cambios para posición
    Then Verificar los datos de la position nueva
      |code      |name      |higherWorkPosition |area        |process      |purpose|
      |codeTest01|nameTest02|Gerente de proyecto|Electricidad|processTest05|purposeTest06|
    #Test Edit Position
    When LLeno los datos para posición con
      |code        |name        |higherWorkPosition |area        |process      |purpose|
      |codeTestEdit|nameTestEdit|Gerente de proyecto|Plomeria|processTestEdit|purposeTestEdit|
    When Hago click en guardar cambios para posición
    Then Verificar los datos de la position nueva
      |code        |name        |higherWorkPosition |area        |process      |purpose|
      |codeTestEdit|nameTestEdit|Gerente de proyecto|Electricidad|processTestEdit|purposeTestEdit|
    #Test Delete Position
    Then Hago click en eliminar position
    And Verifico que la position no existe
      |name        |
      |nameTestEdit|
    #Then Cierro el navegador