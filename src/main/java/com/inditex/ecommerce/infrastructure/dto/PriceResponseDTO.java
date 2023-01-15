package com.inditex.ecommerce.infrastructure.dto;

import java.time.LocalDateTime;

public class PriceResponseDTO {
    private final Integer productId;
    private final Integer brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priceList;
    private final Double price;

    public PriceResponseDTO(Integer productId, Integer brandId, LocalDateTime startDate,
                            LocalDateTime endDate, Integer priceList, Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Double getPrice() {
        return price;
    }

}
