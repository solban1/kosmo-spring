package sol.backend.repository;

import java.util.List;

import sol.backend.domain.Address;

public interface AddressRepository {
    List<Address> list();
    Address insert(Address address);
    boolean delete(long seq);
}
