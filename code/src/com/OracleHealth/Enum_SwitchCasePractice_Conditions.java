package com.OracleHealth;


import java.util.Arrays;
import java.util.List;

public class Enum_SwitchCasePractice_Conditions {

    private Condition condition;
    private Condition2 condition2;
    Enum_SwitchCasePractice_Conditions(Condition condition, Condition2 condition2){
        this.condition = condition;
        this.condition2 = condition2;
    }
    public String serve() {
/**        Switch-Case 1        */
        switch(condition){
            case COLD -> {
                System.out.println("Water is cold");
            }
            case HOT -> {
                System.out.println("Water is Hot");

            }
            case WARM -> {
                System.out.println("Water is warm");

            }
            default -> throw new IllegalStateException("Unexpected value: " + condition);
        }

/**        Switch-Case 2        */
// Returns in 1 line statement, and no fall-off, like case 1-2-2-4, has no breaks, and 5th has a break with a value, so all these will give result of the 5th value
        String val = switch(condition2){
            case FROZEN -> "Water is FROZEN";
            case LUKE_WARM -> "Water is luke_warm";
            default -> throw new IllegalStateException("Unexpected value: " + condition);
        };
        System.out.println(val);


/**        Switch-Case 3        */
        return switch (condition) {
            case COLD -> {
                System.out.println("Water is cold");
                yield "Cold Water";// This are values needed to be returned
            }
            case HOT -> {
                System.out.println("Water is hot");
                yield "Hot Water";
            }
            case WARM -> {
                System.out.println("Water is warm");
                yield "Warm Water";
            }
        };

    }
}