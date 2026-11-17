# Java 11 — Platform Changes

Este documento reúne as principais alterações introduzidas na plataforma Java 11, incluindo remoções de módulos, descontinuações e alterações com impacto na compatibilidade de aplicações desenvolvidas em versões anteriores do JDK.

---

## 1. JEP 320 — Removal of Java EE and CORBA Modules

### Contexto

Até ao Java 8, o JDK incluía várias APIs associadas às tecnologias Java EE e CORBA.

Estas APIs podiam ser utilizadas diretamente pelas aplicações, sem necessidade de declarar dependências externas para as disponibilizar.

Com o Java 11, vários destes módulos foram removidos do JDK, passando a ser necessário recorrer a bibliotecas externas ou a funcionalidades disponibilizadas pelo servidor de aplicações.

### Principais módulos removidos

| Módulo | Tecnologia / Funcionalidade |
|---|---|
| `java.xml.bind` | JAXB — Java Architecture for XML Binding |
| `java.xml.ws` | JAX-WS — Java API for XML Web Services |
| `java.xml.ws.annotation` | Anotações relacionadas com Web Services |
| `java.activation` | JavaBeans Activation Framework |
| `java.transaction` | Java Transaction API |
| `java.corba` | CORBA |
| `java.se.ee` | Agregador de APIs Java EE |
| `jdk.xml.bind` | Ferramentas JAXB |
| `jdk.xml.ws` | Ferramentas JAX-WS |

### Impacto no desenvolvimento

Aplicações que utilizavam diretamente estas APIs podem deixar de compilar ou executar após a migração para Java 11, caso não tenham as dependências necessárias.

Exemplos de packages afetados:

- `javax.xml.bind`
- `javax.xml.ws`
- `javax.xml.soap`
- `javax.activation`
- `javax.transaction`
- `org.omg.CORBA`

A remoção dos módulos não significa que todos os packages `javax.*` tenham desaparecido do JDK. Por exemplo, `javax.sql`, `javax.crypto` e `javax.net.ssl` continuam disponíveis.

### Exemplo: JAXB

No Java 8, era possível utilizar JAXB sem declarar dependências externas no Maven:

```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

JAXBContext context = JAXBContext.newInstance(Person.class);

Marshaller marshaller = context.createMarshaller();

marshaller.marshal(person, System.out);
```

No Java 11, é necessário disponibilizar a API e a implementação JAXB através de dependências externas.

Exemplo de dependências Maven compatíveis com o namespace `javax.xml.bind`:

```xml
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>

<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.8</version>
</dependency>
```

Estas versões utilizam JAXB 2.x. As versões Jakarta XML Binding 3.x e posteriores utilizam o namespace `jakarta.xml.bind`, exigindo alterações nos imports e potencialmente no código.

### Impacto na migração Java 8 → Java 11

Durante a migração, devem ser identificadas:

- Dependências JAXB utilizadas na conversão entre objetos Java e XML.
- Implementações JAX-WS utilizadas em Web Services SOAP.
- Dependências SAAJ utilizadas na manipulação de mensagens SOAP.
- Bibliotecas que dependem de CORBA.
- APIs de transações utilizadas diretamente pela aplicação.
- Ferramentas externas anteriormente disponibilizadas pelo JDK, como `wsimport`, `wsgen` e `xjc`.

A análise deve considerar também as funcionalidades disponibilizadas pelo servidor de aplicações, uma vez que determinadas APIs podem continuar a ser fornecidas pelo ambiente de execução.

### Conclusão

O JEP 320 representa uma alteração à composição do JDK, e não à linguagem Java.

O seu principal impacto está nas aplicações empresariais que dependiam de APIs anteriormente incluídas na plataforma. A migração para Java 11 exige a identificação dessas dependências e a sua disponibilização através de bibliotecas externas ou do servidor de aplicações.

