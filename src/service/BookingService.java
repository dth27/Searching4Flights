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
 * @author Dottedsocks
 */
public class BookingService {
    Booking booking;
    DatabaseManager GretaTheDBManager = new DatabaseManager();

    /**
     * Takes in the parameters from the BookingInfo Panel, to make a booking for the chosen flight
     * @param flightId
     * @param PassName
     * @param SSno
     * @param phoneNo
     * @param numbofPass
     * @return 
     */
    public int Flightbooking(int flightId, String[] PassName, Long[] SSno, Long[] phoneNo, int numbofPass){
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
            return bookingno;
            
        }else {
            System.out.println("No seats are available for this request");
        }
        return -1;
    }
       
    /**
     * Calls the DataBaseManager that updates the Passenger table in flug.db for each 
     *  passenger and updates the seat availability for this flight
     * @param flightId
     * @param numbofPass
     * @param Passname
     * @param SSno
     * @param phoneNo
     * @param bookingNo 
     */
    public void addPassenger(int flightId, int numbofPass, String Passname, Long SSno, Long phoneNo, int bookingNo){
            System.out.println("Fer inn í addPassenger");
            
            GretaTheDBManager.updatePassenger(Passname, phoneNo, SSno, bookingNo);
            GretaTheDBManager.updateAvailableSeats(flightId, numbofPass);
     }
        
    
     /**
      * Calls the DataBaseManager that creates a new Booking by calling the DataBaseManager
      * @param numbofPass
      * @param flightId
      * @param bookingno 
      */
     public void createBooking(int numbofPass, int flightId, int bookingno){
         System.out.println("fer inn í createBooking í BookingService");
         GretaTheDBManager.createBooking(bookingno, flightId, numbofPass); 
     }

     //TODO 
     public boolean updatePayment(){
        return true;
    }
     
     /**
      * Finds the maximum booking no in the database and adds one to that number to create a new booking no. 
      * @return 
      */
    public int getBookingNo(){
        int i = GretaTheDBManager.getMaxBookingNo();
        return i+1;
    }
   
    /**
     * 
     * @param bookingnr
     * @return 
     */
    public ArrayList bookingFlightTable(int bookingnr){
        //getFlight
        ArrayList<Flight>bookingFlight = new ArrayList<>();
        ArrayList<Booking> booking = new ArrayList<>();
        ArrayList<Passenger>passenger = new ArrayList<>();
        
        ArrayList<ArrayList> list = new ArrayList<>();
        list = GretaTheDBManager.returnBooking(bookingnr);
        try{
        bookingFlight = list.get(1);
        booking = list.get(0);
        passenger = list.get(2);
        } catch(Exception e){
            System.out.println("bookingFlightTable "+ e);
        }
        
        String col[] = {"Airline", "Date", "From", "To", "Departing Time", "Arriving Time"};
        DefaultTableModel TablemodelFlight = new DefaultTableModel(col, 0);
        
        for (int i = 0; i< bookingFlight.size(); i++){
            int arrTime = bookingFlight.get(i).getArrival_time();
            String airline = bookingFlight.get(i).getAirline();
            int depTime = bookingFlight.get(i).getDeparture_time();
            int FlDate = bookingFlight.get(i).getFlight_date();

            String destination = bookingFlight.get(i).getArrival_to();
            String departingFrom = bookingFlight.get(i).getDeparture_from();
            Object[] data = {airline, FlDate, departingFrom, destination, depTime, arrTime};
             TablemodelFlight.addRow(data);
        }
        try{
        int book = booking.get(0).getBooking_id();
        
        String col2[] = {"Passenger name", "booking number", "Ticket price"};
        DefaultTableModel TablemodelBook = new DefaultTableModel(col2, 0);
        for (int i=0; i<passenger.size(); i++){
            String pass = passenger.get(i).getName();
            int price = booking.get(i).getTicket_price();
            Object[] data = {pass, book, price};
            
            TablemodelBook.addRow(data);
        }
        
        ArrayList<DefaultTableModel> TyraBanks = new ArrayList<>();
        TyraBanks.add(TablemodelBook);
        TyraBanks.add(TablemodelFlight);
        
        return TyraBanks;
        }catch(Exception e){
            System.out.println("Villa i getBookingId "+ e);
        }
        return null;
    }
}
