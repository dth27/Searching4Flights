/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dottedsocks
 */
public class Booking {
    private int Ticket_price;
    private int numbOfPass;
    private int Booking_id;
    private boolean paid;
    
    /**
     * @return the Ticket_price
     */
    public int getTicket_price() {
        return Ticket_price;
    }

    /**
     * @param Ticket_price the Ticket_price to set
     */
    public void setTicket_price(int Ticket_price) {
        this.Ticket_price = Ticket_price;
    }

    /**
     * @return the numbOfPass
     */
    public int getPassenger_info() {
        return numbOfPass;
    }

    /**
     * @param Passenger_info the numbOfPass to set
     */
    public void setPassenger_info(int Passenger_info) {
        this.numbOfPass = Passenger_info;
    }

    /**
     * @return the Booking_id
     */
    public int getBooking_info() {
        return Booking_id;
    }

    /**
     * @param Booking_info the Booking_id to set
     */
    public void setBooking_info(int Booking_info) {
        this.Booking_id = Booking_info;
    }

    /**
     * @return the paid
     */
    public Boolean getPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    
    /**
     * @return the Booking_id
     */
    public int getBooking_id() {
        return Booking_id;
    }

    /**
     * @param Booking_id the Booking_id to set
     */
    public void setBooking_id(int Booking_id) {
        this.Booking_id = Booking_id;
    }
    
   
}
