package polymorphism;

public class Saving extends Current{
    @Override
    public void withdraw() {
        System.out.println("From Saving account");
    }

    public void withdrawFromParent(){
        super.withdraw();
    }
}
