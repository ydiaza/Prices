package com.inditex.ecommerce;

import com.inditex.ecommerce.infrastructure.helpers.DateTimeConverter;
import com.inditex.ecommerce.infrastructure.dto.PriceResponseDTO;
import com.inditex.ecommerce.infrastructure.rest.PriceController;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PricesApplicationTests {


	@Autowired
	PriceController priceController;

	@ParameterizedTest
	@CsvSource(value = {
	     "35455, 1, 2020-06-14-10.00.00"
	})
	void test1(Integer productId, Integer brandId, String priceDate) throws Exception {
		//given

		//when
		ResponseEntity<List<PriceResponseDTO>> response = priceController.getPrices(productId, brandId, priceDate);

		//then
		List<PriceResponseDTO> prices = response.getBody();
		if(CollectionUtils.isEmpty(prices)){
			throw new Exception("Data not found");
		}
		assertEquals(prices.size(),1);
		assertsProduct(prices.get(0), 35455, 1, 1, "2020-06-14-00.00.00",
				"2020-12-31-23.59.59", 35.50);

	}

	@ParameterizedTest
	@CsvSource(value = {
			"35455, 1, 2020-06-14-16.00.00"
	})
	void test2(Integer productId, Integer brandId, String priceDate) throws Exception {
		//given

		//when
		ResponseEntity<List<PriceResponseDTO>> response = priceController.getPrices(productId, brandId, priceDate);

		//then
		List<PriceResponseDTO> prices = response.getBody();
		if(CollectionUtils.isEmpty(prices)){
			throw new Exception("Data not found");
		}
		assertEquals(prices.size(),1);
		assertsProduct(prices.get(0), 35455, 1, 2, "2020-06-14-15.00.00",
				"2020-06-14-18.30.00", 25.45);

	}
	@ParameterizedTest
	@CsvSource(value = {
			"35455, 1, 2020-06-14-21.00.00"
	})
	void test3(Integer productId, Integer brandId, String priceDate) throws Exception {
		//given

		//when
		ResponseEntity<List<PriceResponseDTO>> response = priceController.getPrices(productId, brandId, priceDate);

		//then
		List<PriceResponseDTO> prices = response.getBody();
		if(CollectionUtils.isEmpty(prices)){
			throw new Exception("Data not found");
		}
		assertEquals(prices.size(),1);
		assertsProduct(prices.get(0), 35455, 1, 1, "2020-06-14-00.00.00",
				"2020-12-31-23.59.59", 35.50);

	}


	@ParameterizedTest
	@CsvSource(value = {
			"35455, 1, 2020-06-15-10.00.00"
	})
	void test4(Integer productId, Integer brandId, String priceDate) throws Exception {
		//given

		//when
		ResponseEntity<List<PriceResponseDTO>> response = priceController.getPrices(productId, brandId, priceDate);

		//then
		List<PriceResponseDTO> prices = response.getBody();
		if(CollectionUtils.isEmpty(prices)){
			throw new Exception("Data not found");
		}
		assertEquals(prices.size(),1);
		assertsProduct(prices.get(0), 35455, 1, 3, "2020-06-15-00.00.00",
				"2020-06-15-11.00.00", 30.50);

	}
	@ParameterizedTest
	@CsvSource(value = {
			"35455, 1, 2020-06-16-21.00.00"
	})
	void test5(Integer productId, Integer brandId, String priceDate) throws Exception {
		//given

		//when
		ResponseEntity<List<PriceResponseDTO>> response = priceController.getPrices(productId, brandId, priceDate);

		//then
		List<PriceResponseDTO> prices = response.getBody();
		if(CollectionUtils.isEmpty(prices)){
			throw new Exception("Data not found");
		}
		assertEquals(prices.size(),1);
		assertsProduct(prices.get(0), 35455, 1, 4, "2020-06-15-16.00.00",
				"2020-12-31-23.59.59", 38.95);

	}

	private static void assertsProduct(PriceResponseDTO actualPrice, Integer expectedProduct, Integer expectedBrand,
								Integer expectedPriceList, String expectedStartDate, String expectEndDate, Double expectedPrice) {

		assertEquals(expectedProduct, actualPrice.getProductId());
		assertEquals(expectedBrand, actualPrice.getBrandId());
		assertEquals(expectedPriceList, actualPrice.getPriceList());
		assertEquals(DateTimeConverter.dateConverterFromStringToLocalDateTime(expectedStartDate), actualPrice.getStartDate());
		assertEquals(DateTimeConverter.dateConverterFromStringToLocalDateTime(expectEndDate), actualPrice.getEndDate());
		assertEquals(expectedPrice, actualPrice.getPrice());
	}

}
