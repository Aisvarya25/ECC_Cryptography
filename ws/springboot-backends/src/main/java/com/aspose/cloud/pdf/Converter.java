/**
 * 
 */
package com.aspose.cloud.pdf;

import com.aspose.cloud.common.*;
import com.aspose.cloud.pdf.SaveFormat;
import com.aspose.cloud.storage.Folder;

import java.lang.String;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / converts pages or document into different formats
// / </summary>
public class Converter {
	private AsposeAppNonStatic auth;

	public Converter(String fileName) {
		FileName = fileName;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String FileName;

	// / <summary>
	// / convert a particular page to image
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean GetImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation,
			int imageHeight, int imageWidth) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber);
			strURI += "?format=" + imageFormat.toString();
			strURI += "&width=" + Integer.toString(imageWidth);
			strURI += "&height=" + Integer.toString(imageHeight);

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
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / convert a particular page to image with default size
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean GetImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber);
			strURI += "?format=" + imageFormat.toString();

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
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / save the document into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="saveFormat"></param>
	public boolean Convert(String outputPath, SaveFormat saveFormat) {

		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName;
			strURI += "?format=" + saveFormat.toString();

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
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Convert Document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void ConvertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/pdf/convert?format=" + outputFormat;

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

			InputStream fileStream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					fileStream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// / <summary>
	// / Convert document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public InputStream ConvertLocalFile(InputStream inputStream,
			SaveFormat outputFormat) {
		try {
			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/pdf/convert?format=" + outputFormat;

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

			return Utils.ProcessCommand(signedURI, "PUT", inputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
