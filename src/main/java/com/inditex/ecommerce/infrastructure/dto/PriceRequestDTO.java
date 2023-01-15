package com.inditex.ecommerce.infrastructure.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class PriceRequestDTO {
    private final Integer productId;
    private final Integer brandId;
    private final LocalDateTime date;

    public PriceRequestDTO(Integer productId, Integer brandId, LocalDateTime date) {
        this.productId = productId;
        this.brandId = brandId;
        this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }
    public Integer getBrandId() {
        return brandId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceRequestDTO that = (PriceRequestDTO) o;
        return productId.equals(that.productId) && brandId.equals(that.brandId) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, date);
    }
}
