package com.OracleHealth.Inheritance;

public class Product {
    public static void main(String[] args) {
        Oriflame o = new Oriflame();
        Laptop l = new Laptop();
        o.order(new Oriflame());

        l.order2(new Oriflame());
    }
}
