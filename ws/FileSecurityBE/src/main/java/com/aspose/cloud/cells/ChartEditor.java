package com.aspose.cloud.cells;

import java.lang.String;
import java.io.InputStream;

import com.aspose.cloud.common.*;
import com.google.gson.*;

public class ChartEditor {
	// / <summary>
	// / ChartEditor Class Constructor
	// / </summary>
	private AsposeAppNonStatic auth;

	public ChartEditor(String fileName, String worksheetName) {
		FileName = fileName;
		WorkSheetName = worksheetName;
		gson = new Gson();

	}

	public ChartEditor(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	public boolean AddChart(ChartType chartType, int upperLeftRow,
			int upperLeftColumn, int lowerRightRow, int lowerRightColumn)
			throws Exception {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/charts?chartType="
					+ chartType + "&upperLeftRow=" + upperLeftRow
					+ "&upperLeftColumn=" + upperLeftColumn + "&lowerRightRow="
					+ lowerRightRow + "&lowerRightColumn=" + lowerRightColumn;

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

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	public boolean DeleteChart(int chartIndex) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + WorkSheetName + "/charts/" + chartIndex;

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

		InputStream responseStream = Utils.ProcessCommand(signedURI, "DELETE");

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		BaseResponse baseResponse = gson.fromJson(strJSON, BaseResponse.class);

		if (baseResponse.getStatus().equals("OK"))
			return true;
		else
			return false;
	}

	public ChartArea GetChartArea(int chartIndex) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + WorkSheetName + "/charts/" + chartIndex
				+ "/chartArea";

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getChartArea();
	}

	public FillFormat GetFillFormat(int chartIndex) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + WorkSheetName + "/charts/" + chartIndex
				+ "/chartArea/fillFormat";

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getFillFormat();
	}

	public Line GetBorder(int chartIndex) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + WorkSheetName + "/charts/" + chartIndex
				+ "/chartArea/border";

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getLine();

	}

	// / <summary>
	// /
	// / </summary>
	public String FileName;

	// / <summary>
	// /
	// / </summary>
	public String WorkSheetName;

	Gson gson = null;
}