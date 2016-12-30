package main;

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

    private void print(int symbol) {
        System.out.println((char) symbol);
    }

    private void read() {
        tape.set((int) StdIn.readChar());
    }
}