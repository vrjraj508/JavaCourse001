package com.javabasics.Collections.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList();

    public String getTheatreName(){
        return theatreName;
    }

    public Theatre(String theatreName,int numRows,int seatsPerRow){
        this.theatreName = theatreName;
        int lastRow = 'A'+(numRows-1);
        for(char row='A';row <=lastRow;row++){
            for(int seatNum = 1; seatNum<=seatsPerRow;seatNum++){
                Seat seat = new Seat(row+String.format("%02d",seatNum));
                seats.add(seat);
            }
        }

    }

    public boolean reservedSeat(String seatNumber){
        Seat requestedSeat = null;

        for(Seat seat: seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat==null){
            System.out.println("There is no seat"+seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    public void getSeats(){
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }


    //** Seat class here
    private class Seat{
        private final String seatNumber;

        //So we are actually modifying this part of the code as seen here.
        private boolean reserved = false;


        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat"+seatNumber+" reserved");
                return true;
            }else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of the seat"+ seatNumber+ "cancelled");
                return true;
            }else{
                return false;
            }
        }


        public String getSeatNumber() {
            return seatNumber;
        }
    }
}


