
package controller;
import service.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dottedsocks
 */
//TaskManager: the ActionListener and implements the view package 
//              Sends actions to bookingService or SearchService
//              and gets results back that he sends to the view to update it
public class taskManager {
    SearchService JonaSearchService;
    BookingService BuiBookingService;
    private final mainWindow Frontpage;
    private ActionListener actionListener, actionListener2, actionListener3;
    private MouseListener mouseListener;
    private BookingInfo bookingSite;
    private ticketView ticketview;
    int nbr; //To keep track on how many passengers the user wishes to buy tickets for
    int flightid; //To keep track of the flightID for booking
    
    public taskManager (mainWindow frontpage, SearchService searchService, BookingService bookingService){
        this.Frontpage = frontpage;
        this.BuiBookingService = bookingService;
        this.JonaSearchService = searchService;
        
    }
    
     /**
     * backToSearch resets the view 
     */
    public void backToSearch(){
        Frontpage.resetView();
    }
    
    public void getTicketView(int bookingno){

        ticketview = new ticketView(Frontpage, true);
        
        
        ArrayList<DefaultTableModel> hey = new ArrayList<>();
        
        hey = BuiBookingService.bookingFlightTable(bookingno);
        
        DefaultTableModel flightInfo = new DefaultTableModel();
        flightInfo = hey.get(0);
        DefaultTableModel passInfo = new DefaultTableModel();
        passInfo = hey.get(1);
        
        ticketview.createFlightview(flightInfo);
        ticketview.createPassView(passInfo);
       
        ticketview.setVisible(true);
        
        //BuiBookingService.
        
        //ticketview.createFlightview(flightInfo);
        //ticketview.createPassView(passInfo);
        
        
    }
    
    /**
     * manageSearch gets the results from search service and updates view
     * @param toWhere
     * @param when
     * @param nbr
     * @param fromWhere 
     */
    public void manageSearch(String toWhere, String when, int nbr, String fromWhere){
        try{
        TableModel mm = JonaSearchService.getFlights(toWhere, when, nbr, fromWhere);
        Frontpage.createResultView(mm);    
        }catch (Exception e){
            System.out.println("manageSearch: "+e);
        }
    }
    
    /**
     * manageBooking implements the booking view
     * and also acts as an actionListener that gets the passenger info
     * and sends it to the booking service class
     * @param id 
     */
    public void manageBooking(int id){
       bookingSite = new BookingInfo(Frontpage, true, nbr);        
       bookingSite.getBookButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            String[] passName = new String[nbr];
            int[] passSSno = new int[nbr];
            int[] passPhone = new int[nbr];
            int k = 0;
            for (int i = 0; i<nbr*3; i=i+3){
                        passName[k] = bookingSite.getInfoFields()[i].getText();
                        passSSno[k] =Integer.parseInt(bookingSite.getInfoFields()[i+1].getText());
                        passPhone[k] = Integer.parseInt(bookingSite.getInfoFields()[i+2].getText());
                        k=k+1;
            }
            int bookingno = BuiBookingService.Flightbooking(flightid, passName, passSSno, passPhone, nbr);
            getTicketView(bookingno);
           
           
        }
            
       });   
       bookingSite.setVisible(true);
    }    
    /**
     * Control implements the mainWindow view and adds actionListeners to the buttons
     * as wells decides what to do for every action
     */
    public void control(){
        Frontpage.setVisible(true);
        //ActionListener for the search button 
        actionListener = (ActionEvent e) -> {
            String fromWhere = Frontpage.getFromWhere();
            String toWhere = Frontpage.getToWhere();
            String when = Frontpage.getWhen();
            nbr = Frontpage.getNumberofPass();
            //sends the input to manageSearch 
            manageSearch(toWhere, when, nbr, fromWhere);        
        };
        Frontpage.getSearchButton().addActionListener(actionListener);
        
        //ActionListener for the back to search button
        actionListener2 = (ActionEvent e) -> {
            backToSearch();
        };
        Frontpage.getBackSearchButton().addActionListener(actionListener2);           
        
        //mouseListener for the JTable
        mouseListener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                int rowClicked = Frontpage.getJTable().rowAtPoint(e.getPoint()); //gets the row that was clicked
                //gets the data in the flight id cell in row rowClicked 
                Object obj = Frontpage.getJTable().getModel().getValueAt(rowClicked, 0); 
                flightid = Integer.valueOf(obj.toString());

                manageBooking(flightid);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               }

            @Override
            public void mouseEntered(MouseEvent e) {
                
               }

            @Override
            public void mouseExited(MouseEvent e) {
              }         
        };
        Frontpage.getJTable().addMouseListener(mouseListener);
    }
   
}