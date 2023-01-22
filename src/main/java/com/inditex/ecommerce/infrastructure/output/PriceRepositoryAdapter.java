package com.inditex.ecommerce.infrastructure.output;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.ecommerce.infrastructure.output.persistence.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.inditex.ecommerce.application.ports.output.PriceRepositoryPort;
import com.inditex.ecommerce.domain.model.Price;

@Repository
public class PriceRepositoryAdapter  implements PriceRepositoryPort{
	
	@Autowired
	PriceRepository priceRepository;
    
    public List<Price> findPrices (Integer productId, Integer brandId, LocalDateTime applicationDate) {
		 List<com.inditex.ecommerce.infrastructure.output.entities.Price> prices = 
				 priceRepository.findByIdAndBrandAndDate(productId, brandId, 
						 applicationDate);
		 return toModelPrice(prices);		 
		    
    }

	private List<Price> toModelPrice(List<com.inditex.ecommerce.infrastructure.output.entities.Price> prices) {
		if(CollectionUtils.isEmpty(prices)) {
			return new ArrayList<Price>();
		 }
		 return prices.stream().map(price -> new Price(
				price.getId(), price.getPriceList(), 
				price.getBrandId(), price.getStartDate(), 
				price.getEndDate(), price.getPriority(), 
				price.getPrice(), price.getCurr()))
				.collect(Collectors.toList());
	}
}
