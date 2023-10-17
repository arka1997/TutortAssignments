package com.OracleHealth;

import java.util.Locale;

/** Here "WARM" & "FROZEN" are few fixed set of instances of enum     */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum Condition2 {
    LUKE_WARM("WARM WATER","Good"),
    FROZEN("COLD WATER","Not Good");
    private String cond;
    private String keys;
    /** Here we have private constructors, so that the instance defined in this class, can be only assigned to this constructors. From outside of claa, this parameters of the constructor cannot be initialized. */
    private Condition2(String cond, String keys) {
        this.cond = cond;
        this.keys = keys;
    }
    /**  create as many methods, and manipulate them, and return them  */
    public String caution(){
        return cond.toLowerCase(Locale.ROOT);
    }
}
