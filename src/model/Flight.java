/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**kkkkkk
 *
 * @author Dottedsocks
 */
public class Flight implements Comparable<Flight> {
    private String flight_no;
    private String departure_from;
    private String arrival_to;
    private String airline;
    private int seats;
    private int flight_date;
    private int ticket_price;
    private int departure_time;
    private int arrival_time;
    private int flight_id;

    /**
     * @return the flight_no
     */
    public String getFlight_no() {
        return flight_no;
    }

    /**
     * @param flight_no the flight_no to set
     */
    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    /**
     * @return the departure_from
     */
    public String getDeparture_from() {
        return departure_from;
    }

    /**
     * @param departure_from the departure_from to set
     */
    public void setDeparture_from(String departure_from) {
        this.departure_from = departure_from;
    }

    /**
     * @return the arrival_to
     */
    public String getArrival_to() {
        return arrival_to;
    }

    /**
     * @param arrival_to the arrival_to to set
     */
    public void setArrival_to(String arrival_to) {
        this.arrival_to = arrival_to;
    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @param airline the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return the flight_date
     */
    public int getFlight_date() {
        return flight_date;
    }

    /**
     * @param flight_date the flight_date to set
     */
    public void setFlight_date(int flight_date) {
        this.flight_date = flight_date;
    }

    /**
     * @return the ticket_price
     */
    public int getTicket_price() {
        return ticket_price;
    }

    /**
     * @param ticket_price the ticket_price to set
     */
    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    /**
     * @return the departure_time
     */
    public int getDeparture_time() {
        return departure_time;
    }

    /**
     * @param departure_time the departure_time to set
     */
    public void setDeparture_time(int departure_time) {
        this.departure_time = departure_time;
    }

    /**
     * @return the arrival_time
     */
    public int getArrival_time() {
        return arrival_time;
    }

    /**
     * @param arrival_time the arrival_time to set
     */
    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    @Override
    public int compareTo(Flight o) {
        return this.ticket_price - o.ticket_price;
    }

    /**
     * @return the flight_id
     */
    public int getFlight_id() {
        return flight_id;
    }

    /**
     * @param flight_id the flight_id to set
     */
    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
    
    
}
