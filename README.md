# Projeto

![dscatalog-catalog](http://www.seasolutions.io/image/layout_set_logo?img_id=90106&t=1628882957824)

<p align="center">
	• <a href="#descricao">Descrição</a> •
	<a href="#versionamento">Versionamento</a> •
	<a href="#arquitetura">Arquitetura</a> •
	<a href="#documentacao">Documentação</a> •
	<a href="#tecnologias-dependencias">Tecnologias e Dependências</a> •
</p>  

<h1 id="descricao">
	<img src="https://img.icons8.com/external-tal-revivo-color-tal-revivo/24/000000/external-readme-is-a-easy-to-build-a-developer-hub-that-adapts-to-the-user-logo-color-tal-revivo.png"/>
  Descrição
</h1>

<p align="justify"> &emsp;&emsp;&emsp;Projeto desenvolvido para o processo seletivo do cargo de Desenvolvedor Back-End na empresa Sea Solution. O objetivo do projeto foi implementar o back-end de um cadastro de funcionários, cargos e setores de uma empresa. </p>

<h1 id="versionamento">
<img src="https://img.icons8.com/officel/30/000000/compare-git.png"/>
  Versionamento do Código
</h1>

<p text-align="justify">&emsp;&emsp;&emsp;O versionamento de projeto foi feito localmente através do <a href="https://git-scm.com/">Git</a> e remotamente através do <a href="https://github.com/">GitHub</a>. </p>

<h1 id="arquitetura">
<img src="https://img.icons8.com/office/30/000000/blueprint.png"/>
  Arquitetura
</h1>

<p text-align="justify">&emsp;&emsp;&emsp;A arquitetura do projeto segue o padrão MVC, com a adição de uma camada de Service na qual são incluídas as regras de negócio e uma camada de Repository, na qual são criadas as queries executadas no banco de dados. Também foram criados pacotes auxiliates para o desenvolvimento do projeto.</p>

<p align="center">  
  <img align="center" src="https://github.com/filipelustosaf/ProjetoSeaSolutions/blob/da6ac17a665fbf7cf5db3285a5c39836dd7c0259/Imagens/Arquitetura%20do%20Projeto.png" width="500px" />
</p>

<p text-align="justify">&emsp;&emsp;&emsp; Foram criadas três classes principais, no desenvolvimento da API, que podem ser visualizadas no diagrama abaixo. </p>

<p align="center">  
  <img align="center" src="https://github.com/filipelustosaf/ProjetoSeaSolutions/blob/da6ac17a665fbf7cf5db3285a5c39836dd7c0259/Imagens/Diagrama.png" width="500px" />
</p>

<h1 id="documentacao">
<img height="30" src="https://img.icons8.com/color/48/000000/documents.png"/>
  Documentação
</h1>

### Endpoints

Breve descrição dos endpoints da aplicação.

<details>
  <summary>Trabalhador</summary>
<br>
  
Retorna o trabalhador a partir do id.
``` ruby
GET /trabalhadores/{id}
```

Retorna uma lista com todos os trabalhadores.
``` ruby
GET /trabalhadores
```
	
Cria um trabalhador.
``` ruby
POST /trabalhadores
```

Altera os dados de um trabalhador a partir do id.
``` ruby
PUT /trabalhadores/{id}
```

Deleta um trabalhador a partir do id.
``` ruby
DELETE /trabalhadores/{id}
```
  
Retorna uma lista de trabalhadores por sexo.
``` ruby
GET /trabalhadores/sexo/{sexo}
```

Retorna uma lista de trabalhadores por cargo.
``` ruby
GET /trabalhadores/cargo/{cargo}
```
	
Retorna uma lista de trabalhadores por setor.
``` ruby
GET /trabalhadores/setor/{setor}
```
	
</details>

<details>
  <summary>Cargo</summary>
<br>
  
Retorna o cargo a partir do id.
``` ruby
GET /cargos/{id}
```

Retorna uma lista com todos os cargos.
``` ruby
GET /cargos
```
	
Cria um cargo.
``` ruby
POST /cargos
```

Altera os dados de um cargo a partir do id.
``` ruby
PUT /cargos/{id}
```

Deleta um cargo a partir do id.
``` ruby
DELETE /cargos/{id}
```
  
Retorna uma lista de cargos por setor.
``` ruby
GET /cargos/setor/{setor}
```
	
</details>

<details>
  <summary>Setor</summary>
<br>
  
Retorna o setor a partir do id.
``` ruby
GET /setores/{id}
```

Retorna uma lista com todos os setores.
``` ruby
GET /setores
```
	
Cria um setor.
``` ruby
POST /setores
```

Altera os dados de um setor a partir do id.
``` ruby
PUT /setores/{id}
```

Deleta um setor a partir do id.
``` ruby
DELETE /setores/{id}
```
	
</details>

<h1 id="tecnologias-dependencias">
<img height="30" src="https://img.icons8.com/fluency/50/000000/administrative-tools.png"/>
	Tecnologias e Dependências
</h1>

<a name = "tech_stack"></a>

- [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) - Versão do Java utilizada
- [Spring boot](https://spring.io/projects/spring-boot) - Framework de desenvolvimento
- [Maven](https://maven.apache.org/) - Gerenciador de dependencias
- [H2 Database](https://www.h2database.com/html/main.html) - Database
- [Spring Data Jpa](https://spring.io/projects/spring-data-jpa) - Abstração orm do spring pra integração com o banco de dados
- [Postman](https://www.postman.com/) - Ferramenta para testes nas requisições
- [Lombok](https://projectlombok.org/) - Framework para melhora na legibilidade do código
