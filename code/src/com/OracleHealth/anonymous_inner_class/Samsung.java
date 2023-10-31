package com.OracleHealth.anonymous_inner_class;

import com.OracleHealth.NestedClass.Mobile;

public class Samsung extends Mobile {
    public Samsung(int unit, String gb) {
        super();
    }

    public static void main(String[] args) {
        /**     Anonymous Inner Class       */
        Samsung s = new Samsung(6, "200 gb"){
//            @Override
            protected int ram(int x){
                return x + 50;
            }
        };
    }
}
