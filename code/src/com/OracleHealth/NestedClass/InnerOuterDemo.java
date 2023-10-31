package com.OracleHealth.NestedClass;

import java.util.HashSet;
import java.util.Set;

public class InnerOuterDemo {
    private static Set<Inner> s = new HashSet<>();
    public void addInner(Samsung samsung, int quality){
        s.add(new Inner(samsung, quality));
    }
    class Inner{
        private Samsung samsung;
        private int quality;
        Inner(Samsung samsung, int quality){
            this.samsung = samsung;
            this.quality = quality;
        }
    }

    public static void main(String[] args) {
        InnerOuterDemo o = new InnerOuterDemo();
        o.addInner(new Samsung(7, "200 GB"), 6);
        o.addInner(new Samsung(8, "500 GB"), 7);
        o.addInner(new Samsung(9, "800 GB"), 8);
        s.stream().forEach(e -> System.out.println(e.quality));
    }
}
