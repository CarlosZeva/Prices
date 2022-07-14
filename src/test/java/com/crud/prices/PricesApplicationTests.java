package com.crud.prices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class PricesApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void testGetpricesByParams() throws Exception{
		mock.perform(get("/prices/rate")
				.param("fecha", "2020-06-14 10:00:00.0")
				.param("productId", "35455")
				.param("brandId", "1")
			)	
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(1)
	void testGetpricesByParams2() throws Exception{
		mock.perform(get("/prices/rate")
				.param("fecha", "2020-06-14 16:00:00.0")
				.param("productId", "35455")
				.param("brandId", "1")
			)
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	void testGetpricesByParams3() throws Exception{
		mock.perform(get("/prices/rate")
				.param("fecha", "2020-06-14 21:00:00.0")
				.param("productId", "35455")
				.param("brandId", "1")
			 )
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(3)
	void testGetpricesByParams4() throws Exception{
		mock.perform(get("/prices/rate")
				.param("fecha", "2020-06-15 10:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
			 )
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	@Order(4)
	void testGetpricesByParams5() throws Exception{
		mock.perform(get("/prices/rate")
				.param("fecha", "2020-06-16 21:00:00")
				.param("productId", "35455")
				.param("brandId", "1"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(5)
	void testGetAllPrices() throws Exception{
		mock.perform(get("/prices"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@Order(6)
	void testDeletePrices() throws Exception{
		mock.perform(delete("/prices/4"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
}
