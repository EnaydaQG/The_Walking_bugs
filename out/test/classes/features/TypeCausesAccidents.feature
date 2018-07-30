Feature: verificar la edicion de tipos de accidentes

  Scenario ingresar al campo tipos de accidentes
    Given Accedo al campo tipos de Accidentes "http://localhost:4200/accident-type"
    Then Llenando los campos con
    |nameTypeAccident     |codeTypeAccident|
    |derrumbe de siminetos|TCDS            |
    And Hago click en editar
    Then Cierro el navegador

