
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

    private void preOrderRecursive(Node p) {
        if (p != null) {
            System.out.println(p.getValue());
            preOrderRecursive(p.getLeft());
            preOrderRecursive(p.getRight());
        }
    }

    private void inOrderRecursive(Node p) {
        if (p != null) {
            inOrderRecursive(p.getLeft());
            System.out.println(p.getValue());
            inOrderRecursive(p.getRight());
        }
    }

    private void postOrderRecursive(Node p) {
        if (p != null) {
            postOrderRecursive(p.getLeft());
            postOrderRecursive(p.getRight());
            System.out.println(p.getValue());
        }
    }

    public void postOrder() {
        System.out.println("Pós Ordem:");
        postOrderRecursive(root);
    }

    public void preOrder() {
        System.out.println("Pré Ordem:");
        preOrderRecursive(root);
    };

    public void inOrder() {
        System.out.println("Em Ordem:");
        inOrderRecursive(root);
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
                Node substite = noDadRightLeft.getLeft();
                noDadRightLeft.setLeft(substite.getRight());
                substite.setLeft(root.getLeft());
                substite.setRight(root.getRight());
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
    public int height() {
        return calculateHeight(root);
    }

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

    // QUESTAO 5
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

    // QUESTAO 6
    private void invertTreeAux(Node current) {
        if (current == null) {
            return;
        }
        Node aux = current.getLeft();
        current.setLeft(current.getRight());
        current.setRight(aux);
        invertTreeAux(current.getLeft());
        invertTreeAux(current.getRight());
    }

    public void invertTree() {
        invertTreeAux(root);
    }

    // QUESTAO 7
    public void inOrderTraversal(Node root) {
        Stack stack = new Stack();
        Node p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.getLeft();
            } else {
                p = stack.pop();
                System.out.println(p.getValue());
                p = p.getRight();
            }
        }
    }

    public void preOrderTraversal(Node root) {
        Stack stack = new Stack();
        Node p = root;

        while (p != null || !stack.empty()) {
            if (p != null) {
                System.out.println(p.getValue());
                stack.push(p);
                p = p.getLeft();
            } else {
                p = stack.pop();
                p = p.getRight();
            }
        }
    }

    public void postOrderTraversal(Node root) {
        Stack stack = new Stack();
        Node p = root;
        Node lastVisited = null;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.getLeft();
            } else {
                Node peekNode = stack.getTop();
                if (peekNode.getRight() != null && lastVisited != peekNode.getRight()) {
                    p = peekNode.getRight();
                } else {
                    System.out.println(peekNode.getValue());
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public void questao7() {
        System.out.println("Em-Ordem Sem Recursão:");
        inOrderTraversal(root);
        System.out.println("Pré-Ordem Sem Recursão:");
        preOrderTraversal(root);
        System.out.println("Pós-Ordem Sem Recursão:");
        postOrderTraversal(root);
    }
}