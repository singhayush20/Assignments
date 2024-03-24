package com.ayushsingh.shipment.service.serviceimpl;

import com.ayushsingh.shipment.model.dto.ShipmentCreateDto;
import com.ayushsingh.shipment.model.dto.ShipmentDetailsDto;
import com.ayushsingh.shipment.model.entity.Shipment;
import com.ayushsingh.shipment.repository.ShipmentRepository;
import com.ayushsingh.shipment.service.ShipmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;
    @Override
    public ShipmentDetailsDto createShipment(ShipmentCreateDto shipmentCreateDto) {
        Shipment shipment=new Shipment();
        shipment.setOrderToken(shipmentCreateDto.getOrderToken());
        shipment.setCurrentShipmentLocation("WAREHOUSE");
        shipment=shipmentRepository.save(shipment);
        return modelMapper.map(shipment,ShipmentDetailsDto.class);
    }

    @Transactional
    @Override
    public Boolean cancelShipment(String shipmentCode) {
       shipmentRepository.deleteByShipmentToken(shipmentCode);
       return true;
    }
}
