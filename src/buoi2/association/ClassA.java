package buoi2.association;

public class ClassA {
    //field, attribute
    private ClassB bRemote;// instance field/ varible


    //function , methods
    ClassA(ClassB bRemote){//bRemote: local variable
        this.bRemote = bRemote;
    }

    ClassA(){}

    public void setBRmemote(ClassB bRemote) {
        this.bRemote = bRemote;
    }
    public void methodA() {
        bRemote.methodB();//messsage
    }

   
}
