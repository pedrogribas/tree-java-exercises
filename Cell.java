public class Cell{
    int value;
    Cell next = null;

    public Cell(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Cell getNext() {
        return next;
    }
    public void setNext(Cell next) {
        this.next = next;
    }

    public void setNext(){
        this.next = null;
    }

    
}