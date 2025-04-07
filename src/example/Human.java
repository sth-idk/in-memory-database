package example;

import db.Entity;

public class Human extends Entity implements Cloneable {
    public String name;

    public Human(String name) {
        this.name = name;
    }

    //with the clone() method
    @Override
    public Human clone() throws CloneNotSupportedException {
        try {
            Human humanCopy = (Human) super.clone();
            humanCopy.name = this.name;
            return humanCopy;
        }catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }


    //with the copy() method
    /*@Override
    public Human copy() {
        Human copyHuman = new Human(name);
        copyHuman.id = id;

        return copyHuman;
    }*/
}
