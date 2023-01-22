package com.inditex.ecommerce.application.ports.output;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.ecommerce.domain.model.Price;

public interface PriceRepositoryPort {

    List<Price> findPrices (Integer productId, Integer brandId, LocalDateTime applicationDate);
}
