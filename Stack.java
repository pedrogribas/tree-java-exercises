public class Stack {
    private Node top;
    private int quant;

    public Stack() {
        this.top = null;
        this.quant = 0;
    }

    public Node getTop() {
        return top;
    }

    public int getQuant() {
        return quant;
    }

    public boolean empty() {
        return top == null;
    }

    public void push(Node c) {
        c.setNext(top);
        top = c;
        quant++;
    }

    public Node pop() {
        if (empty()) {
            return null;
        } else {
            Node aux = top;
            top = top.getNext();
            aux.setNext(null);
            quant--;
            return aux;
        }
    }

    public void clear() {
        top = null;
        quant = 0;
    }

    public void print() {
        if (!empty()) {
            Node aux = top;
            while (aux != null) {
                System.out.println(aux.getValue());
                aux = aux.getNext();
            }
        }
    }
}
