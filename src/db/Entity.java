package db;

public abstract class Entity implements Cloneable {

        public int id;

        //with the clone() method
        @Override
        public Entity clone() throws CloneNotSupportedException {
            return (Entity) super.clone();
        }

        //with the copy() method
        //public abstract Entity copy();
}