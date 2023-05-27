# INSTALACAO JAVA + MAVEN

## Configurar as variaveis de ambiente

- JAVA_HOME
- M2_HOME

## Instalar algumas extensoes

- Java + Spring Extesion Pack

## Alguns comandos do maven

- mvn - Serve para buildar o projeto Maven
- mvn -v


## Criar projeto Spring boot

- site: https://start.spring.io/

- Group: Nome do nosso grupo de projetos
- Artifact: Nome do projeto

### Dependencias

- Spring Web: Para pode criar API
- Lombok: Para reduzir codigo
- Spring Data JPA: Para poder usar hibernate
- PostgresSQL: Para pode usar o Postgres
- Spring Boot DevTools: Para o servidor restartar nas mudancas feitas.

### Conceitos

O Spring trabalha com injecao de dependencia, quase todas as anotacoes sao uma extensao de Component, o que permite
a injecao de dependencia por parte do Spring.

A injecao de dependencia pode acontecer atraves do constructor, setter e da anotacao @autowired

````
	public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

````

<br/>

# Novidades do Java

<br/>

````java
public class Main {

    /**
     * Limitar (Selar) o escopo de extend de uma classe, so as classes que podem extender ela.
    */
    public static sealed abstract class Person permits Client {
        protected String name;
    }

    /*
        E necessario dizer se a classe que extend a classe sealed pode fazer o mesmo ou nao.
     * non-sealed
     * final 
     */ 
    public final static class Client extends Person {

        public Client() {
            super();
        }
    }

    public static void main(String ...args) {


    }

    public static void newCast(Object x) {
        if (x instanceof Integer value) {
            System.out.println(value);
        }
    }

    /*
     * 
     * 
     */
    public static void textBlock() {
        var text =  """
                formatacao aqui    
            """;
    }

    /*
     * Agora e possivel criar record, interfaces e enums dentro de funcao.
     */
    public static void createRecordInterfaceEnum() {

        record Name(String v) {};

        interface Name2 {};

        enum Name3 {};

    }
}

````