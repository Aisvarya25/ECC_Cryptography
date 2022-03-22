package com.aspose.cloud.words;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

/// <summary>
/// Deals with document level aspects
/// </summary>
public class Document {
	private AsposeAppNonStatic auth;
	// / <summary>
	// / document name
	// / </summary>
	public String FileName;

	// / <summary>
	// / The original format of the file.
	// / </summary>
	public String SourceFormat;

	// / <summary>
	// / Returns true if the document is encrypted and requires a password to
	// open
	// / </summary>
	public String IsEncrypted;

	// / <summary>
	// / Returns true if the document contains a digital signature.
	// / </summary>
	public String IsSigned;

	// / <summary>
	// / Document Properties Response
	// / </summary>
	public DocumentPropertiesResponse documentproperties;

	// / <summary>
	// / Link Response related to document like
	// / <link
	// href="http://api.aspose.com/v1.0/words/TestGet.doc/documentProperties"
	// rel="self" />
	// / </summary>
	public List<LinkResponse> links;
	

	// / <summary>
	// / Document Constructor, set the file name
	// / </summary>
	// / <param name="fileName"> File Name</param>
	public Document(String fileName) {
		FileName = fileName;
	}

	public Document(String fileName, AsposeAppNonStatic auth) {
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
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
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

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.getDocumentProperties().getList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public DocumentProperty GetProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
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

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.getDocumentProperty();
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
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/documentProperties/" + propertyName;
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
			docProperty.setValue( propertyValue);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(docProperty, DocumentProperty.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					strJSON);

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
	// / Delete a document property
	// / </summary>
	// / <param name="propertyName">Property Name</param>
	// / <returns></returns>
	public boolean DeleteProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
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

			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Get Resource Properties information like document source format,
	// IsEncrypted, IsSigned and document properties
	// / </summary>
	// / <returns></returns>
	public DocumentResourceResponse GetDocumentInfo() {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			// strURI += "/document";

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

			DocumentResourceResponse docResponse = gson.fromJson(strJSON,
					DocumentResourceResponse.class);

			return docResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean AppendDocument(String[] appendDocs,
			String[] importFormatModes, String folder) {

		// check whether file is set or not
		if (FileName == "")
			throw new RuntimeException("No file name specified");

		// check whether required information is complete
		if (appendDocs.length != importFormatModes.length)
			throw new RuntimeException(
					"Please specify complete documents and import format modes");

		try {
			// Create DocumentEntryList object
			DocumentEntryList list = new DocumentEntryList();
			list.setDocumentEntries(new java.util.ArrayList<DocumentEntry>());

			for (int i = 0; i < appendDocs.length; i++) {
				String appendDoc = appendDocs[i];
				String docServerPath = (folder != "") ? folder + "\\"
						+ appendDoc : appendDoc;
				list.getDocumentEntries().add(
						new DocumentEntry(docServerPath, importFormatModes[i]));
			}

			// Extract File Name
			String inputFileName = new File(FileName).getName();

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/"
					+ inputFileName + "/appendDocument";
			if (folder != "")
				strURI = strURI + "?folder=" + folder;

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
			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(list, DocumentEntryList.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

			String ResJSONStr = Utils.StreamToString(responseStream);

			Gson gsonObj = new Gson();

			BaseResponse baseResponse = gsonObj.fromJson(ResJSONStr,
					BaseResponse.class);

			if (baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	public boolean PostBookMark(String name, String text)
	{
		try {
			
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			 strURI += "/bookmarks/" + name;

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
			 BookmarkData bookmarkData = new BookmarkData();
             bookmarkData.setName(name);
             bookmarkData.setText(text);
             
             String strJSON = "";

 			Gson gson = new Gson();

 			strJSON = gson.toJson(bookmarkData, BookmarkData.class);

 			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST",
 					strJSON);

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
	public String GetBookMark(String name) {
		String result;
		result="";
		try {
			
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			 strURI += "/bookmarks/" + name;

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

						BookmarkResponse bookmarkResponse = gson.fromJson(strJSON,
					BookmarkResponse.class);
						
			//DocumentResourceResponse docResponse = gson.fromJson(strJSON,
			//		DocumentResourceResponse.class);
						
			result=bookmarkResponse.getBookmark().getText();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}
	 public boolean SaveAsTiff(String resultFile, boolean useAntiAliasing, boolean useHighQualityRendering, int pageCount, int pageIndex, int resolution, String tiffCompression, String folder)
     
	 {
		 try {
				
				// check whether file is set or not
				if (FileName == "")
					throw new Exception("No file name specified");

				// build URI
				String strURI = Product.getBaseProductUri() + "/words/" + FileName+ "/SaveAs/tiff?";
				 strURI += "resultFile=" + resultFile + "&useAntiAliasing=" + (useAntiAliasing ? "True" : "False") + "&useHighQualityRendering=" + (useHighQualityRendering ? "True" : "False") +
		                    "&pageCount=" + pageCount + "&pageIndex=" + pageIndex + "&resolution=" + resolution + "&tiffCompression=" + tiffCompression + "&folder=" + folder;

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
		 			
				 //BookmarkData bookmarkData = new BookmarkData();
	             //bookmarkData.setName(name);
	             //bookmarkData.setText(text);
	             
	             //String strJSON = "";
	 			//strJSON = gson.toJson(bookmarkData, BookmarkData.class);

	 			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
	 					"");

	 			String strResponse = Utils.StreamToString(responseStream);
	 						// Parse the json string to JObject
	BaseResponse baseResponse = gson.fromJson(strResponse,		BaseResponse.class);

	if (baseResponse.getCode().equals("200")		& baseResponse.getStatus().equals("OK"))
		return true;
	else
		return false;

	 			
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
	 }
	public int SplitDocument(String format, String folder, int from, int to)
	{
try {
			
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/split?" +
                    (format == "" ? "" : "format=" + format) +
                    (folder == "" ? "" : "&folder=" + folder) +
                    (from == 0 ? "" : "&from=" +  from) +
                    (to == 0 ? "" : "&to=" + to);

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
	 			
			 //BookmarkData bookmarkData = new BookmarkData();
             //bookmarkData.setName(name);
             //bookmarkData.setText(text);
             
             //String strJSON = "";
 			//strJSON = gson.toJson(bookmarkData, BookmarkData.class);

 			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST",
 					"");

 			//String strResponse = Utils.StreamToString(responseStream);
 						// Parse the json string to JObject
//BaseResponse baseResponse = gson.fromJson(strResponse,		BaseResponse.class);

//if (baseResponse.getCode().equals("200")		& baseResponse.getStatus().equals("OK"))
	//return true;
//else
	//return false;

 			String strJSON = Utils.StreamToString(responseStream);

 			SplitResultResponse splitResultResponse = gson.fromJson(strJSON,
 					SplitResultResponse.class);
						
 			return splitResultResponse.getSplitResult().getPages().size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
}