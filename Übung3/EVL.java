import java.util.NoSuchElementException;

public class EVL <T>{
    private ListenEl first = null;
    private ListenEl last = null;
    private int size = 0;

    class ListenEl<T>{
        T data;
        ListenEl next;

        public ListenEl(T d){
            data = d;
            next = null;
        }
    }

    public boolean isÉmpty(){
        return this.first == null;
    }

    // Gibt die Daten vom ersten Element
    public T getFirst() {
        if(this.isÉmpty()) throw new NoSuchElementException();
        return (T) this.first.data;
    }

    // Gibt die Daten vom letzten Element
    public T getLast() {
        if(this.isÉmpty()) throw new NoSuchElementException();
        return (T) this.last.data;
    }

    public void addFirst(T d){
        ListenEl e = new ListenEl(d);
        if(this.isÉmpty()) {
            this.first = e;
            this.last = e;
        }
        e.next = this.first;
        this.first = e;
        this.size++;
    }

    public void addLast(T d){
        ListenEl e = new ListenEl(d);
        if(this.isÉmpty()) {
            this.first = e;
            this.last = e;
        }
        this.last.next = e;
        this.last = e;
        this.size++;
    }

    public T removeFirst(){
        if(this.isÉmpty()) throw new NoSuchElementException();
        T tmp = (T) this.first.data;
        this.first = this.first.next;
        this.size--;
        return tmp;
    }

    public T removeLast(){
        if(this.isÉmpty()) throw new NoSuchElementException();
        T tmp = (T) this.last.data;
        ListenEl temp;
        for(temp = this.first; temp.next != this.last; temp = temp.next);
        temp.next = null;
        this.last = temp;
        this.size--;
        return tmp;
    }

    public boolean contains(T o){
        if(this.isÉmpty()) throw new NoSuchElementException();
        for(ListenEl tmp = this.first; tmp.next != null; tmp = tmp.next){
            if(tmp.data.equals(o)) return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        if(this.isÉmpty()) return "";
        return toString1(this.first);
    }

    public String toString1(ListenEl e){
        if(e.next == null){
            return "" + e.data;
        } else {
            return e.data + "-" + this.toString1(e.next);
        }
    }
}
