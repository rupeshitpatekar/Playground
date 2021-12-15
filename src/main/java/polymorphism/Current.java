package polymorphism;

public class Current implements Account{
    @Override
    public void withdraw() {
        System.out.println("Hello from Current account");
    }
}
