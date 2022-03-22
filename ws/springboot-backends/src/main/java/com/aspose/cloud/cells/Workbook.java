package com.aspose.cloud.cells;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Workbook {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Workbook Constructor, set the file name and password
	// / </summary>
	// / <param name="fileName"> File Name</param>
	public Workbook(String fileName) {
		FileName = fileName;
	}

	public Workbook(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Get Document's properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public List<DocumentProperty> GetProperties() {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/documentProperties";

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

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getDocumentProperties()
					.getDocumentPropertyList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Get a Particular Property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns></returns>
	public DocumentProperty GetProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/documentProperties/" + propertyName;

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

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getDocumentProperty();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Set document property
	// / </summary>
	// / <param name="propertyName">property name</param>
	// / <param name="propertyValue">property value</param>
	public boolean SetProperty(String propertyName, String propertyValue) {
		try {
			// build URI to get page count
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName + "/documentProperties/"
					+ propertyName;
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

			// serialize the JSON request content
			DocumentProperty docProperty = new DocumentProperty();
			docProperty.setValue(propertyValue);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(docProperty, DocumentProperty.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("201")
					& baseResponse.getStatus().equals("Created"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean RemoveAllProperties() {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/documentProperties";

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

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			BaseResponse workbookResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (workbookResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean RemoveProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/documentProperties/" + propertyName;

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

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			BaseResponse workbookResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (workbookResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="newWorkbookName"></param>
	public boolean CreateEmptyWorkbook() {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName;

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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean CreateWorkbookFromTemplate(String templateFileName) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "?templatefile=" + templateFileName;
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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="newWorkbookName"></param>
	// / <param name="templateFileName"></param>
	// / <param name="dataFile"></param>
	public boolean CreateWorkbookFromSmartMarkerTemplate(
			String templateFileName, String dataFile) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "?templatefile=" + templateFileName + "&dataFile="
					+ dataFile;
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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean ProcessSmartMarker(String dataFile) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/smartmarker?xmlFile=" + dataFile;
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

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	 public Name GetName(String name)
     {
		 try {
				// check whether file is set or not
				if (FileName == "")
					throw new Exception("No file name specified");

				// build URI
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()+ "/cells/" + FileName;
	             strURI += "/names/"+name;

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

				// Parse the json string to JObject and Deserializes the JSON to a
				// object.
				NameResponse nameResponse = gson.fromJson(strJSON,
						NameResponse.class);
				return nameResponse.getSName();
				 
			}

			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
}
	public int GetWorksheetsCount() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets";

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

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getWorksheets().getWorksheetList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int GetNamesCount() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/names";

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

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getNames().getCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public Style getDefaultStyle() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/defaultStyle";

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

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getStyle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean EncryptWorkbook(EncryptionType encryptionType,
			String password, int keyLength) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/encryption";
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

			// serialize the JSON request content
			Encryption encryption = new Encryption();
			encryption.setEncryptionType(encryptionType);
			encryption.setPassword(password);
			encryption.setKeylength(keyLength);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(encryption, Encryption.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

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

	public boolean ProtectWorkbook(ProtectionType protectionType,
			String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/protection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setProtectionType(protectionType);
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

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

	public boolean UnprotectWorkbook(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/protection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

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

	public boolean SetModifyPassword(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/writeProtection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

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

	public boolean ClearModifyPassword(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/writeProtection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE", strJSON);

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

	public boolean DecryptWorkbook(String password) {

		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/encryption";
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
			// serialize the JSON request content
			Encryption encryption = new Encryption();

			encryption.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(encryption, Encryption.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE", strJSON);

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

	// / <summary>
	// /
	// / </summary>
	// / <param name="worksheetName"></param>

	public boolean AddWorksheet(String worksheetName) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/worksheets/" + worksheetName;
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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("201"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="worksheetName"></param>
	// / <returns></returns>
	public boolean RemoveWorksheet(String worksheetName) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + worksheetName;

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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean MergeWorkbook(String mergefileName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/merge?mergeWith=" + mergefileName;

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

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean SplitDocument(SplitDocumentFormats format, int from, int to) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
            strURI += "/split?" +
                (format == null ? "" : "format=" + format) +
                (from == 0 ? "" : "&from=" + from) +
                (to == 0 ? "" : "&to=" + to);
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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST");
			String strJSON = Utils.StreamToString(responseStream);
			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Workbook name
	// / </summary>
	public String FileName;

}