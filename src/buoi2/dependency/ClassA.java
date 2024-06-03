package buoi2.dependency;

public class ClassA {
    //field, attribute

    //function , methods
    ClassA(ClassB bRemote){//bRemote: local variable
    }

    ClassA(){
        ClassB bRemote = new ClassB();
    }

    public void setBRmemote(ClassB bRemote) {
       bRemote.methodB();
    }
    public void methodA() {
      //  bRemote.methodB();//messsage
      ClassB bRemote = new ClassB();
      bRemote.methodB();
    }

   
}
