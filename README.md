﻿
Controle da Farmácia

O projeto "Controle da Farmácia" é uma aplicação Java desenvolvida para gerenciar o estoque de produtos de uma farmácia, incluindo medicamentos e produtos de higiene. A aplicação permite cadastrar, atualizar, listar e buscar produtos, além de calcular automaticamente o preço de venda com base no percentual de lucro definido.

Funcionalidades

- Cadastro de Produtos: Permite o cadastro de novos produtos no sistema, incluindo medicamentos e produtos de higiene.
-  Cálculo de Preço de Venda: Calcula o preço de venda dos produtos com base no preço de compra e no percentual de lucro.
- Busca de Medicamentos por Nome: Permite buscar medicamentos cadastrados no sistema pelo nome.
- Alteração de Dados: Permite alterar as informações dos produtos cadastrados.
- Relatório de Produtos em Estoque: Exibe uma lista detalhada de todos os produtos em estoque, incluindo código, descrição, preço de compra, percentual de lucro e preço de venda.
- Exibição do Produto Mais Caro: Mostra os detalhes do produto mais caro em estoque.

Tecnologias Utilizadas

- Java: Linguagem de programação utilizada para desenvolver a aplicação.
- Swing: Biblioteca gráfica utilizada para criar a interface do usuário.
- JOptionPane: Utilizado para interações e diálogos com o usuário.

Estrutura do Código

- Classe Produto: Classe abstrata que define os atributos e métodos comuns aos produtos.
- Classe Higiene: Extende a classe Produto e implementa métodos específicos para produtos de higiene.
- Classe Remedio: Extende a classe Produto e implementa métodos específicos para medicamentos.
- Classe ControleDaFarmacia: Contém o método main e as funcionalidades principais da aplicação, como menu e operações de cadastro, busca e exibição de produtos.



