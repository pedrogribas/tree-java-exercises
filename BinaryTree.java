import java.util.*;
/**
 * Uma classe para representar uma árvore binária.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    private Node nodeExists(int value, Node current) {
        if (current == null)
            return null;
        if (value > current.getValue()) {
            if (current.getRight() != null) {
                if (current.getRight().getValue() == value)
                    return current;
            }
        } else {
            if (current.getLeft() != null) {
                if (current.getLeft().getValue() == value)
                    return current;
            }
        }
        if (current.getValue() > value)
            return nodeExists(value, current.getRight());
        if (current.getValue() < value)
            return nodeExists(value, current.getLeft());
        return current;
    }

    public Node exists(int verify) {
        return nodeExists(verify, root);
    }

    private Node insertNew(Node newNode, Node current) {
        if (exists(newNode.getValue()) == null) {
            if (current == null) {
                return newNode;
            }
            if (current.getValue() > newNode.getValue()) {
                current.setLeft(insertNew(newNode, current.getLeft()));
            } else if (current.getValue() < newNode.getValue()) {
                current.setRight(insertNew(newNode, current.getRight()));
            }
            return current;
        }
        System.out.println("Já existe");
        return null;
    }

    public void insert(Node newNode) {
        root = insertNew(newNode, root);
    }

    private Node farLeft(Node father, Node current) {
        if (current.getLeft() == null) {
            return father;
        }
        return farLeft(current, current.getLeft());
    }

    public Node searchDad(Node current, int value) {
        if (current == null)
            return null;
        if (current.getValue() < value) {
            if (current.getRight() != null && current.getRight().getValue() == value) {
                return current;
            }
            return searchDad(current.getRight(), value);
        }
        if (current.getLeft() != null && current.getLeft().getValue() == value) {
            return current;
        }
        return searchDad(current.getLeft(), value); // aqui sempre o getValue vai ser > que o value 
    }

    public boolean remove(int value) {
        if (root == null) {
            return false; // A árvore está vazia
        }

        // Caso em que a raiz é o nó a ser removido
        if (root.getValue() == value) {
            // Se a raiz não tem filhos, simplesmente a remove
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null) { // Se não tem filho esquerdo
                root = root.getRight();
            } else if (root.getRight() == null) { // Se não tem filho direito
                root = root.getLeft();
            } else { // Caso com dois filhos
                Node noDadRightLeft = farLeft(root, root.getRight());
                Node substite = noDadRightLeft.getRight();
                substite.setLeft(root.getLeft());
                noDadRightLeft.setLeft(null);
                root = substite; // Substitui a raiz pela substituta
            }
            return true; // A raiz foi removida
        }

        // Para outros casos, procure o pai do nó a ser removido
        Node dad = searchDad(root, value);
        if (dad == null) {
            return false; // O valor não foi encontrado
        }

        Node noX = (dad.getValue() < value) ? dad.getRight() : dad.getLeft();

        // Caso 1: nó sem filhos
        if (noX.getRight() == null && noX.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(null);
            } else {
                dad.setLeft(null);
            }
            return true;
        }

        // Caso 2: um filho
        if (noX.getRight() == null) {
            if (dad.getValue() < value) {
                dad.setRight(noX.getLeft());
            } else {
                dad.setLeft(noX.getLeft());
            }
        } else if (noX.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(noX.getRight());
            } else {
                dad.setLeft(noX.getRight());
            }
        }

        // Caso 3: dois filhos
        if (noX.getRight() != null && noX.getLeft() != null) {
            Node noDadRightLeft = farLeft(noX, noX.getRight());
            Node substite = noDadRightLeft.getLeft();
            noDadRightLeft.setLeft(substite.getRight());
            substite.setRight(noX.getRight());
            substite.setLeft(noX.getLeft());
            noX.setRight(null);
            noX.setLeft(null);
            if (dad.getValue() < value)
                dad.setRight(substite);
            else
                dad.setLeft(substite);
        }

        return true;
    }
    // QUESTAO 1

    private int nodeCounter(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + nodeCounter(current.getLeft()) + nodeCounter(current.getRight());
    }

    public int totalNodes() {
        return nodeCounter(root);
    }

    // QUESTAO 2
    private int notLeafNodeCounter(Node current) {
        if (current == null) {
            return 0;
        } else if (current.getLeft() != null || current.getRight() != null) {
            return 1;
        } else {
            return notLeafNodeCounter(current.getLeft()) + notLeafNodeCounter(current.getRight());
        }
    }

    public int totalNotLeafNodes() {
        return notLeafNodeCounter(root);
    }

    // QUESTAO 3
    private int leafNodeCounter(Node current) {
        if (current == null) {
            return 0;
        } else if (current.getLeft() == null && current.getRight() == null) {
            return 1;
        } else {
            return leafNodeCounter(current.getLeft()) + leafNodeCounter(current.getRight());
        }
    }

    public int totalLeafNodes() {
        return leafNodeCounter(root);
    }

    // QUESTAO 4
    /**
     * Método para calcular altura na árvore.
     * 
     * @return a altura da árvore
     */
    public int height() {
        return calculateHeight(root);
    }

    /**
     * Método auxiliar para calcular altura. Usa recursividade
     * 
     * @param atual a palavra que está percorrendo
     * @return a altura final
     */
    private int calculateHeight(Node root) {
        if (root == null) {
            return 0; // Se o nó for null, retorna 0
        }
        // Recursão para os filhos esquerda e direita
        int leftHeight = calculateHeight(root.getLeft()) + (root.getLeft() == null ? 0 : 1);
        int rightHeight = calculateHeight(root.getRight()) + (root.getLeft() == null ? 0 : 1);
        // Retorna a maior altura entre as subárvores esquerda e direita
        return Math.max(leftHeight, rightHeight);
    }

    //QUESTAO 5
    private void removePairAux(Node current) {
        if (current == null) {
            return;
        } else if (current.getValue() % 2 == 0) {
            remove(current.getValue());
        }
        removePairAux(current.getLeft());
        removePairAux(current.getRight());
    }

    public boolean removePair() {
        removePairAux(root);
        return true;
    }

    //QUESTAO 6
    private void invertTreeAux(Node current){
        if (current == null) {
            return;
        }
        Node aux = current.getLeft();
        current.setLeft(current.getRight());
        current.setRight(aux);
        invertTreeAux(current.getLeft());
        invertTreeAux(current.getRight());
    }
    public void invertTree(){
        invertTreeAux(root);
    }

    //QUESTAO 7
    public void treeWalker(){
        if(root==null){return;} 
        //EM ORDEM
        Node currentInOrder = root;
        Stack inOrder = new Stack();
        while (currentInOrder!=null|| !inOrder.empty()) {
            inOrder.push(new Cell(currentInOrder.getValue()));
            currentInOrder = currentInOrder.getLeft();
        }        
        // Agora o nó mais à esquerda está no topo da pilha
        if (!inOrder.empty()) {
            Cell cell = inOrder.pop(); // Desempilha o nó
            System.out.print(cell.getValue() + " "); // Visita o nó
            // Move para a subárvore direita
            currentInOrder = currentInOrder.getRight();
        }
        //PRE-ORDEM
        Node currentPreOrder = root;
        Stack preOrder = new Stack();
        preOrder.push(new Cell(currentPreOrder.getValue()));
        while (!preOrder.empty()) {
            Cell cell = preOrder.pop(); // Desempilha o nó
            System.out.print(cell.getValue() + " "); // Visita o nó
            
            // Empilha o filho direito primeiro para que o filho esquerdo seja processado primeiro
            if (currentPreOrder.getRight() != null) {
                Node aux = currentPreOrder;
                while (currentPreOrder.getLeft()!=null) {
                    
                }
                stack.push(new Cell(cell.getNode().getRight()));
            }
            if (cell.getNode().getLeft() != null) {
                stack.push(new Cell(cell.getNode().getLeft()));
            }
        }
    

    }
}