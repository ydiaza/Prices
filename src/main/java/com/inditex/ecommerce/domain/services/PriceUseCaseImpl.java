package com.inditex.ecommerce.domain.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.ecommerce.application.ports.input.PriceUseCase;
import com.inditex.ecommerce.application.ports.output.PriceRepositoryPort;
import com.inditex.ecommerce.domain.model.Price;


@Service
public class PriceUseCaseImpl implements  PriceUseCase{

    @Autowired
    PriceRepositoryPort priceRepositoryPort;
    
    public List<Price> findPrices(Integer productId,Integer brandId,LocalDateTime date){
    	return priceRepositoryPort.findPrices(productId, brandId, date);
    }
    
    
}
