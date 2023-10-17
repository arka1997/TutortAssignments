package com.OracleHealth.Polymorphism;

public class Apple extends Computer{
    public Apple(int unit, String gb) {
        super();
    }

    @Override
    public int ram(Computer cmp) {
        return 0;
    }
}
