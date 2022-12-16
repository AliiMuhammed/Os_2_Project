/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */

public class Seeking extends Thread {
    public static Controller c = new Controller();
    String name;
    public Seeking(String name){
        this.name=name;
        this.setName(name);
    }

    @Override
    public void run() {
           
           MainFrame.c.startSeeking();
           try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
           MainFrame.jTextArea1.append("\nNumber of tickets Viewed by Customer: " + this.name + "          No.of Tickets now is:   " + c.getTickets() +"\n");

           MainFrame.c.stopSeeking();
 
       
    }


    
    
}
