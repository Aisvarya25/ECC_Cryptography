package com.aspose.cloud.common;

public class AsposeAppNonStatic {
	private String AppSID;
	private String AppKey;

	public AsposeAppNonStatic(String appKey, String appSID) {
		this.AppKey = appKey;
		this.AppSID = appSID;
	}

	public String getAppSID() {
		return AppSID;
	}

	public void setAppSID(String appSID) {
		AppSID = appSID;
	}

	public String getAppKey() {
		return AppKey;
	}

	public void setAppKey(String appKey) {
		AppKey = appKey;
	}

	public boolean validateAuth() {
		if (this.AppKey.equals("") || this.AppKey.equals(null) || this.AppKey.length() == 0
				|| this.AppSID.equals("") || this.AppKey.equals(null) || this.AppSID.length() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
