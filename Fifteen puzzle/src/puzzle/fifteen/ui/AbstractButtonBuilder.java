package puzzle.fifteen.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JComponent;

public abstract class AbstractButtonBuilder<E extends AbstractButton, T extends AbstractButtonBuilder> implements UIBuilder {
    private Dimension size;
    private Point location;
    private String title;
    private String command;
    private ActionListener listener; 
    
    public T setSize (Dimension size){
        this.size = size;
        return (T) this;
    }
    
    public T setLocation( Point location){
        this.location=location;
        return (T) this;
    }
    
    public T setTitle( String title){
        this.title=title;
        return (T) this;
    }
    public T setActionCommand( String command){
        this.command=command;
        return (T) this;
    }
    
    public T setActionListener(ActionListener listener){
        this.listener=listener;
        return (T) this;
    }
    
    protected final E build (E button){
        button.setText(title);
        button.setSize(size);
        button.setPreferredSize(size);
        button.setLocation(location);
        button.setActionCommand(command);
        button.addActionListener(listener);
        return button;
        
    }
    
}
