package com.OracleHealth.Inheritance;
public class Laptop extends Product{

//    Overloading, same name, different forms

//    public void order2() {
//        order2();
//    }

    public void order2(Product p){

        if(p instanceof Laptop){
            System.out.println("yes Laptop");
        }else{
            System.out.println("Nope Laptop, different Instance");
        }
    }
    public static void main(String[] args) {
        Laptop l = new Laptop();
        Product p = new Product();
    }
}
