import java.util.NoSuchElementException;

public interface Stapel <T> extends Puffer <T>{
    public T top() throws NoSuchElementException;
}
