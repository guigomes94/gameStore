Feature: Cadastrando produtos

  Scenario: Sucesso para o endpoint /product
    Given Dado o endpoint Post/product
    When Quando recebe uma requisicao post
    Then Entao retorna status http "201"
    And O produto é cadastrado com sucesso.

