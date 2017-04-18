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
public class Passenger {
    private String name;
    private int SSno;
    private int bookingId;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the SSno
     */
    public int getSSno() {
        return SSno;
    }

    /**
     * @param SSno the SSno to set
     */
    public void setSSno(int SSno) {
        this.SSno = SSno;
    }

    /**
     * @return the bookingId
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
 
    
    
}
