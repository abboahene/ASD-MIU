package bank.domain;

public class CheckingInterestCalculator extends InterestCalculator{

    @Override
    public double calcInterest(Account account) {

//        If balance < 1000 then you get 1,5% interest
//        If balance > 1000 then you get 2,5% interest
        double balance = account.getBalance();
        if(balance < 1000){
            return balance * 0.015;
        }else if(balance > 1000){
            return balance * 0.025;
        }
        return 0;
    }
}
