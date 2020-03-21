package spring.example.microservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository eVR;
	
@GetMapping("/currency-exchange/from/{from}/to/{to}")	
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
	ExchangeValue Ex =  eVR.findByFromAndTo(from, to);
		
		Ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return Ex;
	}

}
