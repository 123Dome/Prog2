public class GenericsFehler{
	public static void main(String[] args){
		MyObject mo = new MyObject();
		MyGeneric<String> mg = new MyGeneric<>(); 

		String s1 = "Hallo";
		Integer i1 = 42;

		mo.set(i1);
		mo.set(s1);
		String s2 = (String) mo.get(); 
	        Integer i2 = (Integer) mo.get(); // Geht nicht, da man von String auf Integer casten will
		

		mg.set(s1);
		//mg.set(i1); // Funltioniert nicht, da der Typ der Klasse ein String ist
		String s3 = mg.get(); 
		//Integer i3 = (Integer)mg.get(); // Funktioniert nicht, da man von String nach Integer casten will
	}
}

/** This class is a simplified 'container' for objects of type Object
    thus all subtypes of Object can be stored
    so in Java every kind of type   */
class MyObject{
	private Object o;
	public void set(Object o){
		this.o = o;
	}
	public Object get(){
		return o;
	}
}

/** This is a simple container for storing an object of a generic type
    so any given type (and it's subclasses) */
class MyGeneric<T>{
	private T o;
	public void set(T o){
		this.o = o;
	}
	public T get(){
		return o;
	}
}
