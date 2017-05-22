package search;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import static search.helpers.Resources.getString;
import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.WEST;


public class Dashboard extends JFrame{

       public static void main(String[] args) {
           try {
               setLookAndFeel(getSystemLookAndFeelClassName());
           } catch (Exception ignore){}
           new Dashboard().setVisible(true);
        
    }
    
    private KeyListener keyListener = new KeyAdapter() {

           @Override
           public void keyTyped(KeyEvent ke) {
               
            filter(search.getText());
               
           }
        
    };
    
    private ListModel<String> getSearchResults(String needle){
        DefaultListModel<String> results = new DefaultListModel<>();
        for (int i = 0; i < model.getSize(); i++) {
            String item = model.getElementAt(i);
            if (item.contains(needle)){
                results.addElement(item);
            }
        }
        
    }
    
    private void filter (String needle){        
        list.setModel(getSearchResults(needle));
    }
    
       
       
    private JTextField search;
    private JList<String> list;
    private ListModel<String> model;
       
    Dashboard(){
           super(getString("title.search"));
           initComponents();
       }
    private void initComponents(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new Dimension(400, 600));
        
        add(createSearchPanel(), BorderLayout.NORTH);
        
        list= new JList<>(getPayload());
        
        add(list);
        
        search.addKeyListener(keyListener);
        
        pack();
    }
    
    private String[] getPayload(){
        return new String[] {"Yellow", "Red", "Green", "Blue"};
                
    }
    
    private JPanel createSearchPanel() {
        final int offset= 10;
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        
        JLabel label = new  JLabel(getString("title.search"));
        search = new JTextField();
        
        panel.add(label);
        panel.add(search);
        
        layout.putConstraint(WEST, label, offset, WEST, panel);
        layout.putConstraint(WEST, search, offset, EAST, label);
        layout.putConstraint(EAST, panel, offset, EAST, search);
        
        layout.putConstraint(NORTH, label, offset, NORTH, panel);
        layout.putConstraint(SOUTH, label, -offset, SOUTH, panel);
        layout.putConstraint(NORTH, search, offset, NORTH, panel);
        layout.putConstraint(SOUTH, panel, offset, SOUTH, search);
        
        return panel;
    }

}
