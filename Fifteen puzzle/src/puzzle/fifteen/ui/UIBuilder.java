package puzzle.fifteen.ui;

import javax.swing.JComponent;

public interface UIBuilder<E extends JComponent> {
    E build();
    
}
