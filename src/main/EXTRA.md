# Jackson

O Spring Boot utiliza o Jackson para converter um objeto em JSON.

## Anotacoes

**@JsonProperty**:
    Serve para alterar a propriedade do objeto que sera retornada.

````java

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    // Essa anotação é usada para indicar que uma propriedade deve ser ignorada durante a desserialização (leitura) de um objeto JSON. Em outras palavras, quando um objeto JSON é convertido para uma instância de uma classe Java, essa propriedade será ignorada e seu valor não será atribuído à propriedade correspondente no objeto Java.

````

````java
    @JsonProperty("_id");
    private Long id;
````
**@JsonIgnore**: 
    Para ignorar uma propriedade de um objeto no envio do JSON.

**@ResponseBody**:
    Indica que o valor retorno devera ser convertido para JSON. Por padrao o Spring boot inclui essa anotacao de forma oculta para todos os metodos de um controlador anotado por @RestController.

**@Bean**:
    Sim, na anotação @Bean, é possível realizar a injeção de dependência automaticamente se houver outros objetos gerenciados pelo Spring Boot disponíveis no contexto do aplicativo.

    Quando você declara um método anotado com @Bean, o Spring Boot é responsável por chamar esse método e criar o objeto correspondente. Durante esse processo, o Spring Boot verifica o contexto do aplicativo em busca de outros beans gerenciados e verifica se eles podem ser injetados como dependências no método @Bean.

    Para que a injeção de dependência ocorra automaticamente, os beans devem estar disponíveis no contexto do aplicativo do Spring Boot. Isso pode ser feito por meio de configurações ou declarações de outros beans em classes anotadas com @Configuration ou componentes escaneados automaticamente pelo Spring, como classes anotadas com @Component, @Service ou @Repository.

**RestController**

**Controller**

**RequestMapping**

**GetMapping**

**PostMapping**

**PutMapping**

**DeleteMapping**

**Repository**

**CrossOrigin**

**Autowired**

**Component**

**RequestBody**

**ResponseStatus**

**PathVariable** - http://localhost:port/name/{variavel}

**Service**

# Clases 

**JpaRepository**

**ResponseEntity**


# Java Bean Validation (Anotacoes)

A Java Bean Validation é uma especificação da plataforma Java que define um conjunto de anotações e APIs para realizar a validação de dados em objetos Java.

Vale ressaltar que a Java Bean Validation é apenas uma especificação, e para utilizá-la em sua aplicação Java, é necessário ter uma implementação da especificação. Uma implementação popular é o Hibernate Validator.

**NotNull**

**NotBlank**

**Length**

**Pattern**

**Valid** - Verifica se o Objeto que veio via JSON de acordo com as validacoes
que fizemos.

**Positive**

**Validated** - Para ativar validacoes em parametros de funcao.


# Hibernate (Anotacoes)

**SQLDelete** 

**SQLUpdate**

**Where** - No Select executado pelo JpaRepository


# Service

O repositorio ao inves de ficar no controller fica na classe de service e o service no controler, ela
e responsavel por aplicar nossas regras de negocio.


# Controller Advice 

Controlador responsavel por direcionar a exececao lancada por outros controladores.

**RestControllerAdvice** 

**ExceptionHandler**

# Data Transfer Object ( DTO )

E uma classe que vai representar a informacao do objeto de requisicao que eu
quero receber. Atualmente estao utilizando record para fazer DTO ao inves de uma 
classe normal, ja que record e imutavel. A Record nao pode extender outras classes, mas pode implementar
interfaces. Pode adicionar @anotacoes nas records.

Elas nao podem ser usadas com JPA porque o JPA pede que tenha um constructor vazio
para setar os dados no setters.

DTO ajuda a esconder alguns propriedades que nao queremos exibir no enviar na resposta.

```
    NameDTO.java # CourseDTO.java

    public record NameDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull String name
    );
```

O service sera responsavel por retornar DTO e inserir DTO no banco.

# Padrao Mapper

Ele automatiza a conversao de Classe para ClasseDTO.


## Feito manualmente o Mapper

```java
    @Component
    public class NameMapper {

    }
```

# Persistir Enums com JPA e Converter automaticamente

````java

    public enum Name {
        VALUE, VALUE
    }

    @Entity
    public class Name {

        @Enumerated(EnumType.ORDINAL) // @Enumerated(EnumType.STRING)
        @Convert(converter = NameConverter.class)
        private Enum propertyName;
    }

    // Server para avisar o Spring Data como eu quero salvar o Enum no banco de dados.
    @Converter(autoApply = true) // Fala pro Spring aplicar a conversao do enum automaticamente
    public class NameConverter implements AttributeConverter<Enum, Type> {
        // Implementar os metodos da interface AttributeConverter
    }

````

## Fazendo um exemplo

````java

    public enum Status {
        ACTIVE("Ativo"), INACTIVE("Inativo");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    @Converter(autoApply = true)
    public class StatusConverter implements AttributeConverter<Status, String> {


        public Status convertToEntityAttribute(String value) {
            if (value == null) return null;
            return Stream.of(Status.values()).filter( status -> status.intern() == value).findFirst().orElse(IllegalArgumentException::new);
        }
    }


````