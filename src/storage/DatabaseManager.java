package storage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author Dottedsocks
 */
public class DatabaseManager {
    
    /**
     * 
     * @param toWhere
     * @param date
     * @param numbofPpl
     * @param fromWhere
     * @return 
     */
     public ArrayList<Flight> findFlights(String toWhere, String date, int numbofPpl, String fromWhere){
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        ArrayList<Flight>  theFlights = new ArrayList<>();
        try
        {
          try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("select * from flight join schedule on flight.flight_no = schedule.flight_no where departure_from = '" + fromWhere + "' and arrival_to = '"+ toWhere +"' and flight_date='" +date+"'");
            while(rs.next())
             {
             // read the result set
                Flight flug = new Flight();
                flug.setAirline(rs.getString("airline"));
                
                flug.setArrival_time(rs.getInt("arrival_time"));
                flug.setArrival_to(rs.getString("arrival_to"));
                
                flug.setDeparture_from(rs.getString("departure_from"));
                flug.setDeparture_time(rs.getInt("departure_time"));
                
                flug.setFlight_date(rs.getInt("flight_date"));
                flug.setFlight_no(rs.getString("flight_no"));
                
                flug.setSeats(rs.getInt("seats"));
                flug.setTicket_price(rs.getInt("ticket_price"));
                
                flug.setFlight_id(rs.getInt("flight_id"));

                theFlights.add(flug);
                System.out.println(flug.getSeats());
                System.out.println(flug);
             }
          }
          finally{
              if(rs != null) {
                  System.out.println("FindFlights: rs er opið, loka því");
                  rs.close();
              }
              if(statement != null) {
                  System.out.println("FindFlights: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("FindFlights: conCon er opið, loka því");
                 con.close();
              }
          }
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        return theFlights;
    }
  
    //Updates the Passenger table with the parameters that come in (makes a new row) 
    public void updatePassenger(String name, int phoneno, int ssno, int bookingid){
        System.out.println("Fer inn í updatePassenger");
        Connection con = null;
        PreparedStatement statement = null;

        try {
          try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            String query = "INSERT INTO Passenger(name, SSno, phoneNo, bookingId) values(?,?,?,?)";
            statement = con.prepareStatement(query);
            
                //Updates the table Passenger with the following parameters
  		statement.setString(1, name);
		statement.setInt(2, ssno);
		statement.setInt(3, phoneno);
		statement.setInt(4, bookingid);

		statement.setQueryTimeout(30);

                // execute insert SQL stetement           
                statement.executeUpdate();

                System.out.println("Gekkupp");
            }
              finally{
                if(statement != null) {
                  System.out.println("UpdatePassenger: statement er opið, loka því");
                  statement.close();
                }
                if(con != null) {
                  System.out.println("UpdatePassenger: con er opið, loka því");
                  con.close();
                } 
             }
      
        }catch(Exception e){
            System.out.println("Villa i updatePassenger: " + e);
        }
    }
        
    //Updates the value "availableSeats" in the table Scedule for the flight in question
    public void updateAvailableSeats(int flightId, int numbofPass){
        System.out.println("Fer inn í updateAvailableSeats");
        Connection con = null;
        PreparedStatement statement = null;
        //Finds the current value in "availableSeats" for the flight in question
        int availSeats = availableSeats(flightId);
        System.out.println("UpdateAvailableSeats: availSeats eru: " + availSeats);
        //Makes a new value based upon the current value in availableSeats and the number of Passengers
        int newAvailSeats = availSeats - numbofPass;
        System.out.println("UpdateAvailableSeats: newAwailSeats eru: " + newAvailSeats);

        try {
          try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            String query = "UPDATE Schedule SET availableSeats=? WHERE flight_id =?";
            statement = con.prepareStatement(query);
            
                System.out.println("Uppfærir available seats");
                //Updates the value "availableSeats" in the table Scedule for the flight in question
		statement.setInt(1, newAvailSeats);
                statement.setInt(2, flightId);

		statement.setQueryTimeout(30);

                //Execute insert SQL stetement
                statement.executeUpdate();
                
                //Kanna hvort þetta virkaði rétt
                int postAvailSeats = availableSeats(flightId);
                System.out.println("Nú eru availableSeats í Schedule: " + postAvailSeats);
                System.out.println("Gekkupp");
            }
              finally{

              if(statement != null) {
                  System.out.println("UpdatePassenger: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("UpdatePassenger: con er opið, loka því");
                  con.close();
                } 
             }
      
        }catch(Exception e){
            System.out.println("Villa i updatePassenger: " + e);
        }
    }

