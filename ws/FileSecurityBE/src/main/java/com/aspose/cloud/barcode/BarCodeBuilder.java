/**
 * 
 */
package com.aspose.cloud.barcode;

import java.io.InputStream;

import com.aspose.cloud.common.AsposeApp;
import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Class to create barcodes.
// / </summary>
// / <example>
// / Create a Code128 barcode and save the barcode image on local system.
// / <code>
// / BarCodeBuilder builder = new BarCodeBuilder("test-123",
// BarCodeType.Pdf417);
// / builder.Save(SaveLocation.Local, "code128.png", ImageFormat.PNG);
// / </code>
// / </example>
public class BarCodeBuilder {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Default constructor, initialize the BarcodeBuilder class
	// / Default symbology is Code128
	// / </summary>
	public BarCodeBuilder() {
		this.BarCodeType = com.aspose.cloud.barcode.BarCodeType.Code128;
		this.Codetext = "test-123";
		this.ImageFormat = com.aspose.cloud.barcode.ImageFormat.PNG;
		this.gson = new Gson();
	}

	public BarCodeBuilder(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / Constructor with codetext and barcode type
	// / </summary>
	// / <param name="codetext">Barcode value</param>
	// / <param name="barcodeType">Barcode type</param>
	public BarCodeBuilder(String codetext, BarCodeType barcodeType) {
		this.BarCodeType = barcodeType;
		this.Codetext = codetext;
		this.ImageFormat = com.aspose.cloud.barcode.ImageFormat.PNG;
		this.gson = new Gson();
	}

	public BarCodeBuilder(String codetext, BarCodeType barcodeType,
			AsposeAppNonStatic auth) {
		this(codetext, barcodeType);
		this.auth = auth;
	}

	// / <summary>
	// / Get or set Codetext of the barcode
	// / </summary>
	public String Codetext;

	// / <summary>
	// / Get or set the type of barcode to be generated e.g. Code128,
	// Code39Standard, Pdf417 etc
	// / </summary>
	public BarCodeType BarCodeType;

	// / <summary>
	// / Get or set the image format of the barcode. Default is PNG
	// / </summary>
	public ImageFormat ImageFormat;

	// / <summary>
	// / Set X resolution in DPI. Default is 96.
	// / </summary>
	public float ResolutionX;

	// / <summary>
	// / Set Y resolution in DPI. Default is 96.
	// / </summary>
	public float ResolutionY;

	// / <summary>
	// / Set X dimension. Default is 0.7.
	// / </summary>
	public float DimensionX;

	// / <summary>
	// / Set Y dimension. Default is 2.
	// / </summary>
	public float DimensionY;

	// / <summary>
	// / Folder name on server, where barcode is to be saved. To be used with
	// Save() method with SaveLocation.Server parameter
	// / </summary>
	public String FolderName;

	Gson gson = null;

	// / <summary>
	// / Creates the barcode and save the barcode image to the local path
	// provided
	// / Examples:
	// / Save(SaveLocation.Local, "c:\\code128.png", ImageFormat.PNG);
	// / Save(SaveLocation.Server, "test-1234.png", ImageFormat.PNG);
	// / </summary>
	// / <param name="SaveLocation">Location where barcode needs to be saved,
	// local or aspose server</param>
	// / <param name="outputPath">Location where barcode is to be saved</param>
	// / <param name="ImageFormat">Image format</param>
	public GenerationResponse Save(
			com.aspose.cloud.barcode.SaveLocation saveLocation, String outputPath,
			com.aspose.cloud.barcode.ImageFormat imageFormat) {
		try {
			PerformValidations();

			// If image needs to be saved locally
			if (saveLocation == SaveLocation.Local) {
				// Build URL with querystring request parameters
				String uri = UriBuilder("");
				InputStream responseStream = null;
				// Send the request to aspose server
				if (this.auth != null) {
					if (!this.auth.validateAuth()) {
						System.out.println("Please Specify AppSID and AppKey");
					} else {
						responseStream = Utils.ProcessCommand(Utils.Sign(uri,
								this.auth.getAppKey(), this.auth.getAppSID()),
								"GET");
					}
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(uri),
							"GET");
				}

				// Read the response, in this case the response is a InputStream
				// that contains barcode image
				// So, just save the response stream to a local image file

				com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
						responseStream);
				responseStream.close();

				GenerationResponse response = new GenerationResponse();
				response.setStatus("OK");
				return response;
			} else if (saveLocation == SaveLocation.Server) {
				// Build URL with querystring request parameters
				String uri = UriBuilder(outputPath);

				// Send the request to aspose server
				InputStream responseStream = null;
				if (this.auth != null) {
					if (!this.auth.validateAuth()) {
						System.out.println("Please Specify AppSID and AppKey");
					} else {
						responseStream = Utils.ProcessCommand(Utils.Sign(uri,
								this.auth.getAppKey(), this.auth.getAppSID()),
								"GET");
					}
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(uri),
							"PUT");
				}
				// Read the response
				String strJSON = Utils.StreamToString(responseStream);

				// Parse and Deserializes the JSON to a object.
				GenerationResponse barcodeGenerationResponse = gson.fromJson(
						strJSON, GenerationResponse.class);

				return barcodeGenerationResponse;
			}

