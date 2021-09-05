Feature: Consultando clientes

  Scenario: Sucesso
    Given Dado o endpoint Get/clients
    When Quando recebe uma requisicao
    Then Entao retorna todos os clientes