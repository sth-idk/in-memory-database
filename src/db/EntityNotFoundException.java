package db;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(){
        throw new EntityNotFoundException("Cannot find entity.");
    }

    public EntityNotFoundException(int id){
        throw new EntityNotFoundException("Cannot find entity with Id = " + id);
    }
}
