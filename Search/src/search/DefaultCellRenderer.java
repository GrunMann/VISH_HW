package search;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class DefaultCellRenderer implements ListCellRenderer<String>{

    private static final int OFFSET = 10;
    private static LookAndFeel styles;
    static {
        styles = UIManager.getLookAndFeel();
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends String> jlist, String value, int index, boolean isSelected, boolean isFocused) {
        JLabel label = new JLabel(value);
        label.setBorder(BorderFactory.createEmptyBorder(OFFSET, OFFSET, OFFSET, OFFSET));
        if (isFocused) {
            UIDefaults defaults = styles.getDefaults();
            label.setOpaque(true);
            label.setBackground(defaults.getColor("List.selectedBackground"));
            label.setForeground(defaults.getColor("List.selectedForeground"));
        }
        return label;
                
                
    }

    
    
}
