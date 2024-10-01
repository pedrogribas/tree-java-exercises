
# BinaryTree

Esta classe implementa uma árvore binária em Java, permitindo operações básicas como inserção, remoção e diferentes métodos de travessia (navegação) da árvore.

## Índice

- [Características](#características)
- [Instalação](#instalação)
- [Uso](#uso)
- [Métodos](#métodos)
- [Exemplo de Uso](#exemplo-de-uso)

## Características

- **Inserção**: Insere novos nós na árvore, garantindo que não haja duplicatas.
- **Remoção**: Remove nós da árvore, mantendo a estrutura da árvore binária.
- **Navegação**: Oferece métodos para travessia da árvore em pré-ordem, em-ordem e pós-ordem, tanto de forma recursiva quanto iterativa.
- **Contagem de Nós**: Permite contar o total de nós, nós não-folhas e nós-folhas na árvore.
- **Altura da Árvore**: Calcula a altura da árvore.
- **Remoção de Pares**: Remove todos os nós com valores pares.
- **Inversão da Árvore**: Inverte a estrutura da árvore.
  
## Instalação

1. Certifique-se de ter o JDK instalado no seu sistema.
2. Crie um novo projeto Java e adicione esta classe ao seu projeto.

## Uso

Para usar a classe `BinaryTree`, você deve instanciar um objeto dela e utilizar seus métodos para realizar operações desejadas.

## Métodos

### `BinaryTree()`

Construtor que inicializa uma nova árvore binária.

### `void insert(Node newNode)`

Insere um novo nó na árvore.

### `boolean remove(int value)`

Remove um nó com o valor especificado.

### `void preOrder()`

Exibe os valores da árvore em pré-ordem.

### `void inOrder()`

Exibe os valores da árvore em-ordem.

### `void postOrder()`

Exibe os valores da árvore em pós-ordem.

### `int totalNodes()`

Retorna o total de nós na árvore.

### `int totalNotLeafNodes()`

Retorna o total de nós não-folhas na árvore.

### `int totalLeafNodes()`

Retorna o total de nós-folhas na árvore.

### `int height()`

Retorna a altura da árvore.

### `boolean removePair()`

Remove todos os nós com valores pares.

### `void invertTree()`

Inverte a estrutura da árvore.

### `void questao7()`

Executa a travessia da árvore em pré-ordem, em-ordem e pós-ordem de forma não recursiva.

## Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Inserindo nós
        tree.insert(new Node(10));
        tree.insert(new Node(5));
        tree.insert(new Node(15));
        
        // Exibindo a árvore
        System.out.println("Traversal em ordem:");
        tree.inOrder();
        
        // Removendo um nó
        tree.remove(5);
        
        // Exibindo novamente a árvore
        System.out.println("Traversal em ordem após remoção:");
        tree.inOrder();
        
        // Calculando a altura
        System.out.println("Altura da árvore: " + tree.height());
    }
}
```

---

Sinta-se à vontade para adicionar ou modificar seções conforme necessário, ou incluir mais detalhes específicos sobre a classe e seu funcionamento!
