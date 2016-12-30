public class Tape {
    TapeElement current;

    public Tape() {
        current = new TapeElement(0);
    }

    public int get() {
        return current.val;
    }

    public void set(int val) {
        current.val = val;
    }

    public void plus() {
        current.val++;
    }

    public void minus() {
        current.val--;
    }

    public void fwd() {
        if(current.next == null) {
            current.next = new TapeElement(0);
        }
        current = current.next;
    }

    public void bkw() {
        if(current.prev == null) {
            current.prev = new TapeElement(0);
        }
        current = current.prev;
    }

    private class TapeElement {
        int val;
        TapeElement prev, next;

        TapeElement(int val) {
            this.val = val;
        }
    }
}