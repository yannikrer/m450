package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Vergleich von Address-Objekten:
 * lastname -> firstname -> id
 * Null-Werte kommen ans Ende (nullsLast).
 * Umlaute/Locale: de-CH
 */
public class AddressComparator implements Comparator<Address> {

    private final Collator collator;
    private final Comparator<String> strCmp;

    public AddressComparator() {
        this(Locale.forLanguageTag("de-CH"));
    }

    public AddressComparator(Locale locale) {
        this.collator = Collator.getInstance(locale);
        this.collator.setStrength(Collator.PRIMARY);
        this.strCmp = Comparator.nullsLast((s1, s2) -> collator.compare(s1, s2));
    }

    @Override
    public int compare(Address a1, Address a2) {
        if (a1 == a2) return 0;
        if (a1 == null) return 1;   // null ans Ende
        if (a2 == null) return -1;

        return Comparator
                .comparing(Address::getLastname, strCmp)
                .thenComparing(Address::getFirstname, strCmp)
                .thenComparing(Address::getId, Comparator.nullsLast(Integer::compareTo))
                .compare(a1, a2);
    }
}
