package buoi2.composition;

public class ClassA {
    //field, attribute
    private ClassB bRemote;// instance field/ varible


    //function , methods
    

    ClassA(){
        bRemote = new ClassB();
    }
    
    public void methodA() {
        bRemote.methodB();//messsage
    }

   
}
