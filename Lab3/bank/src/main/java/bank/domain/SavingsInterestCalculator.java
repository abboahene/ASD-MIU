package bank.domain;

public class SavingsInterestCalculator extends InterestCalculator{

    @Override
    public double calcInterest(Account account) {
//        If balance < 1000 then you get 1% interest
//        If balance > 1000 and balance < 5000 then you get 2% interest
//        If balance > 5000 then you get 4% interest
        double balance = account.getBalance();
        if(balance < 1000){
            return balance * 0.01;
        }else if(balance > 1000 && balance < 5000 ){
            return balance * 0.02;
        }else if(balance > 5000){
            return balance * 0.04;
        }
        return 0;
    }
}
