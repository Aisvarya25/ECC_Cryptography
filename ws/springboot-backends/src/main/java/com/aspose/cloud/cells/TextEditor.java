package com.aspose.cloud.cells;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class TextEditor {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / TextEditor Class Constructor
	// / </summary>
	public TextEditor(String fileName) {
		FileName = fileName;
		gson = new Gson();

	}

	public TextEditor(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	public List<TextItem> FindText(String text) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/findText?text=" + text;

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getTextItems().getTextItemList();

	}

	public int ReplaceText(String oldText, String newText) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/replaceText?oldValue=" + oldText + "&newValue=" + newText;

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getMatches();

	}

	public List<TextItem> GetTextItems() throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/textItems";

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
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getTextItems().getTextItemList();

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="text"></param>
	// / <returns></returns>
	public List<TextItem> FindText(String WorkSheetName, String text)
			throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + WorkSheetName + "/findText?text=" + text;

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getTextItems().getTextItemList();

	}

	public int ReplaceText(String workSheet, String oldText, String newText)
			throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName;
		strURI += "/worksheets/" + workSheet + "/replaceText?oldValue="
				+ oldText + "&newValue=" + newText;

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

		// further process JSON response
		String strJSON = Utils.StreamToString(responseStream);

		// Deserializes the JSON to a object.
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getMatches();

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public List<TextItem> GetTextItems(String WorkSheetName) throws Exception {
		// check whether file is set or not
		if (FileName == "")
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + FileName + "/textItems";

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
		TextEditorResponse textEditorResponse = gson.fromJson(strJSON,
				TextEditorResponse.class);

		return textEditorResponse.getTextItems().getTextItemList();

	}

	Gson gson = null;

	public String FileName;
}