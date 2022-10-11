package org.SDA.Banking;

public class SavingAccount extends RegularAccount implements MonthPassedEventListener {
    private final Integer monthlyInterestRate;

    public SavingAccount(Integer monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public void onMonthPassed() {
        Float interestMultiplier = (100 + monthlyInterestRate) / 100.0f;
        this.money = Math.round(this.money * interestMultiplier);
    }
}
