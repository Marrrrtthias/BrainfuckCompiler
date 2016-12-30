public class BrainfuckRunner {
    Tape tape;
    String code;

    public BrainfuckRunner(String code) {
        check(code);
        this.code = code;
    }

    public void run() {
        // TODO
    }

    private print(int symbol) {
        System.out.println((char) symbol);
    }

    private read() {
        tape.set((int) StdIn.readChar());
    }
}