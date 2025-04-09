package example;

import db.Entity;

public class Human extends Entity implements Cloneable {
    public String name;
    public int age;
    public static final int HUMAN_ENTITY_CODE = 14;

    public Human(String name , int age) {
        this.name = name;
        this.age = age;
    }

    //with the clone() method
    @Override
    public Human clone() throws CloneNotSupportedException {
        try {
            Human humanCopy = (Human) super.clone();
            humanCopy.name = this.name;
            humanCopy.age = this.age;
            return humanCopy;
        }catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }






    //with the copy() method
    /*@Override
    public Human copy() {
        Human copyHuman = new Human(name , age);
        copyHuman.id = id;

        return copyHuman;
    }*/
}
