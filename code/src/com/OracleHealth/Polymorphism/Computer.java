package com.OracleHealth.Polymorphism;

public class Computer {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.ram(new Apple(502,"GB"));
        try {
            Float f = new Float("4.9");
            int x = f.intValue();
            byte b = f.byteValue();
            double d = f.doubleValue();
            System.out.println(x + b + d);
        }catch(NumberFormatException e){
            System.out.println("bad");
        }
    }
    public int ram(Computer cmp){
        //generic product logic
        return 0;
//        Object.wait()
    }
}
