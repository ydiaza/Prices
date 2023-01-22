package com.inditex.ecommerce.infrastructure.rest;


import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.ecommerce.application.ports.input.PriceUseCase;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.dto.PriceResponseDTO;
import com.inditex.ecommerce.infrastructure.helpers.DateTimeConverter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(tags="Consulta Precio")
public class PriceController {

    public static final String EXCEPTION = "Exception ";
    Logger logger = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceUseCase priceUseCase;

    @GetMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Obtener tarifas de precios prioritarios por parámetros",
    notes="Devuelve una lista de precios según la tarifa de mayor prioridad y en función de los parámeros de entrada")
    public ResponseEntity<List<PriceResponseDTO>> getPrices(@ApiParam(value = "Identificador de producto", required = true)  @RequestParam(name="productId") Integer productId, @ApiParam(value = "Identificador de cadena", required = true) @RequestParam(name="brandId") Integer brandId,
                                                            @ApiParam(value = "Fecha de consulta con formato yyyyy-MM-dd-HH.mm.ss", required = true) @RequestParam(name="date") String date) {

        try {
            List<Price> prices = priceUseCase.findPrices(productId, brandId, DateTimeConverter.dateConverterFromStringToLocalDateTime(date));

            if (prices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            //mapper
            return new ResponseEntity<>(toPriceResponseDTO(prices), HttpStatus.OK);

        }catch(DateTimeParseException dte ){
            logger.error(EXCEPTION,dte);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error( EXCEPTION,e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<PriceResponseDTO> toPriceResponseDTO(List<Price> prices){
        if (CollectionUtils.isEmpty(prices)) {
            return new ArrayList<>();
        }
        return prices.stream().map(price -> new PriceResponseDTO(price.getId(), price.getBrandId(), price.getStartDate(),
                price.getEndDate(), price.getPriceList(), price.getPrice())).collect(Collectors.toList());
    }

}
