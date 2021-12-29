#language: pt
#Author: Paloma Pedro Rodrigues
#Version: 1.0
#Encoding: UTF-8

@Gorest @regressivo
Funcionalidade: Criar e editar contas de usuários
  Eu como Administrador do sistema, quero cadastrar e editar usuarios do sistema
@post
  Cenario: Cadastrar novo usuário API Gorest
    Dado que possou gorest token valido
    Quando  envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do request deve ser 201

  @get
  Cenario: Buscar um usuário existente na API Gorest
    Dado que possou gorest token valido
    E existe um usuario cadastrado no api
    Quando buscar esse usuario
    Entao os dados dos usuario devem ser retornados
    E o status code do request deve ser 200

  @put
  Cenario: Alterar um usuário existente na API Gorest PUT
    Dado que possou gorest token valido
    E existe um usuario cadastrado no api
    Quando altero os dados do usuario
    Entao o usuario deve ser alterado com sucesso
    E o status code do request deve ser 200

  @patch
  Cenario: Alterar um usuário existente na API Gorest PATCH
    Dado que possou gorest token valido
    E existe um usuario cadastrado no api
    Quando altero  um ou mais dados do usuario
    Entao o usuario deve ser alterado com sucesso
    E o status code do request deve ser 200

  @delete
  Cenario: Deletar um usuário existente na API Gorest
    Dado que possou gorest token valido
    E existe um usuario cadastrado no api
    Quando delete esse usuario
    Entao o usuario é deletado corretamente
    E o status code do request deve ser 204


