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
				break;
			case '-':
		        System.out.println("BF runner -");
				tape.minus();
				break;
			case '<':
		        System.out.println("BF runner <");
				tape.bkw();
				break;
			case '>':
		        System.out.println("BF runner >");
				tape.fwd();
				break;
			case '.':
		        System.out.println("BF runner .");
				print(tape.get());
				break;
			case ',':
		        System.out.println("BF runner ,");
				read();
				break;
			case '[':
		        System.out.println("BF runner [");
				loop(pos = pos+1);
				break;
		}
		pos++;
	}

    private void loop(int startPos) {
		while (code.charAt(pos) != ']') {
			execNext();
		}
		if (tape.get() != 0) {
			pos = startPos;
		}
	}

	void print(int symbol) {
        System.out.println((char) symbol);
    }

    private void read() {
        tape.set((int) StdIn.readChar());
    }
}