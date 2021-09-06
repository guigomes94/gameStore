Feature: Consultando clientes

  Scenario: Sucesso para o endpoint /clientes
    Given Dado o endpoint Get/clients
    When Quando recebe uma requisicao
    Then Entao retorna todos os clientes

  Scenario: Sucesso para o endpoint /clientes/id
    Given Dado o endpoint Get/clients/id
    When Quando recebe uma requisicao para o endpoint Get/clients/id
    Then Entao retorna o cliente que contem o id