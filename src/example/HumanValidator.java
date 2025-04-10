package example;

import db.Entity;
import db.Validator;
import db.exception.InvalidEnitityException;

public class HumanValidator implements Validator {

    @Override
    public void validate(Entity entity) throws InvalidEnitityException{

            if (!(entity instanceof Human))
                throw new IllegalArgumentException();
            else {
                Human human = (Human) entity;
                if( ((Human) entity).name == null ){
                    throw new InvalidEnitityException("name cannot be null.");
                }
                if( ((Human) entity).age < 0 ){
                    throw new InvalidEnitityException("age cannot be negative.");
                }
            }
    }
}