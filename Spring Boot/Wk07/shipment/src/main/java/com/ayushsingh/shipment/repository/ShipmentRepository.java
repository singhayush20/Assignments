package com.ayushsingh.shipment.repository;

import com.ayushsingh.shipment.model.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {



    @Modifying
    @Query("""
            delete from Shipment s where s.orderToken = :orderToken
            """)
    void deleteByOrderToken(@Param("orderToken") String orderToken);
}