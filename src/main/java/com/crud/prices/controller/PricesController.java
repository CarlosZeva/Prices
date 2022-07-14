package com.crud.prices.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.prices.exception.BusinessRuleException;
import com.crud.prices.model.Prices;
import com.crud.prices.model.PricesResponse;
import com.crud.prices.service.PricesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Prices API")
@RestController
@RequestMapping("/prices")
@CrossOrigin(origins = "*")
public class PricesController {
	
	@Autowired  
	PricesService pricesService;  
    
    @ApiOperation(value = "Retorna los precios en base a los filtros de Fecha, BrandId y ProductId")
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok"),		
    	@ApiResponse(code = 204, message = "No existen registros"),
    	@ApiResponse(code = 404, message = "Not found"),
    	@ApiResponse(code = 500, message = "Internal server error")})	
    @GetMapping("/rate")
    public ResponseEntity<List<PricesResponse>> getPricesByParameters(@RequestParam(value="fecha") String fecha,@RequestParam(value="productId") long productId,@RequestParam(value="brandId") long brandId) {
    	List<PricesResponse> cPrices = pricesService.getPricesByParameters(fecha, productId, brandId);
		if (cPrices == null || cPrices.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(cPrices);
		}
		
    }
    
    @ApiOperation(value = "Retorna todos los precios sin filtro")
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "ok"),		
	    @ApiResponse(code = 204, message = "No existen registros"),
	    @ApiResponse(code = 404, message = "Not found"),
	    @ApiResponse(code = 500, message = "Internal server error")})	
    @GetMapping()
    public ResponseEntity<List<Prices>> getAllPrices() {
    	List<Prices> cPrices = pricesService.getAllPrices();  
		if (cPrices == null || cPrices.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(cPrices);
		}
    }
     
    @ApiOperation(value = "Guarda un Price List")
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok"),		
    	@ApiResponse(code = 404, message = "Not found"),
    	@ApiResponse(code = 500, message = "Internal server error")})	
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Prices input) throws BusinessRuleException {
    	Prices save = pricesService.save(input); 
    	return new ResponseEntity<>(save,HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "Elimina un Price List")
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok"),		
    	@ApiResponse(code = 404, message = "Not found"),
    	@ApiResponse(code = 500, message = "Internal server error")})	
    @DeleteMapping("/{priceList}")
    public String delete(@PathVariable String priceList) {
    	return pricesService.delete(priceList);
    }
	
}
