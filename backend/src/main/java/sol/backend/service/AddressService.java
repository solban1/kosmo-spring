package sol.backend.service;

import java.util.List;

import sol.backend.domain.Address;

public interface AddressService {
    List<Address> list();
    Address insert(Address address);
    boolean delete(long seq);
}
