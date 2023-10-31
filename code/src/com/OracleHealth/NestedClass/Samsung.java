package com.OracleHealth.NestedClass;

public class Samsung extends Mobile {
    int unit;
    String gb;

    public Samsung(int unit, String gb) {
        super();
        this.unit = unit;
        this.gb = gb;
    }
    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb;
    }


}
