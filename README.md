# Relatório Técnico: FiapEShopping - Sistema de E-commerce utilizando Java 17, Spring Boot e Microserviços

## Introdução

O FiapEShopping é um sistema de comércio eletrônico (e-commerce) desenvolvido utilizando tecnologias modernas e práticas de desenvolvimento. Este relatório técnico descreve as principais características, tecnologias utilizadas, arquitetura, e melhores práticas de desenvolvimento adotadas para o projeto.

## Tecnologias Utilizadas

### Linguagem de Programação
- Java 17: Utilizado como linguagem principal de desenvolvimento, fornecendo recursos avançados e melhorias de performance introduzidas nas versões mais recentes.

### Frameworks e Bibliotecas
- Spring Boot: Utilizado para simplificar o desenvolvimento de aplicativos Java, proporcionando um ambiente configurável e produtivo.
- Spring Security: Implementação de autenticação e autorização, garantindo a segurança das APIs do sistema.
- JWT (JSON Web Token): Utilizado para gerenciar sessões de usuário de forma segura e escalável.
- Hibernate Validator: Integração com Spring Boot para validação de dados e formulários.
- Spring Data JPA: Facilita o acesso a dados relacionais, integrando-se com o banco de dados H2.

### Ferramentas de Desenvolvimento
- Spring DevTools: Ferramenta para agilizar o desenvolvimento, proporcionando reload automático e outras funcionalidades úteis.
- Docker: Utilizado para facilitar a implantação e execução dos microserviços em contêineres isolados.
- H2 Database: Banco de dados em memória utilizado para desenvolvimento e testes.

## Arquitetura

O FiapEShopping é baseado em uma arquitetura de microserviços, onde as funcionalidades do sistema são divididas em serviços independentes e modularizados. Cada microserviço é responsável por uma parte específica do sistema, como autenticação de usuários, gerenciamento de produtos, carrinho de compras e pagamento, entre outros. 
### Componentes Principais


### Comunicação entre Microserviços



## Melhores Práticas de Desenvolvimento de Microserviços

## Imagens das Requisições

<details>
<summary>Requisições realizadas</summary>

![requisicoes.jpeg](Images%2Frequisicoes.jpeg)
</details>

<details>
<summary> Cadastro Ok </summary>

![cadastro-ok.jpeg](Images%2Fcadastro-ok.jpeg)
</details>

<details>
<summary> Login gerando Token </summary>

![login-token.jpeg](Images%2Flogin-token.jpeg)
</details>

<details>
<summary> Listando usuários </summary>

![listando-usuario.jpeg](Images%2Flistando-usuario.jpeg)
</details>

<details>
<summary> Cadastro Carrinho sem Token </summary>

![cadastro-carrinho-sem-token.jpeg](Images%2Fcadastro-carrinho-sem-token.jpeg)
</details>

<details>
<summary> Cadastrar carrinho com usuário logado passando Token </summary>

![cadastro-carrinho-usuario-logado-passando-token.jpeg](Images%2Fcadastro-carrinho-usuario-logado-passando-token.jpeg)
</details>

<details>
<summary> Cadastro de produtos sem Token </summary>

![cadastro-produtos-sem-token.jpeg](Images%2Fcadastro-produtos-sem-token.jpeg)
</details>

<details>
<summary> Cadastro de produtos solicitando o bearer Token </summary>

![cadastro-produtos-solicitando-bearer-token.jpeg](Images%2Fcadastro-produtos-solicitando-bearer-token.jpeg)
</details>

<details>
<summary> Produto cadastrado com sucesso após a validação do token </summary>

![cadastro-produto-sucesso-validacao-token.jpeg](Images%2Fcadastro-produto-sucesso-validacao-token.jpeg)
</details>

<details>
<summary> Tentando efetuar a compra sem o usuário estar logado </summary>

![tentativa-efetuar-compra-sem-usuario-logado.jpeg](Images%2Ftentativa-efetuar-compra-sem-usuario-logado.jpeg)
</details>

<details>
<summary> Compra efetuada com sucesso após o usuário logado e passado token sem sessão </summary>

![compra-efetuada-usuario-logado-passando-token.jpeg](Images%2Fcompra-efetuada-usuario-logado-passando-token.jpeg)
</details>

<details>
<summary> Tentativa de pagamento sem sucesso com usuário sem validação via token </summary>

![tentativa-pagamento-sem-sucesso-usuario-sem-validacao-token.jpeg](Images%2Ftentativa-pagamento-sem-sucesso-usuario-sem-validacao-token.jpeg)
</details>

<details>
<summary> Validação se o carrinho é existente e valido pelo login do usuário: </summary>

![validacao-usuario-existente-e-valido-login-usuario.jpeg](Images%2Fvalidacao-usuario-existente-e-valido-login-usuario.jpeg)
</details>

<details>
<summary> Login correto via token e UUID id carrinho correto (Pagamento efetuado com sucesso)</summary>

![login-correto-token-UUID-id-carrinho-correto.jpeg](Images%2Flogin-correto-token-UUID-id-carrinho-correto.jpeg)
</details>

<details>
<summary> Deletando Item do carrinho, caso Usuário queira desistir do produto: </summary>

![deletando-item-carrinho-caso-usuario-desista-produto.jpeg](Images%2Fdeletando-item-carrinho-caso-usuario-desista-produto.jpeg)

> OBS:
> opção executada somente após validação de sessão token, ID  produto para retirar produto correto e ID do carrinho para validar que está tirando do carrinho correto:

![deletando-item-carrinho-caso-usuario-desista-produto-obs.jpeg](Images%2Fdeletando-item-carrinho-caso-usuario-desista-produto-obs.jpeg)
</details>

## Considerações Finais

O FiapEShopping é um sistema de e-commerce robusto e escalável, desenvolvido utilizando as melhores práticas de desenvolvimento de microserviços e as tecnologias mais recentes do ecossistema Java e Spring Boot. A utilização de contêineres Docker facilita a implantação  em ambientes diversos. Este relatório técnico fornece uma visão geral do sistema e das tecnologias utilizadas, destacando os principais aspectos arquiteturais e de desenvolvimento.
