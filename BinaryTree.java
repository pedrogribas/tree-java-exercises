
/**
 * Uma classe para representar uma árvore binária.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    private Node nodeExists(Node current, Node n) {
        if (current == null) {
            return null;
        } else if (current.getValue() == n.getValue()) {
            return current;
        } else {
            if (current.getValue() < n.getValue()) {
                return nodeExists(current, n.getLeft());
            } else if (current.getValue() > n.getValue()) {
                return nodeExists(current, n.getRight());
            } else {
                return null;
            }
        }
    }

    public Node exists(Node current) {
        return nodeExists(current, root);
    }

    private Node insertNew(Node newNode, Node current) {
        if (current == null) {
            return newNode;
        }
        if (current.getValue() > newNode.getValue()) {
            current.setLeft(insertNew(newNode, current.getLeft()));
        } else if (current.getValue() < newNode.getValue()) {
            current.setRight(insertNew(newNode, current.getRight()));
            return current;
        }
        return current;
    }

    public void insert(Node newNode) {
        root = insertNew(newNode, root);

    }

    private Node farLeft(Node dad, Node son) {
        if (son.getLeft() == null) {
            return dad;
        }
        return farLeft(son, son.getLeft());
    }

    public Node searchDad(Node current, int value) {
        if (current == null)
            return null;
        if (value > current.getValue()) {
            if (current.getRight() != null) {
                if (current.getRight().getValue() == value) {
                    return current;
                }
            }
        } else {
            if (current.getLeft() != null) {
                if (current.getLeft().getValue() == value) {
                    return current;
                }
            }
        }
        if (current.getValue() > value) {
            return searchDad(current.getLeft(), value);
        }
        if (current.getValue() < value) {
            return searchDad(current.getRight(), value);
        }
        return null;
    }

    public boolean remove(int value) {
        if (root == null) {
            return false;
        } else {
            Node dad;
            Node noX;
            if (root.getValue() == value) {
                dad = root;
                noX = root;
            } else {
                dad = searchDad(root, value);
                if (dad.getValue() < value) {
                    noX = dad.getRight();
                } else {
                    noX = dad.getLeft();
                }
            }
            if (noX.getRight() == null && noX.getLeft() == null) { // case 1
                if (dad.getValue() < value)
                    dad.setRight(null);
                else
                    dad.setLeft(null);
                return true;
            } else if (noX.getRight() != null && noX.getLeft() != null) { // case 3
                Node noDadRightLeft = farLeft(noX, noX.getRight());
                Node substite = noDadRightLeft.getLeft();
                noDadRightLeft.setLeft(null);
                substite.setRight(noX.getRight());
                substite.setLeft(noX.getLeft());
                noX.setRight(null);
                noX.setLeft(null);
                if (dad.getValue() < value)
                    dad.setRight(substite);
                else
                    dad.setLeft(substite);
            } else { // case 2
                if (noX.getRight() == null) {
                    if (dad.getValue() > value)
                        dad.setLeft(noX.getLeft());
                    else
                        dad.setRight(noX.getLeft());

                }
                if (noX.getLeft() == null) {
                    if (dad.getValue() > value)
                        dad.setLeft(noX.getRight());
                    else
                        dad.setRight(noX.getRight());
                }
                return true;
            }
            return false;
        }
    }

    private int nodeCounter(Node current) {
        if (current != null) {
            return 0;
        }
        return 1 + nodeCounter(current.getLeft()) + nodeCounter(current.getRight());
    }

    public int totalNodes() {
        return nodeCounter(root);
    }

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

    /**
     * Método para calcular altura na árvore.
     * 
     * @return a altura da árvore
     */
    public int altura() {
        return calculateHeight(root, 0);
    }

    /**
     * Método auxiliar para calcular altura. Usa recursividade
     * 
     * @param atual  a palavra que está percorrendo
     * @param altura encontrada até então
     * @return a altura final
     */
    private int calculateHeight(Node current, int height) {
        if (current == null) {
            return height; // Se o nó for null, retorna a altura acumulada
        }
        // se o nó atual é uma folha
        if (current.getLeft() == null && current.getRight() == null) {
            return height + 1;
        }
        // Recursão para os filhos esquerda e direita
        int leftHeight = calculateHeight(current.getLeft(), height + 1);
        int rightHeight = calculateHeight(current.getRight(), height + 1);
        // Retorna a maior altura entre as subárvores esquerda e direita
        return Math.max(leftHeight, rightHeight);
    }

}