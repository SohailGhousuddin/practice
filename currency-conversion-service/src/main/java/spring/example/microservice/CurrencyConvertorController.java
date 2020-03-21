package spring.example.microservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertorController {
	
	@Autowired
	private CurrencyExchangeServiceProxy cESP;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvert retrieveCurrencyConversion
	                    (@PathVariable String from,@PathVariable String to,
	                    		@PathVariable BigDecimal quantity )
	{
		Map<String,String> uriVariables= new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		ResponseEntity<CurrencyConvert> responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/{from}/to/{to}",CurrencyConvert.class,uriVariables);
		
		CurrencyConvert response = responseEntity.getBody();
		return new CurrencyConvert(response.getId(),from,to,
				response.getConversionMultiple(),
				quantity,
				quantity.multiply(response.getConversionMultiple()),
				response.getPort());
	}

	@GetMapping("/currency-converterFeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvert retrieveCurrencyConversionFeign
	                    (@PathVariable String from,@PathVariable String to,
	                    		@PathVariable BigDecimal quantity )
	{
		
		CurrencyConvert response = cESP.retrieveExchangeValue(from, to);
		return new CurrencyConvert(response.getId(),from,to,
				response.getConversionMultiple(),
				quantity,
				quantity.multiply(response.getConversionMultiple()),
				response.getPort());
	}
}
