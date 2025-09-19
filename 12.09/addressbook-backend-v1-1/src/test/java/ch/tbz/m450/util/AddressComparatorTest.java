package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AddressComparatorTest {

    private Address a1;
    private Address a2;
    private Address a3;

    @BeforeEach
    void setUp() {
        a1 = new Address(2, "Anna", "Müller", "079...", new java.util.Date());
        a2 = new Address(1, "Ben", "Muller", "078...", new java.util.Date());
        a3 = new Address(3, "Aaron", "Müller", "077...", new java.util.Date());
    }

    @Test
    void sortsByLastnameThenFirstnameThenId() {
        List<Address> list = new ArrayList<>(List.of(a1, a2, a3));
        list.sort(new AddressComparator());

        // lastName (Müller == Muller via collator), then firstName: Aaron, Anna, Ben; tie-breaker by id
        assertThat(list).containsExactly(a3, a1, a2);
    }

    @Test
    void nullsArePlacedLast() {
        AddressComparator cmp = new AddressComparator();
        assertThat(cmp.compare(a1, null)).isLessThan(0);
        assertThat(cmp.compare(null, a1)).isGreaterThan(0);
        assertThat(cmp.compare(null, null)).isZero();
    }
}
