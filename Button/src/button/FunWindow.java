package button;

import javax.swing.JFrame;

public class FunWindow extends JFrame {
    public FunWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fun!");
        add(new MouseComponent());
        pack();
    }
}
