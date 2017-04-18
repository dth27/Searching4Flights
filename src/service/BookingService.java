/*
 * FLIGHT SEARCH AND BOOKING SYSTEM
 * BookingService
 */
package service;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*;
import storage.*;
/**
 * 
 * @author Dottedsocksjkljn
 */
public class BookingService {
    Booking booking;
    DatabaseManager GretaTheDBManager = new DatabaseManager();
    
    
   //Takes in the parameters from the BookingInfo Panel, to make a booking for the chosen flight
    public void Flightbooking(int flightId, String[] PassName, int[] SSno, int[] phoneNo, int numbofPass){
        System.out.println("Fer inn í Flightbooking");
        
        //Checks if there are enough available seats for the number of Passengers that want to book a flight
        //If there are enough seats proceeds to make a booking and create Passengers
        int availSeats = GretaTheDBManager.availableSeats(flightId);
        if (availSeats>=numbofPass){ 
 
            //Gets a new bookingNo to use for the booking and calls createBooking
            int bookingno = getBookingNo(); 
            createBooking(numbofPass, flightId, bookingno);
            
            //Loops through the Passengers requesting the booking, to add passengers by calling addPassenger
            for(int i=0;i<numbofPass;i++) {            
                 addPassenger(flightId, numbofPass, PassName[i], SSno[i], phoneNo[i], bookingno);
             }
            
        }else {
            System.out.println("No seats are available for this request");
        }
    }
       //Calls the DataBaseManager that updates the Passenger table in flug.db for each passenger and updates the seat availability for this flight
     public void addPassenger(int flightId, int numbofPass, String Passname, int SSno, int phoneNo, int bookingNo){
            System.out.println("Fer inn í addPassenger");
            
            GretaTheDBManager.updatePassenger(Passname, phoneNo, SSno, bookingNo);
            GretaTheDBManager.updateAvailableSeats(flightId, numbofPass);
     }
        
 //Calls the DataBaseManager that creates a new Booking by calling the DataBaseManager   
     public void createBooking(int numbofPass, int flightId, int bookingno){
         System.out.println("fer inn í createBooking í BookingService");
         GretaTheDBManager.createBooking(bookingno, flightId, numbofPass); 
     }
     
     //TODO kallar a Databasemanager og naer i upls ur gagnagrunni
     //Ekki búin að gera þetta ennþá, var ekki alveg viss hvernig þetta kæmi frá gangagrunninum
     public ArrayList getFlight(int bookingNo){
         return null;
     }
     //TODO væri ekki best ef þetta tæki inn "int bookingNo" og fyndi alla Passenger sem væru með þetta bookingNo?
     //Ekki búin að gera þetta ennþá, var ekki alveg viss hvernig þetta kæmi frá gangagrunninum
     public ArrayList getPassenger(int bookingNo){
         return null;
     }
     //sleppa nema timi gefst
    public void removePassenger(int passenger){
        
    }
     //sleppa nema timi gefst   
     public boolean updatePayment(){
        return true;
    }
     //TODO SQL skipun i databasemanager sem naer i MAX bookingno 
     //Finds the maximum booking no in the database and adds one to that number to create a new booking no.
    public int getBookingNo(){
        int i = GretaTheDBManager.getMaxBookingNo();
        return i+1;
    }
 
    //TODO þetta virkar ekki rétt þ.e. passInfo virkar ekki, svo ég er að gera þetta eitthvað vitlaust
    //Takes in an Array of PassengerInfo made by calling the method getPassenger with the relevant bookingNo
    //And creates a TableModel containing the array of Passengers   
   /*public DefaultTableModel bookingPassTable(passInfo = getPassenger(int bookingNo)){
        //TODO na i upplysingar um passenger og setja i Tablemodel og skila
        //getPassenger
        String col[] = {"name","SSno","bookingNo"};
        DefaultTableModel Tablemodel = new DefaultTableModel(col, 0);
        
        for (int i = 0; i< passInfo.size(); i++){
            String passName = passInfo.get(i).getName();
            String passSSno = passInfo.get(i).getSSno();
            Object[] data = {passName, passSSno};
             Tablemodel.addRow(data);
        }
        return Tablemodel;
    } 
    
     //TODO þetta virkar ekki rétt þ.e. flightInfo virkar ekki, svo ég er að gera þetta eitthvað vitlaust
    //Takes in an Array of Flight made by alling the method getFlight with the relevant bookingNo
    //And creates a TableModel containing the array of Passengers   
    public DefaultTableModel bookingFlightTable(flightInfo = getFlight(int bookingNo)){
        //TODO na i upplysingar um flug og setja i tablemodel og skila
        //getFlight
        
        String col[] = {"arrivingTime","airline","departingTime", "date", "price", "destination", "departingfrom", "flight number"};
        DefaultTableModel Tablemodel = new DefaultTableModel(col, 0);
        
        for (int i = 0; i< flightInfo.size(); i++){
            int arrTime = flightInfo.get(i).getArrival_time();
            String airline = flightInfo.get(i).getAirline();
            int depTime = flightInfo.get(i).getDeparture_time();
            int FlDate = flightInfo.get(i).getFlight_date();
            int ticketPrice = flightInfo.get(i).getTicket_price();
            String destination = flightInfo.get(i).getArrival_to();
            String departingFrom = flightInfo.get(i).getDeparture_from();
            String flightNO = flightInfo.get(i).getFlight_no();
            Object[] data = {arrTime, airline, depTime, FlDate, ticketPrice, destination, 
                               departingFrom, flightNO};
             Tablemodel.addRow(data);
        }
        return Tablemodel;
    }*/
}
