package com.curr.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/conversionfactors")
public class ConversionFactors {
	private static Map<String, Double> factors = new HashMap<String, Double>();

	public ConversionFactors() {
		factors.put("INR", Double.valueOf(71.1));
		factors.put("CAD", Double.valueOf(1.3));
		factors.put("TBH", Double.valueOf(31.9));
		factors.put("ETH", Double.valueOf(0.0079));
	}

	@PostMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor addConversionFactor(@PathVariable("currencyCode") String currencyCode,
			@RequestBody ConversionFactor cf) {
		if (StringUtils.isEmpty(cf.getCurrencyCode()) || cf.getFactor() == null) {
			throw new IllegalArgumentException("Invalid input!");
		}
		if (!cf.getCurrencyCode().equals(currencyCode)) {
			throw new IllegalArgumentException("Resource identified does not match payload!");
		}
		if (factors.containsKey(cf.getCurrencyCode())) {
			throw new IllegalArgumentException("Currency code already exists: " + currencyCode);
		}
		factors.put(cf.getCurrencyCode(), cf.getFactor());
		return getRecord(currencyCode);
	}

	@PutMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor updateConversionFactor(@PathVariable("currencyCode") String currencyCode,
			@RequestBody ConversionFactor cf) {
		if (StringUtils.isEmpty(cf.getCurrencyCode()) || cf.getFactor() == null) {
			throw new IllegalArgumentException("Invalid input!");
		}
		if (!cf.getCurrencyCode().equals(currencyCode)) {
			throw new IllegalArgumentException("Resource identified does not match payload!");
		}
		if (!factors.containsKey(cf.getCurrencyCode())) {
			throw new IllegalArgumentException("Currency code does not exist: " + currencyCode);
		}
		factors.put(cf.getCurrencyCode(), cf.getFactor());
		return getRecord(currencyCode);
	}

	@GetMapping("/{currencyCode}")
	@ResponseBody
	public ConversionFactor getConversionFactor(@PathVariable String currencyCode) {
		if (!factors.containsKey(currencyCode)) {
			throw new IllegalArgumentException("Currency code does not exist: " + currencyCode);
		}
		System.out.println("Called!");
		return getRecord(currencyCode);
	}

	private ConversionFactor getRecord(String currencyCode) {
		return new ConversionFactor(currencyCode, factors.get(currencyCode));
	}
}
