package main;

public class BrainfuckRunner {
    Tape tape;
    String code;
    int pos;

    public BrainfuckRunner(String code) {
        if(!(new BrainfuckParser(code).check())) {
        	throw new RuntimeException();
        }
        this.code = code;
        this.tape = new Tape();
    }

    public void run() {
    	while (pos < code.length()) {
    		execNext();
    	}
    }
    
	private void execNext() {
		switch (code.charAt(pos)) {
			case '+':
				tape.plus();
				break;
			case '-':
				tape.minus();
				break;
			case '<':
				tape.bkw();
				break;
			case '>':
				tape.fwd();
				break;
			case '.':
				print(tape.get());
				break;
			case ',':
				read();
				break;
			case '[':
				loop(pos);
				break;
			default:
				pos++;
		}
	}

    private void loop(int startPos) {
		while (code.charAt(pos) != ']') {
			execNext();
		}
		if (tape.get() != 0) {
			pos = startPos;
		}
	}

	private void print(int symbol) {
        System.out.println((char) symbol);
    }

    private void read() {
        tape.set((int) StdIn.readChar());
    }
}