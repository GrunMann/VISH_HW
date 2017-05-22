package puzzle.fifteen.ui;

import javax.swing.JButton;

public class JButtonBuilder extends AbstractButtonBuilder <JButton, JButtonBuilder>{

    @Override
    public JButton build() {
       return build (new JButton());
    }

}
