package com.itproger.myconverter1;

public class Currency {
    private String currency_name;
    private String abbrev_name;
    private double meaning_currency;

    Currency(String currency_name, String abbrev_name, double meaning_currency){
        this.currency_name = currency_name;
        this.abbrev_name = abbrev_name;
        this.meaning_currency = meaning_currency;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getAbbrev_name() {
        return abbrev_name;
    }

    public void setAbbrev_name(String abbrev_name) {
        this.abbrev_name = abbrev_name;
    }

    public double getMeaning_currency() {
        return meaning_currency;
    }

    public void setMeaning_currency(double meaning_currency) {
        this.meaning_currency = meaning_currency;
    }

    public String toString(){
        return  currency_name + " - "  + abbrev_name + " - " + meaning_currency;
    }
}
