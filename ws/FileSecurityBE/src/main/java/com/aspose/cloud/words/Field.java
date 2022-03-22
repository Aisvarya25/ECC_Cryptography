package com.aspose.cloud.words;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Field {
	private AsposeAppNonStatic auth;
	public String Format;
	public String Alignment;
	public boolean IsTop;
	public boolean SetPageNumberOnFirstPage;

	public Field() {
	}

	public Field(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / insert page number filed into the document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="alignment"></param>
	// / <param name="format"></param>
	// / <param name="isTop"></param>
	// / <param name="SetPageNumberOnFirstPage"></param>

	public Boolean insertPageNumber(String FileName, String alignment,
			String format, Boolean isTop, Boolean SetPageNumberOnFirstPage) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/insertPageNumbers";

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
			Field field = new Field();
			field.Alignment = alignment;
			field.Format = format;
			field.IsTop = isTop;
			field.SetPageNumberOnFirstPage = SetPageNumberOnFirstPage;

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(field, Field.class);

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

		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Gets all merge filed names from document
	// / </summary>
	// / <param name="FileName"></param>
	public List<String> GetMailMergeFieldNames(String FileName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/mailMergeFieldNames";

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

			MergeFieldResponse Response = gson.fromJson(strJSON,
					MergeFieldResponse.class);

			// return document property
			return Response.getFieldNames().getNames();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}