package com.curr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/convert")
public class Convertor {
	
	@Autowired
	private ConversionFactorDataServiceClient conversionFactorDataServiceClient;
	
	@GetMapping
	@ResponseBody
	public Double convert(@RequestParam(required = true, value = "currencyCode") String currencyCode, @RequestParam(required = true, value = "amount") Double amount) {
		if(StringUtils.isEmpty(currencyCode) || amount == null) {
			throw new IllegalArgumentException("Invalid input!");
		}
		ConversionFactor cf = conversionFactorDataServiceClient.getConversionFactor(currencyCode);
		Double cfValue = cf.getFactor();
		return Double.valueOf(cfValue.doubleValue() * amount.doubleValue());
	}
}
