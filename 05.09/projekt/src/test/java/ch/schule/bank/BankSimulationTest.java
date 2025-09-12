package ch.schule.bank;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank Simulation Tests")
class BankSimulationTest {

    Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank();
        bank.createAccount("A", "Alice", 10_00);
        bank.createAccount("B", "Bob", 0);
    }

    @Test
    void deposit_and_withdraw_work() {
        Account a = bank.find("A").orElseThrow();
        a.deposit(5_00);
        assertEquals(15_00, a.getBalanceCents());
        a.withdraw(2_50);
        assertEquals(12_50, a.getBalanceCents());
    }

    @Test
    void withdraw_more_than_balance_throws() {
        Account b = bank.find("B").orElseThrow();
        assertThrows(IllegalStateException.class, () -> b.withdraw(1));
    }

    @Test
    void transfer_moves_money_between_accounts() {
        bank.transfer("A", "B", 3_00);
        assertEquals(7_00, bank.find("A").orElseThrow().getBalanceCents());
        assertEquals(3_00, bank.find("B").orElseThrow().getBalanceCents());
    }

    @Test
    void transfer_invalid_accounts_throw() {
        assertThrows(NoSuchElementException.class, () -> bank.transfer("X", "B", 100));
        assertThrows(NoSuchElementException.class, () -> bank.transfer("A", "Y", 100));
    }

    @Test
    void transfer_invalid_amount_throws() {
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("A", "B", 0));
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("A", "B", -1));
    }

    @Test
    void cannot_create_duplicate_account() {
        assertThrows(IllegalArgumentException.class,
                () -> bank.createAccount("A", "Another", 0));
    }
}
