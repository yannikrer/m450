package ch.schule.bank;

import java.util.Objects;

public class Account {
    private final String id;
    private final String owner;
    private long balanceCents;

    public Account(String id, String owner, long initialCents) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        if (owner == null || owner.isBlank()) throw new IllegalArgumentException("owner required");
        if (initialCents < 0) throw new IllegalArgumentException("initial balance must be >= 0");
        this.id = id;
        this.owner = owner;
        this.balanceCents = initialCents;
    }

    public String getId() { return id; }
    public String getOwner() { return owner; }
    public long getBalanceCents() { return balanceCents; }

    public void deposit(long cents) {
        if (cents <= 0) throw new IllegalArgumentException("deposit must be > 0");
        balanceCents += cents;
    }

    public void withdraw(long cents) {
        if (cents <= 0) throw new IllegalArgumentException("withdraw must be > 0");
        if (cents > balanceCents) throw new IllegalStateException("insufficient funds");
        balanceCents -= cents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
