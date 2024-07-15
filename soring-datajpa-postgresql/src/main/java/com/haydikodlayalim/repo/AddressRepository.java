package com.haydikodlayalim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.haydikodlayalim.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
