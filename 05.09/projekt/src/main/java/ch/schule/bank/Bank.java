package ch.schule.bank;

import java.util.*;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String id, String owner, long initialCents) {
        if (accounts.containsKey(id)) throw new IllegalArgumentException("account exists: " + id);
        Account a = new Account(id, owner, initialCents);
        accounts.put(id, a);
        return a;
    }

    public Optional<Account> find(String id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public void transfer(String fromId, String toId, long cents) {
        if (fromId.equals(toId)) throw new IllegalArgumentException("from and to must differ");
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (from == null || to == null) throw new NoSuchElementException("unknown account");
        if (cents <= 0) throw new IllegalArgumentException("amount must be > 0");
        from.withdraw(cents);
        to.deposit(cents);
    }

    public Collection<Account> allAccounts() {
        return Collections.unmodifiableCollection(accounts.values());
    }
}
