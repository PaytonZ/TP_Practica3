package vista;

import javax.swing.text.PlainDocument;
import javax.swing.text.JTextComponent;
import java.io.PrintStream;

public final class Console {

    private static JTextComponent textField;
    private static PrintStream stream = System.out; // by default we will output
						    // to stdout

    private Console() {
	throw new AssertionError("I am a static class. Don't instantiate me.");
    }

    public static void useJTextComponent(JTextComponent newTextArea) {
	textField = newTextArea;
    }

    public static void usePrintStream(PrintStream newStream) {
	stream = newStream;
    }

    public static void println(String str) {
	if (textField != null) {
	    PlainDocument doc = (PlainDocument) textField.getDocument();

	    try {
		doc.insertString(doc.getLength(), str + "\n", null);
	    } catch (javax.swing.text.BadLocationException e) {
	    }

	    textField.setCaretPosition(doc.getLength());
	} else {
	    stream.println(str);
	}
    }
}