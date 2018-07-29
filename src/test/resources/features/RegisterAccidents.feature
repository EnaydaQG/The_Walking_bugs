Feature: Registrar Accidentado

  Scenario ingresar a la lista de accidentes
    Given Accedo a la lista de Accidentes "http://localhost:4200/accident-list"
    Then Selecciono boton Registrar Accidente
   And Lleno los campos con los siguentes datos del accidente
     |tituloAccidente   |lugarAccidente  |grabedadAccidente      |descripcionAccidente         |fechaAccidente     |horaAccidente                 |TipoAccidente       | Area              |
     |test Accidente    |Test altura     |Test fractura          |TEST deslizamiento con carga |2018-07-13 02:00   |2018-06-18T07:00:00.000+0000  | ACCIDENTES RESBALON|Construccion gruesa|

    Then Hago click en SAVE
    And Selecciono el ultimo Registro De Accidente
    And Verifico que los datos sean los ingresados
      |tituloAccidente           |lugarAccidente  |grabedadAccidente      |descripcionAccidente         |fechaAccidente     |horaAccidente                 |TipoAccidente       | Area              |
      |test Accidente editado    |Test altura     |Test fractura          |TEST deslizamiento con carga |2018-07-13 02:00   |2018-06-18T07:00:00.000+0000  | ACCIDENTES RESBALON|Construccion gruesa|

    Then Cierro el navegador
