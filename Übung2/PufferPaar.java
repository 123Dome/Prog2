public class PufferPaar {
    public static void main(String[] args){
        Puffer<Paar<Student, String>> servicePoint;
        Puffer<Paar<Boxer, Boxer>> boxEvent;

        servicePoint = new SchlangeMitArray<>(4);
        boxEvent = new StapelMitArray<>(3);

        Student student1 = new Student("Brand", "Philip", 1);
        Student student2 = new Student("Bin-Nor", "Nori", 2);
        Student student3 = new Student("Gauglitz", "Korbinian", 3);
        Student student4 = new Student("Puck", "Dominik", 4);

        Paar<Student, String> f1 = new Paar<>(student1, "Was ist meine Note?");
        Paar<Student, String> f2 = new Paar<>(student2, "Wann ist frei?");
        Paar<Student, String> f3 = new Paar<>(student3, "Hallo?");
        Paar<Student, String> f4 = new Paar<>(student4, "Was gibts zu essen?");

        Boxer boxer1 = new Boxer(student1.getName(), student1.getVorname(), 70);
        Boxer boxer2 = new Boxer(student2.getName(), student2.getVorname(), 99);
        Boxer boxer3 = new Boxer(student3.getName(), student3.getVorname(), 80);
        Boxer boxer4 = new Boxer(student4.getName(), student4.getVorname(), 70);

        Paar<Boxer, Boxer> k1 = new Paar<>(boxer1, boxer2);
        Paar<Boxer, Boxer> k2 = new Paar<>(boxer3, boxer4);
        Paar<Boxer, Boxer> k3 = new Paar<>(boxer1, boxer4);

        servicePoint.insert(f1);
        servicePoint.insert(f2);
        servicePoint.insert(f3);
        servicePoint.insert(f4);

        boxEvent.insert(k1);
        boxEvent.insert(k2);
        boxEvent.insert(k3);

        System.out.println("Fragen:");
        while(!servicePoint.isEmpty()){
            System.out.println(servicePoint.remove());
        }
        System.out.println("Boxkämpfe:");
        while(!boxEvent.isEmpty()){
            System.out.println(boxEvent.remove());
        }
    }
}
