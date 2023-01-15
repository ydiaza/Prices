package com.inditex.ecommerce.infrastructure.rest;


import com.inditex.ecommerce.infrastructure.helpers.DateTimeConverter;
import com.inditex.ecommerce.infrastructure.dto.PriceResponseDTO;
import com.inditex.ecommerce.infrastructure.dto.PriceRequestDTO;
import com.inditex.ecommerce.application.ports.input.PriceUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeParseException;
import java.util.List;

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
            PriceRequestDTO priceRequestDTO = new PriceRequestDTO(productId, brandId, DateTimeConverter.dateConverterFromStringToLocalDateTime(date));
            List<PriceResponseDTO> priceList = priceUseCase.findPrices(priceRequestDTO);

            if (priceList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(priceList, HttpStatus.OK);

        }catch(DateTimeParseException dte ){
            logger.error(EXCEPTION,dte);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error( EXCEPTION,e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
