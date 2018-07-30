# This file contains the tests cases to  Delete an TypeEquipment
Feature: Eliminar tipo de Equipos

  @114 @115 @116
  Scenario: Eliminar tipo de Equipos correctamente

    Given Accedo a la lista de tipo de Equipos "http://localhost:4200/type-equipment"
    Then Ingreso a editar el primer tipo de Equipo creado

    When Hago click en Delete

