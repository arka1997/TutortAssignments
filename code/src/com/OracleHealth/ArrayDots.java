package com.OracleHealth;


public class ArrayDots {
    public static void main(String[] args) {
        ArrayDots p = new ArrayDots();
        p.getVal("DEB");
        p.getVal("TUBAN", "ANKI");
        p.getVal("ARKA", "AYAN", "ABHI");
        p.getVal("");
    }

    private void getVal(String... values) {
        switch(values.length){
            case 1:
                System.out.println(values[0]);
                break;
            case 2:
                System.out.println(values[1]);
                break;
            case 3:
                System.out.println(values[2]);
                break;
            default:
                System.out.println("N/A");
                break;
        }
    }
}
