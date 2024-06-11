package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    Store store;

    Product product = new Product();
    Customer customer = new Customer();
    public StoreMockitoTest() {
    }

    @Test
    void test1() {
        this.product.setQuantity(8);
        AccountManager accountManager = (AccountManager)Mockito.mock(AccountManager.class);
        Mockito.when(accountManager.withdraw((Customer)Mockito.any(), Mockito.anyInt())).thenReturn("success");
        this.store = new StoreImpl(accountManager);
        this.store.buy(this.product, this.customer);
        Assertions.assertEquals(7, this.product.getQuantity());
    }

    @Test
    void testFailureWithdraw() {
        this.product.setQuantity(8);
        AccountManager accountManager = (AccountManager)Mockito.mock(AccountManager.class);
        Mockito.when(accountManager.withdraw((Customer)Mockito.any(), Mockito.anyInt())).thenReturn("failure");
        this.store = new StoreImpl(accountManager);

        Assertions.assertThrows(RuntimeException.class,()->this.store.buy(this.product, this.customer));
        Assertions.assertEquals(8, this.product.getQuantity());
    }

}
