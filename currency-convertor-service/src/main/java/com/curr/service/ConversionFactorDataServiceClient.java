package com.curr.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "current-conversion-factor-data-service", fallback = ConversionFactorDataServiceClientFallBack.class)
@RequestMapping("/conversionfactors")
public interface ConversionFactorDataServiceClient {
	@PostMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor addConversionFactor(@PathVariable("currencyCode") String currencyCode,
			@RequestBody ConversionFactor cf);

	@PutMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor updateConversionFactor(@PathVariable("currencyCode") String currencyCode,
			@RequestBody ConversionFactor cf);

	@GetMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor getConversionFactor(@PathVariable String currencyCode);

}
