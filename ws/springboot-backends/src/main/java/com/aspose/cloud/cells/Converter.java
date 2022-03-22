package com.aspose.cloud.cells;

import java.io.FileInputStream;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;

public class Converter {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter() {

	}

	public Converter(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName) {
		FileName = fileName;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName, String worksheetName) {
		FileName = fileName;
		WorkSheetName = worksheetName;

	}

	public Converter(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean AutoShapeToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");
			else if (WorkSheetName == "")
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/autoshapes/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean ChartToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");
			else if (WorkSheetName == "")
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/charts/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean OleObjectToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");
			else if (WorkSheetName == "")
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/oleobjects/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean PictureToImage(int index, String outputFileName,
			ImageFormat outputformat) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");
			else if (WorkSheetName == "")
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/pictures/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	// / <param name="saveLocation"></param>

	public boolean WorksheetToImage(String outputFileName,
			ImageFormat outputFormat) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");
			else if (WorkSheetName == "")
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "?format="
					+ outputFormat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean Save(String outputFileName, SaveFormat outputFormat) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "?format=" + outputFormat;

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
			boolean response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Convert PDF to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void ConvertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + outputFormat;

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

			InputStream stream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					stream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void ConvertLocalFile(InputStream inputStream, String outputPath,
			SaveFormat saveFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + saveFormat;

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
			// get response stream
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					inputStream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// / <summary>
	// /
	// / </summary>
	public String WorkSheetName;

	// / <summary>
	// / Workbook name
	// / </summary>
	public String FileName;

}