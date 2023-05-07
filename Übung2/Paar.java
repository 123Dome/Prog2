public class Paar<E,Z> {
    private E erstes;
    private Z zweites;

    public Paar(E pErstes, Z pZweites){
        this.erstes = pErstes;
        this.zweites = pZweites;
    }

    public E getErstes() {
        return this.erstes;
    }

    public Z getZweites() {
        return this.zweites;
    }

    public E setErstes(E e){
        E tmp = this.erstes;
        this.erstes = e;
        return tmp;
    }

    public Z setZweites(Z z){
        Z tmp = this.zweites;
        this.zweites = z;
        return tmp;
    }

    public void setBeides(E e, Z z){
        this.erstes = e;
        this.zweites = z;
    }

    public boolean equals(Paar<E,Z> p){
        return this.erstes == p.getErstes() && this.zweites == p.getZweites();
    }

    @Override
    public String toString(){
        return "(" + this.erstes + "," + this.zweites + ")";
    }
}