    //Finds the value for availableSeats in the table Schedule for the flight in question and returns it
    public int availableSeats(int flightId){
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        System.out.println("Fer inn í public int availableSeats");
        try {
            try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30); 
            //Update farthegafjolda i schedule
            rs = statement.executeQuery("select availableseats from schedule where flight_id=" +flightId);
            
            return rs.getInt("availableseats");
            
            }finally{
              if(rs != null) {
                  System.out.println("AvailableSeats: rs er opið, loka því");
                  rs.close();
              }
              if(statement != null) {
                  System.out.println("AvailableSeats: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("AvailableSeats: con er opið, loka því");
                 con.close();
              }
          }
            
        }catch(Exception e){
            System.out.println("Villa i availableSeats: " + e);
        }
        return 0;
    }
    
    //TODO tjekka
    public Passenger getPassenger(int SSno){
        Connection con = null;
        Statement statement = null;
        Passenger pp = new Passenger();
        ResultSet rs = null;
        try {
            try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30); 

            rs = statement.executeQuery("select* from passenger where ssno="+SSno);
            pp.setBookingId(rs.getInt("bookingId"));
            pp.setName(rs.getString("name"));
            pp.setSSno(SSno);
            
            return pp;    
            }
            finally{
              if(rs != null) {
                  System.out.println("Passenger: rs er opið, ekki loka því");
                  rs.close();
              }
              if(statement != null) {
                  System.out.println("Passenger: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("Passenger: con er opið, ekki loka því");
                 con.close();
              }
          }
        }catch(Exception e){
            System.out.println("Villa i getPassenger: " + e);
        }
        return null;
    }
    
    //Updates the booking table in flug.db with the new booking
     public void createBooking(int bookingID, int flightID, int numbofpass){
         System.out.println("Fer inn í createBooking í DatabaseManager");
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        ResultSet rss = null;
        try {
           try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30); 

            rs = statement.executeQuery("select flight_NO from schedule where flight_id="+flightID);
            String flightN = rs.getString("flight_no");
            rss = statement.executeQuery("select ticket_price from flight where flight_no='"+flightN+"'");
            int price = (rss.getInt("ticket_price"))*numbofpass;
            statement.executeUpdate("insert into booking(Ticket_price, bookingID, flight_id) values(" +price + ","+bookingID+","+flightID+")" );
            
            }finally{
              if(rs != null) {
                  System.out.println("CreateBooking: rs er opið, loka því");
                  rs.close();
              }
              if(rss != null) {
                  System.out.println("CreateBooking: rss er opið, loka því");
                  rss.close();
              }
              if(statement != null) {
                  System.out.println("CreateBooking: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("CreateBooking: con er opið, loka því");
                 con.close();
              }
          }    
        }catch(Exception e){
            System.out.println("Villa i createBooking: " + e);
        }
    }
     
    
     //Returns an ArrayList of ArrayList with information for the Booking Ticket
     public ArrayList returnBooking(int bookingno){
         //sækja allt sem þarf fyrir bookingno (flug, passengers o.s.fr.)
         Connection con = null;
         Statement statement = null;
         ResultSet rsBooking = null;
         ResultSet rsFlight = null;
         ResultSet rsPassenger = null;
         ArrayList<Booking>  theBooking = new ArrayList<>();
         ArrayList<Flight>  theFlight = new ArrayList<>();
         ArrayList<Passenger>  thePassenger = new ArrayList<>();
         ArrayList<ArrayList> theList = new ArrayList<>();
         
         try {
           try{
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30); 

            rsBooking = statement.executeQuery("SELECT * FROM Booking WHERE bookingID = "+bookingno);
            int flightID = rsBooking.getInt("flight_id");   //þurfum að finna flightID til að geta sótt rsFlight;
            System.out.println("FlightID: " + flightID);
            Booking booking = new Booking();
            booking.setBooking_id(rsBooking.getInt("bookingID"));
            booking.setTicket_price(rsBooking.getInt("Ticket_price"));
            System.out.println("Heildarverð miða: " + rsBooking.getInt("Ticket_price"));
            theBooking.add(booking);
            
            
            
            rsFlight = statement.executeQuery("select * from flight join schedule on flight.flight_no = schedule.flight_no where flight_id = "+flightID);
            Flight flight = new Flight();
            flight.setFlight_no(rsFlight.getString("flight_NO"));
            System.out.println("Flugnúmer er: " + rsFlight.getString("flight_NO"));
            flight.setAirline(rsFlight.getString("airline"));
            System.out.println("Airline er: " + rsFlight.getString("airline"));
            flight.setFlight_date(rsFlight.getInt("flight_date"));
            System.out.println("Dagsetning er: " + rsFlight.getInt("flight_date"));
            flight.setDeparture_time(rsFlight.getInt("departure_time"));
            System.out.println("Brottfarartími: " + rsFlight.getInt("departure_time"));
            flight.setArrival_time(rsFlight.getInt("arrival_time"));
            System.out.println("Komutími: " + rsFlight.getInt("arrival_time"));
            flight.setDeparture_from(rsFlight.getString("departure_from"));
            System.out.println("Frá: " + rsFlight.getString("departure_from"));
            flight.setArrival_to(rsFlight.getString("arrival_to"));
            System.out.println("Til: " + rsFlight.getString("arrival_to"));
            theFlight.add(flight);
            
            rsPassenger = statement.executeQuery("SELECT * FROM Passenger WHERE bookingId = " +bookingno);
            while(rsPassenger.next())
             {
                 Passenger pass = new Passenger();
                 pass.setName(rsPassenger.getString("name"));
                 System.out.println(rsPassenger.getString("name"));
                 
                 thePassenger.add(pass);
             }
            theList.add(theBooking);
            theList.add(theFlight);
            theList.add(thePassenger);
            
              
           }finally{
              if(rsBooking != null) {
                  System.out.println("ReturnBooking: rsBooking er opið, loka því");
                  rsBooking.close();
              }
               if(rsFlight != null) {
                  System.out.println("ReturnBooking: rsFlight er opið, loka því");
                  rsFlight.close();
              }
               if(rsPassenger != null) {
                  System.out.println("ReturnBooking: rsPassenger er opið, loka því");
                  rsPassenger.close();
              }
               if(statement != null) {
                  System.out.println("ReturnBooking: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("ReturnBooking: con er opið, loka því");
                 con.close();
              }
          }     
     
        }catch(Exception e){
            System.out.println("Villa i returnBooking: " + e);
        }
         return theList;
     }
     
   //Finds the largest booking number so far and returns it
    public int getMaxBookingNo(){
        Connection con = null;
        Statement statement = null;
        try {
            try{
   
            con = DriverManager.getConnection("jdbc:sqlite:flug.db");
            statement = con.createStatement();
            statement.setQueryTimeout(30); 
            
            //Update farthegafjolda i schedule
            ResultSet rs = statement.executeQuery("select max(Bookingid) from booking");
            System.out.println(rs.getInt("max(Bookingid)"));
            return rs.getInt("max(Bookingid)");
            
            }finally{
              if(statement != null) {
                  System.out.println("getMaxBookingNo: statement er opið, loka því");
                  statement.close();
              }
              if(con != null) {
                  System.out.println("getMaxBookingNo: con er opið, loka því");
                 con.close();
              }
          }    
            
        }catch(Exception e){
            System.out.println("Villa i getMaxBookingNo: " + e);
        }
        
        return 0;
    }

}