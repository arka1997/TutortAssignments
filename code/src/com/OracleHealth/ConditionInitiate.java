package com.OracleHealth;

import static com.OracleHealth.Condition.HOT;
import static com.OracleHealth.Condition2.LUKE_WARM;

public class ConditionInitiate {

    public static void main(String[] args) {
        Enum_SwitchCasePractice_Conditions e = new Enum_SwitchCasePractice_Conditions(HOT,LUKE_WARM);
        System.out.println(e.serve());
    }
}