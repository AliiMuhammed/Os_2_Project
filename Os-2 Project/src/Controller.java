

import java.util.Random;

 
             
public class Controller {
    public static int T=5;
    boolean booking ;
    int WaitBooking,Seeking;
    private boolean readersTurn =false;

    public  synchronized void statrtBook() {

        while(booking || Seeking>0){
            WaitBooking++;
            try{
               wait(); }
            catch(InterruptedException ex){
                WaitBooking--;
            } 
        }
        
        WaitBooking--;
        booking=true;
    }
    
    public static synchronized int book(String s){
          T=T-1;
          if(T<0){
              T=0;
              return 0;
              
          }
          return 1;
    }
    public synchronized void stopWriting(){
        booking = false;
        readersTurn =true;
        notifyAll();
    }
    
    
    public synchronized void startSeeking() {
        
        while(booking || WaitBooking > 0 && !readersTurn ){
            try{
                wait();
            }catch(InterruptedException ex){
            }
           
        } Seeking++;
    }

    
    public synchronized void stopSeeking(){
        --Seeking;
        readersTurn = false;
        if(Seeking==0){
            notifyAll();
        }
    }
    public int getTickets(){
        return T;
    }
}
