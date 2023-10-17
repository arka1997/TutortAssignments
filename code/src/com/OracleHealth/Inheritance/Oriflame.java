package com.OracleHealth.Inheritance;

public class Oriflame extends Product {
    public void order(Product p){

        if(p instanceof Oriflame){
            Oriflame o = (Oriflame) p;
            System.out.println("yes Oriflame");
        }else{
            System.out.println("not at all, different Instance");
        }
    }
    public static void main(String[] args) {
        Laptop l = new Laptop();
        Product p2 = new Product();

        if(p2 instanceof Oriflame){// Here p2 is refencing Product class, and it's not an instance of Oriflame, so what, Oriflame extends Product, that doesn't mean, Pthey are same.
            System.out.println("yes Oriflame2");
        }else{
            System.out.println("NO2, different Instance");
        }
    }
}
