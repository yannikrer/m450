package ch.tbz.m450.service;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
class AddressServiceTest {

    private AddressRepository repo;
    private AddressService service;

    @BeforeEach
    void setUp() {
        repo = mock(AddressRepository.class);
        service = new AddressService(repo);
    }

    @Test
    void saveDelegatesToRepository() {
        Address input = new Address(0, "Luca", "Brändli", "076...", new Date());
        Address saved = new Address(42, "Luca", "Brändli", "076...", new Date());
        when(repo.save(any())).thenReturn(saved);

        Address result = service.save(input);

        ArgumentCaptor<Address> captor = ArgumentCaptor.forClass(Address.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().getFirstname()).isEqualTo("Luca");
        assertThat(result.getId()).isEqualTo(42);
    }

    @Test
    void getAllReturnsSorted() {
        Address a = new Address(3, "Aaron", "Meier", "077", new Date());
        Address b = new Address(1, "Ben", "Meier", "078", new Date());
        Address c = new Address(2, "Anna", "Meier", "079", new Date());
        when(repo.findAll()).thenReturn(new ArrayList<>(List.of(b, c, a)));

        List<Address> result = service.getAll();

        // Sorted by comparator: lastname equal, then firstname: Aaron, Anna, Ben
        assertThat(result).containsExactly(a, c, b);
        verify(repo).findAll();
    }

    @Test
    void getAddressDelegatesToRepo() {
        Address a = new Address(7, "Max", "Muster", "079", new Date());
        when(repo.findById(7)).thenReturn(Optional.of(a));

        Optional<Address> result = service.getAddress(7);

        assertThat(result).isPresent().contains(a);
        verify(repo).findById(7);
    }
}
