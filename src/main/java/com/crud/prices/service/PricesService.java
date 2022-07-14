package com.crud.prices.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.crud.prices.exception.BusinessRuleException;
import com.crud.prices.model.Prices;
import com.crud.prices.model.PricesResponse;
import com.crud.prices.repository.PricesRepository;  

@Service  
public class PricesService {

	@Autowired  
	PricesRepository pricesRepository;  

	public List<Prices> getAllPrices()   
	{  
		List<Prices> cPrices = new ArrayList<Prices>();  
		pricesRepository.findAll().forEach(priceS -> cPrices.add(priceS));  
		return cPrices;  
	}  

	public List<PricesResponse> getPricesByParameters(String fecha, long productId, long brandId) {
		List<Prices> cPrices = pricesRepository.findTop1ByProductIdAndBrandIdAndEndDateGreaterThanEqualAndStartDateLessThanEqualOrderByPriorityDesc(productId, brandId, fecha, fecha);
		List<PricesResponse> listPricesResponse = new ArrayList<PricesResponse>();
		
		for (Prices prices : cPrices) {
			PricesResponse pricesResponse = new PricesResponse();
			pricesResponse.setBrandId(prices.getBrandId());
			pricesResponse.setStartDate(prices.getStartDate());
			pricesResponse.setEndDate(prices.getEndDate());
			pricesResponse.setProductId(prices.getProductId());
			pricesResponse.setPriceList(prices.getPriceList());
			pricesResponse.setPrice(prices.getPrice());
			listPricesResponse.add(pricesResponse);
		}
		return listPricesResponse;
	}
	    	 
	public Prices save(Prices price) throws BusinessRuleException
	{  		
		Prices save = new Prices();
		if (pricesRepository.findById(price.getPriceList()).isPresent()) {
			BusinessRuleException exception = new BusinessRuleException("1025", "Validación, PriceList ya Existe",HttpStatus.PRECONDITION_FAILED);
			throw exception;
		}else {
			save = pricesRepository.save(price);
		}
        return save;
	}  
		
	public String delete(String priceList) 
	{  
		if (pricesRepository.findById(Long.parseLong(priceList)).isPresent()) {
			pricesRepository.deleteById(Long.parseLong(priceList));
			return "El Prices List se eliminó correctamente";
		}
		return "El Prices List a eliminar no existe";
		
	}  
	
}


