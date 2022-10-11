package org.SDA.Banking;

public class RegularAccount extends BankAccount {
    protected Integer money;

    public RegularAccount() {
        money = 0;
    }

    @Override
    public void depositMoney(Integer money) {
        this.money = money;
    }

    @Override
    public Integer withdrawMoney(Integer money) {
        if (this.money >= money) {
            this.money = 0;
            return money;
        }
        else {
            Integer temp = this.money;
            this.money = 0;
            return temp;
        }
    }

    public Integer getMoney() {
        return money;
    }
}
