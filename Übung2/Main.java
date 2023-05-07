public class Main {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        StapelMitArray<Integer> stapel = new StapelMitArray<Integer>(a.length);
        SchlangeMitArray<Integer> schlange = new SchlangeMitArray<Integer>(a.length);

        for(int i = 0; i < a.length; i++){
            stapel.insert(a[i]);
            schlange.insert(a[i]);
        }

        System.out.println("Integer: ");
        System.out.println("Stapel: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(stapel.remove());
        }
        System.out.println();
        System.out.println("Schlange: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(schlange.remove());
        }

        String b[] = {"Hello", "World"};
        StapelMitArray<String> stapel1 = new StapelMitArray<String>(a.length);
        SchlangeMitArray<String> schlange1 = new SchlangeMitArray<String>(a.length);

        for(int i = 0; i < b.length; i++){
            stapel1.insert(b[i]);
            schlange1.insert(b[i]);
        }

        System.out.println("Strings: ");
        System.out.println("Stapel: ");
        for(int i = 0; i < b.length; i++){
            System.out.print(stapel1.remove());
        }
        System.out.println();
        System.out.println("Schlange: ");
        for(int i = 0; i < b.length; i++){
            System.out.print(schlange1.remove());
        }
    }
}
