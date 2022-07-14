package com.crud.prices.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.prices.model.Prices;

public interface PricesRepository extends JpaRepository<Prices, Long> {

	 List<Prices> findTop1ByProductIdAndBrandIdAndEndDateGreaterThanEqualAndStartDateLessThanEqualOrderByPriorityDesc(long productId,long brandId, String fecha, String fecha2);

}
