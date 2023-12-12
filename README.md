# Conversor de idade interplanetário

Esse projeto permite você converta segundos em anos dos seguintes planetas da nossa galáxia: mercúrio, venus, terra,
marte, jupiter, saturno, urano e neturno.

## Estrutura

O projeto tem duas pastas, a primeira sendo a `lib` para incorporar em projetos Java, e a segunda uma API simples
escrita com spring boot para testar a conversão. A `lib` está na pasta "conversor" e a `api` na pasta "api". O
conversor é um projeto maven e a api um projeto gradle que importa a lib gerada do conversor, que deve ficar
dentro da pasta `api/libs`.

**A api é só para fins de teste da conversão e integração da lib.**

## Considerações gerais

Tentei ser o mais simples possível, logo minha solução (a lib) tem um ENUM, o `PlanetsAge`, onde listo os planetas e a
equivalência de seu ano na terra, para facilitar o acesso a essas informações. Tenho uma classe para conversão geral,
a `AgeConversor`, com um método público `convert(long seconds, PlanetsAge planetAge)` que recebe os dados que preciso
para o cálculo. E outra classe que chama a classe de conversão geral, a `AgeConverter`, que tem um método que em vez a
idade equivalente da terra, recebe um enum de um planeta. A ideia é que a `AgeConverter` seja a classe usada por
clientes da lib.

## Boas práticas

* Princípio da responsabilidade única;
* Nomes simples e autoexplicativos, tantos nos métodos quanto em variáveis;
* Uso de constantes no lugar de números mágicos;
* Uso de enums no lugar de Strings;
* Lançamento de exceção para casos de erro e validação;
* Encapsulamento dos métodos, sendo que só são públicos os recursos que podem ser usado fora da classe;
* Testes unitário na lib para garantir seu correto funcionamento;

## Como executar a API para testar a conversão

A api roda com docker, utilizando compose e você pode facilmente testá-la rodando os dois comandos abaixo:

```bash
docker compose build
docker compose up
```

## Testando o conversor

A API tem apenas um endpoint, o `localhost:8080/age-conversor` que é um `POST` e espera o seguinte corpo na requisição,
que são informações necessárias para conversão:

```JSON
{
  "seconds": 2500000000,
  "planet": "neptune"
}
```

**Sendo que:**

* os dois campos obrigatórios
* `seconds` não pode ser igual ou menor que zero
* `planet` aceita apenas um dos seguintes valores: `mercury`, `venus`, `earth`, `mars`, `jupiter`, `saturn` ou `uranus`

Caso algumas das regras acima sejam quebradas a API retornará um erro 400. Caso não, retornará o resultado.

## Incorporando a lib em seu projeto

Caso seja do seu interesse utilizar meu código no seu projeto java, você pode copiar as classes da lib e incluir no seu
projeto, ou publicar ela em um repositório privado, como o nexus. Ou no repositório público do maven se preferir, e
declarar a dependência no `pom.xml`/`build.gradle` do seu projeto.

Também é possível utilizar da forma que utilizei, gerando um pacote da lib (um .jar) com o comando `maven package` e
importando no meu arquivo [build.gradle](api%2Fbuild.gradle):

```groovy
dependencies {
	implementation fileTree('libs') { include '*.jar' }
}
```

## Docker file

Para executar o projeto eu criei um docker file especial, que executa em estágios, como se fosse um pipeline:

1. No primeiro eu gero o JAR da lib de conversão, com usando a imagem `maven:3-openjdk-17`;
2. No segundo copio o JAR gerado para dentro do projeto da API e buildo ela;
3. No terceiro copio as classes e defino o comando de execução da aplicação, o entrypoint;

Ficou algo assim:

```dockerfile
FROM maven:3-openjdk-17 AS build-conversor
...
FROM eclipse-temurin:17-jdk-alpine AS build-api
...
FROM eclipse-temurin:17-jdk-alpine
...
```

# Um pouco sobre mim

Eu caí de paraquedas na área de TI. Lá em 2011 chegou um IFMA em uma cidade vizinha, as vésperas de eu concluir o ensino
fundamental maior e resolvi tentar o curso técnico de TI integrado ao ensino médio, e deu certo, o que eu não sabia é
que ia estudar programação hahahahah. E acabei gostando depois de muito quebrar minha cabeça para entender esse troço.

Depois fiz faculdade de Sistemas de Informação e comecei atuar na área (ainda na metade do curso). E então estou aqui,
com quase 5,5 anos de experiência com desenvolvimento web com java e outras linguagens, como python, ruby e javascript.
Já atuei com inúmeras tecnologias, ferramentas e já passei por muitos desafios.

Na descrição da atividade falava sobre anexar algum projeto, eu não tenho nenhum projeto que eu toque fora do trabalho,
algum negócio e tudo mais. Mas tenho estudado cloud e tenho voltado meus esforços também para entendimento de
arquitetura e design de software. Recentemente criei uma POC Java com Spring e apliquei arquitetura hexagonal nela. Foi
um desafio bem legal, que me tomou alguns dias, e me desafiou a criar um software com baixo acoplamento entre suas
camadas. O link dele é https://github.com/danielarrais/voting-system, lá tem um readme detalhado sobre.

Isso já responde como eu aprendo: experimentando. Quando tenho um desafio ou quero aprender algo novo, eu experimento, e
faço anotações sobre o que aprendi, como foi no caso do projeto **voting-system**. Onde apliquei vários conceitos de
arquitetura, para fixar e assimilar o conhecimento teórico que absorvi lendo artigos e vídeos no YouTube.

## O que torna alguém um bom desenvolvedor na minha visão?

Na minha visão, o que torna alguém um bom desenvolvedor é ele ser muito além de alguém que codifica uma task com base
nos requisitos descritos. Ela tem senso crítico, questiona, sugere e tem amor pelo código que ela escreve, pois tem
visão do negócio e do impacto que ela causa e se preocupa com a qualidade do que está sendo entregue, tanto
no seu contexto micro, quanto no contexto macro, de tudo que envolve o projeto.