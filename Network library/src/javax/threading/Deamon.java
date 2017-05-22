package javax.threading;
public abstract class Deamon implements Runnable, AutoCloseable{

    private boolean running = true;
    
    protected abstract void doInBackground() throws Exception;
    
    @Override
    public final void run(){
        try {
            while (running) {                
                doInBackground();
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public void close() throws Exception {
        running = false;
    }
    
    public final void start(){
        new Thread(this).start();
    }
    
    
}
