package com.inditex.ecommerce.application.ports.input;

import com.inditex.ecommerce.infrastructure.dto.PriceRequestDTO;
import com.inditex.ecommerce.infrastructure.dto.PriceResponseDTO;

import java.util.List;

public interface PriceUseCase {
    List<PriceResponseDTO> findPrices(PriceRequestDTO priceRequestDTO);
}
