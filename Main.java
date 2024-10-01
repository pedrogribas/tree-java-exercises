public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Node(10));
        tree.insert(new Node(5));
        tree.insert(new Node(15));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(12));
        tree.insert(new Node(18));
        tree.preOrder();
        tree.postOrder();
        tree.questao7();

    }
}
