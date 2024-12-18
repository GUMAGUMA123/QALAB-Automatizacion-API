@petStore
Feature: Validación del API Store en PetStore

  Como automatizador principal del proyecto
  Quiero validar la creación y consulta de órdenes a través del API Store
  Para garantizar su correcto funcionamiento


  Scenario Outline: Creación de una orden en la tienda

    When creo la orden de la mascota con id "<id>", petId "<petId>" y cantidad <cantidad>
    Then el servicio responde con un código de estado <statusCode>
    And el estado de orden es "<statusOrder>"

    Examples:
      | id | petId | cantidad | statusCode | statusOrder |
      | 5  | 3     | 4        | 200        | placed      |
      | 4  | 2     | 3        | 200        | placed      |


  Scenario Outline: Consulta de órdenes existentes

    Given que existe una orden con id "<id>"
    When hago la consulta de la orden con id "<id>"
    Then el servicio responde con un código de estado <statusCode>
    And el estado de orden es "<statusOrder>"

    Examples:
      | id | statusCode | statusOrder |
      | 5  | 200        | placed      |
      | 4  | 200        | placed      |