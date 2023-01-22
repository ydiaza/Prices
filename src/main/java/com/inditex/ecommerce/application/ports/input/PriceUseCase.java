package com.inditex.ecommerce.application.ports.input;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.ecommerce.domain.model.Price;

public interface PriceUseCase {
    List<Price> findPrices(Integer productId,Integer brandId,LocalDateTime date);
}
