package example;

import db.Entity;

public class Human extends Entity implements Cloneable {
    public String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
          Human humanCopy = (Human) super.clone();
          humanCopy.name = this.name;
          return humanCopy;

    }
}
