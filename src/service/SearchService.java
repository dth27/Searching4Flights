/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import storage.*;
import model.Flight;


/**
 *
 * @author Dottedsocks
 */
public class SearchService { 
    DatabaseManager LovisaDBmanager;
    private ArrayList<Flight> flightInfo;
    public SearchService(){
       LovisaDBmanager = new DatabaseManager();
       flightInfo = new ArrayList<>();
       
    }
    //Býr til leit, sendum á userSearch
    public DefaultTableModel getFlights(String toWhere, String date, int numbofPpl, String fromWhere){
        DefaultTableModel flightmodel = new DefaultTableModel();
        try{
        flightInfo = LovisaDBmanager.findFlights(toWhere, date, numbofPpl, fromWhere);

        sortFlights(flightInfo);
        flightmodel = flugIToflu(numbofPpl);

        }catch (Exception e){
           System.out.println("Villa i getFlights "+e);
        }
        return flightmodel;    
    }
    public void sortFlights(ArrayList<Flight> a){
        try{
        Collections.sort(a);
        } catch (Exception e){
            System.out.println("Villa i sort: "+ e );
        }
    }

    /**
     * @return DefaultTablemodel
     * the search results in a table model
     */
    public DefaultTableModel flugIToflu(int numb){
        
        String col[] = {"Flight Id", "Airline", "Date", "From", "To", "Departing Time", "Arriving Time", "Price"};
        DefaultTableModel Tablemodel = new DefaultTableModel(col, 0);
        
        for (int i = 0; i< flightInfo.size(); i++){
            int arrTime = flightInfo.get(i).getArrival_time();
            String airline = flightInfo.get(i).getAirline();
            int depTime = flightInfo.get(i).getDeparture_time();
            int date = flightInfo.get(i).getFlight_date();
            int ticketPrice = flightInfo.get(i).getTicket_price()*numb;
            String destination = flightInfo.get(i).getArrival_to();
            String departingFrom = flightInfo.get(i).getDeparture_from();
            int flightid = flightInfo.get(i).getFlight_id();
            Object[] data = {flightid, airline, date, departingFrom,destination,depTime, arrTime, ticketPrice};
            Tablemodel.addRow(data);
        }
        return Tablemodel;
    }
    
}
