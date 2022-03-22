package com.aspose.cloud.words;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;
import com.google.gson.Gson;

public class Extractor {
	private AsposeAppNonStatic auth;

	public Extractor() {
	}

	public Extractor(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	public List<Paragraph> GetText(String FileName) {
		try {
			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
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

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			DocumentTextResponse docResponse = gson.fromJson(strJSON,
					DocumentTextResponse.class);

			return docResponse.getTextItems().getList();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Gets all Drawing Objects from document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="outputPath"></param>
	// / <returns></returns>
	public void GetDrawingObjects(String FileName, String outputPath) {

		try {
			// build URI to get Drawing Objects
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/drawingObjects";
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

			DrawingObjectsResponse Response = gson.fromJson(strJSON,
					DrawingObjectsResponse.class);

			for (com.aspose.cloud.words.List list : Response.getDrawingObjects().getList()) {
				GetDrawingObject(list.getlink().getHref(), outputPath);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// / <summary>
	// / Get the drawing object from document
	// / </summary>
	// / <param name="strURI"></param>
	// / <param name="outputPath">C:\Output.jpg</param>
	public boolean GetDrawingObject(String strURI, String outputPath) {

		try {
			// build URI to get Drawing Objects
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

			DrawingObjectsResponse Response = gson.fromJson(strJSON,
					DrawingObjectsResponse.class);

			String index = Response.getDrawingObject().getlink().getHref().substring(
					Response.getDrawingObject().getlink().getHref().lastIndexOf("/") + 1)
					.toString();

			if (Response.getDrawingObject().getImageDataLink() != null
					&& Response.getDrawingObject().getOleDataLink() == null) {
				// build URI to get Image
				strURI = strURI + "/imageData";// ?format=" +
												// DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject_" + index + "."
						+ DrawingObjectsRenderFormat.jpeg;
			} else if (Response.getDrawingObject().getOleDataLink() != null) {
				// build URI to get OLE
				strURI = strURI + "/oleData";// format=" +
												// DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject__" + index + ".xlsx"; // This
																					// needs
																					// to
																					// be
																					// discuss
			} else {
				// build URI to get Image
				strURI = strURI + "?format=" + DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject__" + index + "."
						+ DrawingObjectsRenderFormat.jpeg;
			}

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

			responseStream = Utils.ProcessCommand(signedURI, "GET");
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * /// <summary> /// Get the List of drawing object from document ///
	 * </summary> /// <param name="FileName"></param> public Dictionary<int,
	 * String> GetDrawingObjectList(String FileName) {
	 * 
	 * try { //build URI to get Drawing Objects String strURI =
	 * Product.getBaseProductUri() + "/words/" + FileName + "/drawingObjects";
	 * 
	 * String signedURI = Utils.Sign(strURI);
	 * 
	 * Stream responseStream = Utils.ProcessCommand(signedURI, "GET");
	 * 
	 * StreamReader reader = new StreamReader(responseStream); String strJSON =
	 * reader.ReadToEnd();
	 * 
	 * //Parse the json String to JObject JObject parsedJSON =
	 * JObject.Parse(strJSON);
	 * 
	 * //Deserializes the JSON to a object. DrawingObjectsResponse Response =
	 * JsonConvert
	 * .DeserializeObject<DrawingObjectsResponse>(parsedJSON.ToString());
	 * 
	 * int index = 0; Dictionary<int, String> dObject = new Dictionary<int,
	 * String>();
	 * 
	 * foreach (Saaspose.Words.List list in Response.DrawingObjects.List) {
	 * responseStream = Utils.ProcessCommand(Utils.Sign(list.link.Href), "GET");
	 * reader = new StreamReader(responseStream); strJSON = reader.ReadToEnd();
	 * parsedJSON = JObject.Parse(strJSON);
	 * 
	 * //Deserializes the JSON to a object. Response =
	 * JsonConvert.DeserializeObject
	 * <DrawingObjectsResponse>(parsedJSON.ToString());
	 * 
	 * if (Response.DrawingObject.ImageDataLink != null &&
	 * Response.DrawingObject.OleDataLink == null) { dObject.Add(index,
	 * Response.DrawingObject.ImageDataLink.Href); index++; } else if
	 * (Response.DrawingObject.OleDataLink != null) { dObject.Add(index,
	 * Response.DrawingObject.OleDataLink.Href); index++; } else {
	 * dObject.Add(index, Response.DrawingObject.RenderLinks[0].Href); index++;
	 * } }
	 * 
	 * responseStream.Close(); return dObject; } catch (Exception ex) { return
	 * null; } }
	 */
	// / <summary>
	// / Get the OLE drawing object from document
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean GetoleData(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {

		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/drawingObjects/" + index + "/oleData";

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
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Get the Image drawing object from document
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean GetimageData(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/drawingObjects/" + index + "/ImageData";

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
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Convert drawing object to image
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean ConvertDrawingObject(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/drawingObjects/" + index;
			strURI = strURI + "?format=" + renderformat.toString();
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
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}