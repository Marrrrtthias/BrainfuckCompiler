public class BrainfuckParser {
    int pos = 0;
    String code;

    public BrainfuckParser(String code) {
        this.code = code;
    }

    public boolean check() {
        // TODO
    }
    
    private boolean parseSymbol() {
        if(code.charAt(pos) == '[') {
            return parseLoop();
        } else {
            pos++;
            return true;
        }
    }

    private boolean parseLoop() {
        if(code.charAt(pos) != '[') {         // sanity check
            throw new RuntimeException();
        }
        while (code.charAt(pos) != ']') {
            if (code.charAt(pos) == '[') {
                parseLoop();
            }
            pos++;
        }
    }
}