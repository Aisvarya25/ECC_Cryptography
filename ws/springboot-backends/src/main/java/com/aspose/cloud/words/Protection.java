package com.aspose.cloud.words;

import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Protection {
	public String FileName;
	private AsposeAppNonStatic auth;
	
    public Protection(String fileName)
    {
        FileName = fileName;
    }
    public String GetProtection()
    { 
    	try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/protection";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			ProtectionResponse docResponse = gson.fromJson(strJSON,
					ProtectionResponse.class);

			return docResponse.getProtectionData().getProtectionType();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    public boolean ProtectDocument(String password, ProtectionType protectionType)
    {
    	try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/protection";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();

			//serialize the JSON request content
            ProtectionRequest protectionRequest = new ProtectionRequest();
            protectionRequest.setPassword(password);
            protectionRequest.setProtectionType( protectionType.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, ProtectionRequest.class);
			
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    public boolean ChangeProtection(String oldPassword,String newPassword, ProtectionType protectionType)
    {
    	try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/protection";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();

			//serialize the JSON request content
            ProtectionRequest protectionRequest = new ProtectionRequest();
            protectionRequest.setPassword( oldPassword);
            protectionRequest.setNewPassword( newPassword);
            protectionRequest.setProtectionType( protectionType.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, ProtectionRequest.class);
			
			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    public boolean UnProtectDocument(String password)
    {
    	try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/protection";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();

			//serialize the JSON request content
            ProtectionRequest protectionRequest = new ProtectionRequest();
            protectionRequest.setPassword( password);

	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, ProtectionRequest.class);
			
			InputStream responseStream = Utils.ProcessCommand(signedURI, "DELETE",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
}
