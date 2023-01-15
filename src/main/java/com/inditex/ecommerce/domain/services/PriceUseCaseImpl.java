package com.inditex.ecommerce.domain.services;

import com.inditex.ecommerce.infrastructure.dto.PriceResponseDTO;
import com.inditex.ecommerce.infrastructure.dto.PriceRequestDTO;
import com.inditex.ecommerce.application.ports.input.PriceUseCase;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.application.ports.output.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceUseCaseImpl implements  PriceUseCase{

    @Autowired
    PriceRepository priceRepositoryPort;
    public List<PriceResponseDTO> findPrices(PriceRequestDTO priceRequestDTO){
        List<Price> priceList= priceRepositoryPort.findByIdAndBrandAndDate(priceRequestDTO.getProductId(),
                priceRequestDTO.getBrandId(), priceRequestDTO.getDate());
        return priceResponseDTOConverter(priceList);
    }
    private List<PriceResponseDTO> priceResponseDTOConverter(List<Price> priceList){
        if (CollectionUtils.isEmpty(priceList)) {
            return new ArrayList<>();
        }
        return priceList.stream().map(price -> new PriceResponseDTO(price.getId(), price.getBrandId(), price.getStartDate(),
                price.getEndDate(), price.getPriceList(), price.getPrice())).collect(Collectors.toList());
    }
}
