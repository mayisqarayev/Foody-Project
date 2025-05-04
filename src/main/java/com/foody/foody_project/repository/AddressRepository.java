package com.foody.foody_project.repository;

import com.foody.foody_project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    @Transactional
    @Modifying
    @Query("""
        update Address a 
        set a.addressName = ?1, a.cityName = ?2, a.stateName = ?3, a.streetName = ?4 
        where a.id = ?5
    """)
    void updateAddress(
            String addressName,
            String cityName,
            String stateName,
            String streetName,
            String id
    );

    @Transactional
    @Modifying
    @Query("""
        update Address a
        set a.addressStatus = false where a.id = ?1
    """)
    void deleteAddressById(String id);


    @Query("""
        select a.id from Address a where a.streetName = ?1
    """)
    String getAddressIdByStreetName(String streetName);
}


