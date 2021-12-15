package polymorphism;

public class WithdrawMoney {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4,5,6,7};
        for (int num : numbers) {
            Saving saving = new Saving();
            if(num % 2 == 0){
                saving.withdraw();
            }else{
                saving.withdrawFromParent();
            }
        }
    }
}
