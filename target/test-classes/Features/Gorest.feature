#language: pt
#Author: Paloma Pedro Rodrigues
#Version: 1.0
#Encoding: UTF-8

@Gorest
Funcionalidade: Criar e editar contas de usuários
  Eu como Administrador do sistema, quero cadastrar e editar usuarios do sistema

  Cenario: Cadastrar novo usuário API Gorest
    Dado que possou gorest token valido
    Quando  envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do request deve ser 201

  Cenario: Cadastrar novo usuário API Gorest
    Dado que possou gorest token valido
    Quando  envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do request deve ser 201