**Referência:** [JEP 320 — Remove the Java EE and CORBA Modules](https://openjdk.org/jeps/320)

---

## 2. JavaFX — Separação do JDK

### Contexto

Até ao Java 8, o JavaFX era distribuído juntamente com o JDK, permitindo desenvolver aplicações desktop com interfaces gráficas sem necessidade de adicionar dependências externas específicas.

A partir do Java 11, o JavaFX deixou de fazer parte integrante do JDK, passando a ser distribuído e mantido separadamente através do projeto OpenJFX.

Esta alteração não significa que o JavaFX tenha sido removido ou descontinuado. Continua a ser possível desenvolver aplicações desktop Java utilizando esta tecnologia.

### O que é o JavaFX?

JavaFX é uma plataforma para desenvolver aplicações desktop com interfaces gráficas em Java.

Disponibiliza componentes e funcionalidades como:

- `Stage` — janela principal da aplicação.
- `Scene` — conteúdo visual apresentado numa janela.
- `Button`, `Label` e `TextField` — componentes gráficos.
- `TableView` — apresentação de dados tabulares.
- `FXML` — definição declarativa de interfaces.
- CSS — personalização visual.

### Principais alterações no Java 11

- O JavaFX deixou de ser distribuído juntamente com o JDK.
- O desenvolvimento passou a ser mantido separadamente através do projeto OpenJFX.
- As aplicações passaram a necessitar de dependências JavaFX explícitas.
- A configuração de compilação e execução pode exigir módulos JavaFX específicos.

### OpenJFX e dependências Maven

O OpenJFX disponibiliza os módulos necessários ao desenvolvimento de aplicações JavaFX.

Numa aplicação Maven, podemos adicionar os módulos necessários através de dependências.

Exemplo de configuração para JavaFX 11:

```xml
<properties>
    <javafx.version>11.0.2</javafx.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>${javafx.version}</version>
    </dependency>

    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>${javafx.version}</version>
    </dependency>
</dependencies>
```

Os principais módulos disponíveis incluem:

| Módulo | Finalidade |
|---|---|
| `javafx-base` | Funcionalidades fundamentais e propriedades observáveis |
| `javafx-graphics` | Gráficos, janelas e sistema visual |
| `javafx-controls` | Botões, tabelas, listas e outros controlos |
| `javafx-fxml` | Integração com interfaces FXML |
| `javafx-media` | Reprodução de áudio e vídeo |
| `javafx-web` | Componente WebView |

Não é necessário adicionar todos os módulos. Devem ser declarados apenas os que a aplicação utiliza.

### Exemplo de uma aplicação JavaFX

Uma aplicação simples pode utilizar a classe `Application`:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello JavaFX 11!");

        Scene scene = new Scene(label, 400, 200);

        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

O código Java continua a utilizar as APIs JavaFX. A diferença está na forma como essas APIs são disponibilizadas ao projeto.

### Impacto na migração Java 8 → Java 11

Durante uma migração, devemos verificar:

- Se a aplicação utiliza JavaFX.
- Se existem dependências JavaFX disponibilizadas implicitamente pelo ambiente de desenvolvimento.
- Se o projeto Maven ou Gradle declara os módulos necessários.
- Se a configuração de execução disponibiliza os módulos JavaFX corretos.
- Se a aplicação utiliza FXML, CSS, WebView ou componentes adicionais.

Uma aplicação JavaFX que anteriormente dependia apenas da instalação do JDK pode deixar de compilar ou executar depois da migração.

### Conclusão

A separação do JavaFX do JDK representa uma alteração na distribuição e gestão das dependências, não uma alteração à linguagem Java.

O JavaFX continua a ser uma tecnologia válida para desenvolver aplicações desktop, mas passou a exigir configuração e dependências próprias.

### Referências

- [OpenJFX — Documentação oficial](https://openjfx.io/)
- [OpenJFX — Getting Started](https://openjfx.io/openjfx-docs/)

## 3. JEP 335 — Deprecation of Nashorn

### Contexto

Nashorn era um motor JavaScript desenvolvido pela Oracle e integrado no JDK a partir do Java 8.

Permitia executar código JavaScript a partir de aplicações Java através da API `javax.script`, disponibilizando funcionalidades de integração entre Java e JavaScript.

### O que mudou no Java 11?

O JEP 335 introduziu a descontinuação oficial do Nashorn e da ferramenta de linha de comandos `jjs`.

Esta alteração significa que:

- Nashorn continuava disponível no Java 11.
- A API `javax.script` continuava disponível.
- A utilização de Nashorn passou a estar formalmente descontinuada.
- A sua utilização não era recomendada para novos desenvolvimentos.

É importante distinguir descontinuação de remoção: Nashorn só foi efetivamente removido do JDK no Java 15, através do JEP 372.

### Exemplo de utilização no Java 8

O seguinte exemplo demonstra a execução de JavaScript através da API `ScriptEngine`:

```java
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

    public static void main(String[] args)
            throws ScriptException {

        ScriptEngineManager manager =
                new ScriptEngineManager();

        ScriptEngine engine =
                manager.getEngineByName("nashorn");

        Object result = engine.eval(
                "var message = 'Hello from JavaScript'; message;"
        );

        System.out.println(result);
    }
}
```

Resultado esperado:

```text
Hello from JavaScript
```

### Alternativas

Uma das alternativas ao Nashorn é o GraalJS, motor JavaScript disponibilizado pelo ecossistema GraalVM.

Permite executar JavaScript em ambientes Java através da GraalVM Polyglot API.

### Impacto na migração Java 8 → Java 11

Durante a migração, devem ser identificadas:

- Utilizações de `ScriptEngineManager`.
- Chamadas a `getEngineByName("nashorn")`.
- Execução de scripts JavaScript através da aplicação.
- Dependências da ferramenta `jjs`.
- Necessidade de substituir Nashorn por outro motor JavaScript.

### Conclusão

O JEP 335 introduziu a descontinuação do Nashorn no Java 11, preparando a sua remoção numa versão posterior do JDK.

Não representa uma alteração à linguagem Java, mas sim à disponibilização de um motor JavaScript integrado na plataforma.

### Referências

- [JEP 335 — Deprecate the Nashorn JavaScript Engine](https://openjdk.org/jeps/335)
- [JEP 372 — Remove the Nashorn JavaScript Engine](https://openjdk.org/jeps/372)
- [GraalVM](https://www.graalvm.org/)