package com.ayushsingh.shipment.repository;

import com.ayushsingh.shipment.model.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {


    @Query("""
            delete from Shipment s where s.shipmentCode = :shipmentToken
            """)
    void deleteByShipmentToken(@Param("shipmentToken") String shipmentToken);
}