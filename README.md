# Exceções em Java

Java utiliza um sistema de tratamento de exceções para lidar com erros durante a execução de um programa. Exceções são eventos que interrompem o fluxo normal de execução e podem ser causadas por diversos motivos.

## Tipos de Exceções

Existem dois tipos principais de exceções em Java:

- **Checked Exceptions:** Devem ser tratadas explicitamente pelo programador. Exemplos incluem `IOException` e `SQLException`.

- **Unchecked Exceptions (ou RuntimeExceptions):** Não exigem tratamento explícito. Exemplos incluem `NullPointerException` e `ArrayIndexOutOfBoundsException`.

## Tratando Exceções

Para lidar com exceções, utilize a estrutura try-catch. Use a cláusula finally para definir um bloco de código que será executado independentemente de uma exceção ter sido lançada ou não.
:

```java
try {
    // Código que pode lançar uma exceção
} catch (TipoDeExcecao e) {
    // Código para lidar com a exceção
} finally{
// Código que executa independente do lançamento de execeção
}
Use a cláusula finally para definir um bloco de código que será executado independentemente de uma exceção ter sido lançada ou não.
