package buoi2.dependency;

public class AssoApp {

    public static void main(String[] args) {
        ClassB bRemote = new ClassB();

        //ClassA aRemote = new ClassA(bRemote);
        ClassA aRemote = new ClassA();
        aRemote.setBRmemote(bRemote);

        aRemote.methodA();


    }

}
