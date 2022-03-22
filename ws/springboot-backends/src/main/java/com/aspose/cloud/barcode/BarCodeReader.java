/**
 * 
 */
package com.aspose.cloud.barcode;


import java.lang.String;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.*;
import com.aspose.cloud.storage.Folder;
import com.google.gson.*;

import java.io.File;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Class to read barcodes from image. There are 2 ways to feed the image for
// barcode recognition
// / 1. Image from aspose server.
// / 2. Image from any URL.
// / 3. Local image. Image will be uploaded on aspose server in this case.
// / </summary>
public class BarCodeReader {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Default constructor
	// / </summary>
	public BarCodeReader() {
		this.gson = new Gson();

	}

	public BarCodeReader(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	Gson gson = null;
	// Declare private member variables to be used within different methods
	private String _remoteImageName = "";

	// / <summary>
	// / Read barcode from local image. Local image will first be uploaded on
	// aspose server
	// / and then recognized using com.aspose.barcode. Result will be returned
	// to client
	// / </summary>
	// / <param name="localImage">Full path and file name of local image</param>
	// / <param name="remoteFolder">Remote folder name on aspose
	// storage</param>
	// / <param name="barcodeReadType">Barcode type to be recognized</param>
	// / <returns>List of recognized barcodes</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead =
	// reader.ReadFromLocalImage(@"c:\pdf417.jpg", "", BarCodeReadType.Pdf417);
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> ReadFromLocalImage(String localImage,
			String remoteFolder, BarCodeReadType barcodeReadType) {
		try {

			// First upload the local image to remote location
			Folder folder = new Folder();
			folder.UploadFile(localImage, remoteFolder);

			// After upload, perform server recognition on uploaded image
			return Read(new File(localImage).getName(), remoteFolder,
					barcodeReadType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Read barcode from image on aspose server.
	// / </summary>
	// / <param name="remoteImageName">Remote image file name.</param>
	// / <param name="remoteFolder">Optional. Specify folder path to locate the
	// image.</param>
	// / <param name="readType">Barcode type</param>
	// / <returns>List of recognized barcodes</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead = reader.Read("test-1234.png", "",
	// BarCodeReadType.AllSupportedTypes);
	// / Console.WriteLine("Read from server.");
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> Read(String remoteImageName,
			String remoteFolder, BarCodeReadType readType) {
		try {

			_remoteImageName = remoteImageName;

			PerformValidations(false);

			// Build URL with queryString request parameters
			String uri = UriBuilder(remoteImageName, remoteFolder, readType);
			InputStream responseStream = null;
			// Send the request to aspose server
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(uri, this.auth.getAppKey(),
									this.auth.getAppSID()), "GET");
				}
			} else {
				responseStream = Utils.ProcessCommand(Utils.Sign(uri), "GET");
			}

			// Read the response
			String strJSON = Utils.StreamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			RecognitionResponse barcodeRecognitionResponse = gson.fromJson(
					strJSON, RecognitionResponse.class);

			return barcodeRecognitionResponse.getBarcodes();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Read barcode from URL
	// / </summary>
	// / <param name="url">A URL containing image e.g.
	// http://www.yourdomain.com/folder/images/code39.png </param>
	// / <param name="readType">type of barcode to be recognized</param>
	// / <returns>The response from aspose service</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead =
	// serverReader.Read("http://upload.wikimedia.org/wikipedia/commons/c/ce/WikiQRCode.png",
	// BarCodeReadType.AllSupportedTypes);
	// / Console.WriteLine("Read from URL.");
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> Read(String url, BarCodeReadType readType) {
		try {
			// Only validate the API keys
			PerformValidations(true);

			// Build URI for accessing com.aspose.barcode API
			String uri = UriBuilderForURLImage(url, readType);
			InputStream responseStream = null;
			// Send the request to aspose server
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(uri, this.auth.getAppKey(),
									this.auth.getAppSID()), "POST");
				}
			} else {
				responseStream = Utils.ProcessCommand(Utils.Sign(uri), "POST");
			}

			// Read the response
			String strJSON = Utils.StreamToString(responseStream);

			// Parse the json String to JObject

			// Parse and Deserializes the JSON to a object.
			RecognitionResponse barcodeRecognitionResponse = gson.fromJson(
					strJSON, RecognitionResponse.class);

			return barcodeRecognitionResponse.getBarcodes();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	private String UriBuilder(String remoteImage, String remoteFolder,
			BarCodeReadType readType) {
		// Initialize with server URI, text and type, which are must
		String uri = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/barcode/";
		// remoteImage is the name of image on aspose server
		if (remoteImage != null && remoteImage.trim().length() > 0)
			uri += remoteImage + "/";
		uri += "recognize?";

		// First parameter. Add barcode type to be recognized
		// If AllSupportedTypes is selected, set blank, otherwise, send the
		// ToString()
		if (readType == BarCodeReadType.AllSupportedTypes)
			uri += "type=";
		else
			uri += "type=" + readType.toString();

		// Add remote folder parameter
		if (remoteFolder != null && remoteFolder.trim().length() > 0)
			uri += "&format=" + remoteFolder;

		// Add folder parameter
		if (remoteFolder != null && remoteFolder.trim().length() > 0)
			uri += "&folder=" + remoteFolder;

		// return the URI
		return uri;
	}

	private void PerformValidations(boolean apikeysOnly) throws Exception {
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

				// If only API keys need to be validated, then no need to
				// proceed
				// further, so return
				if (apikeysOnly == true)
					return;

				// Throw exception if barcode value is empty
				if (_remoteImageName == null
						|| _remoteImageName.trim().length() == 0)
					throw new Exception("Image name is not specified.");
			}
		}
	}

	// / <summary>
	// / Build URI for the recognition of image from URL
	// / </summary>
	// / <param name="url">URL of the image</param>
	// / <param name="readType">barcode read type</param>
	// / <returns>URI of aspose URL image recognition</returns>
	private String UriBuilderForURLImage(String url, BarCodeReadType readType) {
		// Initialize with server URI, text and type, which are must
		String uri = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/barcode/";
		uri += "recognize?";

		// First parameter. Add barcode type to be recognized
		// If AllSupportedTypes is selected, set blank, otherwise, send the
		// ToString()
		if (readType == BarCodeReadType.AllSupportedTypes)
			uri += "type=";
		else
			uri += "type=" + readType.toString();

		// Add URL parameter
		if (url != null && url.trim().length() > 0)
			uri += "&url=" + url;

		// return the URI
		return uri;
	}

}