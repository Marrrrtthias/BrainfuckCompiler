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
        System.out.println("BF runner initialized");
    }

    public void run() {
        System.out.println("BF runner starting");
    	while (pos < code.length()) {
    		execNext();
    	}
    }
    
	private void execNext() {
		switch (code.charAt(pos)) {
			case '+':
		        System.out.println("BF runner +");
				tape.plus();
				pos++;
				break;
			case '-':
		        System.out.println("BF runner -");
				tape.minus();
				pos++;
				break;
			case '<':
		        System.out.println("BF runner <");
				tape.bkw();
				pos++;
				break;
			case '>':
		        System.out.println("BF runner >");
				tape.fwd();
				pos++;
				break;
			case '.':
		        System.out.println("BF runner .");
				print(tape.get());
				pos++;
				break;
			case ',':
		        System.out.println("BF runner ,");
				read();
				pos++;
				break;
			case '[':
				pos++;
		        System.out.println("BF runner [");
				loop(pos);
				break;
		}
	}

    private void loop(int startPos) {
		while (code.charAt(pos) != ']') {
			execNext();
		}
		if (tape.get() != 0) {
			pos = startPos-1;
		} else {
			pos++;
		}
	}

	void print(int symbol) {
        System.out.println((char) symbol);
    }

    private void read() {
        tape.set((int) StdIn.readChar());
    }
}