			// Return null, if anything goes wrong
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Creates the barcode and save the barcode image to the supplied stream
	// / Example: Save(SaveLocation.Local, imgStream, ImageFormat.PNG);
	// / </summary>
	// / <param name="imageStream">InputStream where image will be saved</param>
	// / <param name="ImageFormat">Image format</param>
	// public GenerationResponse Save(SaveLocation saveLocation, InputStream
	// imageStream, ImageFormat imageFormat)
	public InputStream Save(ImageFormat imageFormat) {
		try {
			PerformValidations();

			// Build URL with querystring request parameters
			String uri = UriBuilder("");
			InputStream responseStream = null;
			// Send the request to aspose server
			if (this.auth != null) {
				System.out.println("Please Specify AppSID and AppKey");
				if (!this.auth.validateAuth()) {

				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(uri, this.auth.getAppKey(),
									this.auth.getAppSID()), "GET");
				}
			} else {
				responseStream = Utils.ProcessCommand(Utils.Sign(uri), "GET");
			}

			return responseStream;
			// Read the response, in this case the response is a InputStream
			// that contains barcode image
			// Just copy the response stream to the image stream that user
			// passed
			// imageStream= new
			// com.aspose.common.CopyInputStream(responseStream).getCopy();

			// CopyStream(responseStream, imageStream);
			// java.lang.Object.copy()

			// close the response stream
			// responseStream.close();

			// GenerationResponse response = new GenerationResponse();
			// response.getStatus() = "OK";
			// return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Build the URI
	// / </summary>
	private String UriBuilder(String imageFileName) {
		// Initialize with server URI, text and type, which are must
		String uri = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/barcode/";
		// imageFileName is to be handled in case of PUT request, where barcode
		// is to be saved on aspose server
		if (imageFileName != null && imageFileName.trim().length() > 0)
			uri += imageFileName + "/";
		uri += "generate?text=" + Codetext + "&type=" + BarCodeType;

		// Add image format parameter
		uri += "&format=" + ImageFormat;

		// Add folder parameter
		if (FolderName != null && FolderName.trim().length() > 0)
			uri += "&folder=" + FolderName;

		// Add x resolution parameter
		if (ResolutionX != 0.0f)
			uri += "&resolutionX=" + ResolutionX;

		// Add y resolution parameter
		if (ResolutionY != 0.0f)
			uri += "&resolutionY=" + ResolutionY;

		// Add x dimension parameter
		if (DimensionX != 0.0f)
			uri += "&dimensionX=" + DimensionX;

		// Add y dimension parameter
		if (DimensionY != 0.0f)
			uri += "&dimensionY=" + DimensionY;

		// return the URI
		return uri;
	}

	// / <summary>
	// / Perform validations locally
	// / </summary>
	private void PerformValidations() throws Exception {
		// Throw exception if App Key is empty
		if (this.auth != null) {
			if (!this.auth.validateAuth()) {
				if (AsposeApp.getAppKey() == null
						|| AsposeApp.getAppKey().trim().length() == 0)
					throw new Exception(
							"App Key is not specified. Please set the App Key property.");

				// Throw exception if App SID is empty
				if (AsposeApp.getAppSID() == null
						|| AsposeApp.getAppSID().trim().length() == 0)
					throw new Exception(
							"App SID is not specified. Please set App SID property.");

				// Throw exception if codetext is empty
				if (Codetext == null || Codetext.trim().length() == 0)
					throw new Exception(
							"Codetext is not specified. Please set Codetext property.");
			}
		}
	}

}