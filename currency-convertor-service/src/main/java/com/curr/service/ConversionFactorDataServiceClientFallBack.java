package com.curr.service;

public class ConversionFactorDataServiceClientFallBack implements ConversionFactorDataServiceClient {
	@Override
	public ConversionFactor addConversionFactor(String currencyCode, ConversionFactor cf) {
		return cf;
	}

	@Override
	public ConversionFactor updateConversionFactor(String currencyCode, ConversionFactor cf) {
		return cf;
	}

	@Override
	public ConversionFactor getConversionFactor(String currencyCode) {
		System.out.println("Fallback called!");
		return new ConversionFactor(currencyCode, Double.valueOf(1.0));
	}
}
