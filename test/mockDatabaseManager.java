
import java.util.ArrayList;
import model.Flight;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dottedsocks
 */
public class mockDatabaseManager implements mDatabaseManager {
    ArrayList<Flight> flListi0, flListi1 ,flListiunsorted;
    ArrayList<ArrayList<Flight>> Listinn;
    Flight flug, flug2, flug3;
   
    
    public mockDatabaseManager(){
        flListi0 = new ArrayList<>();
        flListi1 = new ArrayList<>();
        flListiunsorted = new ArrayList<>();
        Listinn = new ArrayList<>();
        flug = new Flight();
        flug3 = new Flight();
        flug2 = new Flight();
        
        //flug = null;
        flug.setAirline("Rvk");
        flug.setArrival_time(1000);
        flug.setArrival_to("Akureyri");
        flug.setDeparture_from("Reykjavik");
        flug.setFlight_date(1001);
        flug.setDeparture_time(0);
        flug.setFlight_no("23");
        flug.setSeats(20);
        flug.setTicket_price(2300);
    
        //flug2 = null;
        
        flug2.setAirline("Ernir");
        flug2.setArrival_time(1020);
        flug2.setArrival_to("Akureyri");
        flug2.setDeparture_from("Reykjavik");
        flug2.setFlight_date(1001);
        flug2.setDeparture_time(0);
        flug2.setFlight_no("24");
        flug2.setSeats(20);
        flug2.setTicket_price(2200);

        //flug3 = null;
        
        flug3.setAirline("Flugfelag");
        flug3.setArrival_time(1020);
        flug3.setArrival_to("Isafjordur");
        flug3.setDeparture_from("Reykjavik");
        flug3.setFlight_date(1001);
        flug3.setDeparture_time(0);
        flug3.setFlight_no("21");
        flug3.setSeats(22);
        flug3.setTicket_price(100);
        //bætum í listann
        
        flListiunsorted.add(flug);
        flListiunsorted.add(flug2);
        flListiunsorted.add(flug3);
        
        flListi1.add(flug);
        
        flListi0 = null;
    }
    public ArrayList getlist(int index){

        
        
        Listinn.add(flListi0);
        Listinn.add(flListi1);
        Listinn.add(flListiunsorted);

        
        return Listinn.get(index);
    }
}
