package com.curr.data;

public class ConversionFactor {
	private String currencyCode;
	private Double factor;

	public ConversionFactor() {
		super();
	}

	public ConversionFactor(String currencyCode, Double factor) {
		super();
		this.currencyCode = currencyCode;
		this.factor = factor;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

}
