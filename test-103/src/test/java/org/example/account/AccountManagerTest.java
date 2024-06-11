package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();

    @Test void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);

        // Act
        String result = accountManager.withdraw(customer, 80);

        // Assert
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(20, expectedBalance);
        Assertions.assertEquals("success", result);
    }
    @Test void givenAmountWithCreditNotAllowedForNormalCustomer(){
        customer.setBalance(100);
        customer.setVip(false);
        String result = accountManager.withdraw(customer, 800);
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(100, expectedBalance);
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test void givenAmountWithCreditNotAllowedForVipCustomer(){
        customer.setBalance(100);
        customer.setVip(true);
        String result = accountManager.withdraw(customer, 800);
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(100, expectedBalance);
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test void givenAmountWithCreditAllowedForVipCustomer(){
        customer.setBalance(100);
        customer.setVip(true);
        customer.setCreditAllowed(true);
        String result = accountManager.withdraw(customer, 2000);
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(-1900, expectedBalance);
        Assertions.assertEquals("success", result);
    }

    @Test void givenAmountWithCreditAllowedForNormalCustomer(){
        customer.setBalance(100);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        String result = accountManager.withdraw(customer, 2000);
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(-1900, expectedBalance);
        Assertions.assertEquals("success", result);
    }

}
