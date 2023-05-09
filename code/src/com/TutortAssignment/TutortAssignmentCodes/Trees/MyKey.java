package com.TutortAssignment.TutortAssignmentCodes.Trees;

public class MyKey {
    private String name;
    private int id;

    public MyKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // standard getters and setters

    @Override
    public int hashCode() {
        System.out.println("First Calling hashCode() and sending id");
        return id;
    }

    // toString override for pretty logging

    @Override
    public boolean equals(Object obj) {
        System.out.println("Second Calling equals() for key: " + obj);
        // generated implementation
//        return false;//if we set the equals method to false, then all the same objects with same hashcode, that hashCode() method will return to equals() method.
                     //All of those objects will be declared different, even thorugh they are same.And same objects will have different buckets for different values.
                    //Thus duplicate entries will be entered in HashMap, and we will violate it's laws.
        return true;//here if we set to true, then all objects with same id=1 with same Hashcode, will be stored inside same bucket, and different ones will have different buckets
    }

}
