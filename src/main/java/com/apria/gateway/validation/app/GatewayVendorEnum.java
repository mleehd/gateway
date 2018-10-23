package com.apria.gateway.validation.app;

public enum GatewayVendorEnum {
	
	KAISER("kaiser");
	
	private String vendor;
	
	GatewayVendorEnum(String vendor) {
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}
}
