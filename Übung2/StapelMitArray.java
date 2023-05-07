import java.util.NoSuchElementException;

public class StapelMitArray <T> implements Stapel <T>{
    private T[] stapel;
    private int size = 0;
    public StapelMitArray(int maxGroesse){
        this.stapel = (T[]) new Object[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return this.stapel.length;
    }

    @Override
    public void insert(T obj) throws IllegalStateException {
        if(this.size == this.capacity()) {
            throw new IllegalStateException();
        }
        this.stapel[this.size++] = obj;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.stapel[--this.size];
    }

    @Override
    public T top() throws NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException();
        return this.stapel[this.size-1];
    }

    public void applyToAll(Funktion<T> obj){
        for(int i = 0; i < this.capacity(); i++){
            this.stapel[i] = obj.auswerten(this.stapel[i]);
        }
    }
}
