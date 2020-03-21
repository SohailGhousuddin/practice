package spring.example.microservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-echange-service",url="localhost:8000")
//@FeignClient(name="currency-echange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-echange-service")
public interface CurrencyExchangeServiceProxy {
	

//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-echange-service/from/{from}/to/{to}")
	public CurrencyConvert retrieveExchangeValue(
			@PathVariable("from") String from,@PathVariable("to") String to);
	

}
