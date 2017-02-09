package com.jblearning.tipcalculatorv4;

public class TipCalculator {
    private float tip;
    private float bill;
    private int guests;
    private float guestTotal;

    public TipCalculator(float newTip, float newBill ) {
        setTip( newTip );
        setBill( newBill );
    }

    public float getTip( ) {
        return tip;
    }

    public float getBill( ) {
        return bill;
    }

    public int getGuests(){return guests;}

    public float getGuestTotal(){return guestTotal;}

    public void setTip( float newTip ) {
        if( newTip > 0 )
            tip = newTip;
    }

    public void setBill( float newBill ) {
        if( newBill > 0 )
            bill = newBill;
    }

    public void setGuests(int newGuests){
        if(newGuests >0)
            guests = newGuests;
    }

    public float tipAmount( ) {
        return bill * tip;
    }

    public float tipGuestAmount(){
        return tipAmount()/ guests;
    }

    public float totalAmount( ) {
        return bill + tipAmount( );
    }

    public float totalAmountPerGuest(){
        guestTotal = bill / guests + tipGuestAmount();
        return guestTotal;
    }
}
