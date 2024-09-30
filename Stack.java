public class Stack {
    private Cell top;
    private int quant;

    public Stack() {
        this.top = null;
        this.quant = 0;
    }

    public Cell getTop() {
        return top;
    }

    public void setTop(Cell top) {
        this.top = top;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant += quant;
    }

    public boolean empty() {
        return top == null;
    }

    public void push(Cell c) {
        c.setNext(top);
        setTop(c);
        setQuant(1);
    }

    public Cell pop() {
        if (empty()) {
            return null;
        } else {
            Cell aux = top;
            top = top.getNext();
            aux.setNext(null);
            setQuant(-1);
            return aux;
        }
    }

    public void clear() {
        setTop(null);
    }

    public void print() {
        if (!empty()) {
            Cell aux = top;
            while (aux != null) {
                System.out.println(aux.getValue());
                aux = aux.getNext();
            }
        }
    }

}