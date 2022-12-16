/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Booking extends Thread {
    String name;
    public static Controller c = new Controller();
    public Booking(String name) {
        this.name=name;
          this.setName(name);
    }
    

    @Override
    public void run() {
      
            MainFrame.c.statrtBook();
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            if(MainFrame.c.book("Tickets: ")==1){
                MainFrame.jTextArea1.append("\nA ticket has been booked by Customer: " +this.name + "          No.of Tickets now is:   " + c.getTickets() +"\n");
                MainFrame.jTextArea1.append("Customer No." + this.name +" finish booking\n");          

                MainFrame.c.stopWriting();
            }else{
                MainFrame.jTextArea1.append("\nCustomer no." +this.name + " ry to book a ticket but there aren't enough tickets\nNo.of Tickets now is: " + c.getTickets() +"\n");
                MainFrame.jTextArea1.append("Customer No." + this.name +" finish booking\n");          
                MainFrame.c.stopWriting();
            }
            
            
    }

    
    
}

        