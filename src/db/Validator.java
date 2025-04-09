package db;

import db.exception.InvalidEnitityException;

public interface Validator {

    void validate(Entity entity) throws InvalidEnitityException;

}
