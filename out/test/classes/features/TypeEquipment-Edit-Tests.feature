# This file contains the tests cases to , Update an TypeEquipment
Feature: Actualizar tipo de Equipos

  @114 @115 @116
  Scenario: Actualizar tipo de Equipos correctamente
    Given Accedo a la lista de tipo de Equipos "http://localhost:4200/type-equipment"
    Then Ingreso a editar el primer tipo de Equipo creado
    When LLeno los datos con
      |name     |descriptionTypeEquipment     |
      |Tools|Tools Description|
    When Hago click en Save


