# This file contains the tests cases to Create an TypeEquipment
Feature: Registrar tipo de Equipos

  @114 @115 @116
  Scenario: Registrar tipo de Equipos correctamente
    Given Accedo a la lista de tipo de Equipos "http://localhost:4200/type-equipment"
    Then Selecciono Add

    When LLeno los datos con
      |name     |descriptionTypeEquipment     |
      |Test Name|Test Description|
    When Hago click en Save

    Then Cierro el navegador

