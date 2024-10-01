public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node next;  // Para uso na pilha

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.next = null; 
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
