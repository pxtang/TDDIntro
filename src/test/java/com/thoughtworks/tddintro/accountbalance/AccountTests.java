package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account my_acc = new Account(100);
        my_acc.deposit(50);
        assertThat(my_acc.getBalance(),is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        Account my_acc = new Account(100);
        my_acc.withdraw(50);
        assertThat(my_acc.getBalance(),is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        Account my_acc = new Account(50);
        my_acc.withdraw(100);
        assertThat(my_acc.getBalance(),is(50));
    }
}
