package com.aspose.cloud.cells;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Worksheet {
	private AsposeAppNonStatic auth;

	public Worksheet(String fileName, String worksheetName) {
		FileName = fileName;
		WorkSheetName = worksheetName;
	}

	public Worksheet(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	public LinkResponse Link;

	public List<LinkResponse> GetCellsList(int offset, int count) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<LinkResponse> GetRowsList(int offset, int count) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/rows?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowsList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<LinkResponse> GetColumnsList(int offset, int count) {
		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/columns?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getColumns().getColumnsList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int GetMaxColumn(int offset, int count) {
		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxColumn();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int GetMaxRow(int offset, int count) {
		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxRow();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int GetCellsCount(int offset, int count) {
		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetAutoShapesCount() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/autoshapes";

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getAutoShapes().getAuotShapeList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public AutoShape GetAutoShapeByIndex(int index) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/autoshapes/" + index;

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

			AutoShapesResponse autoShapesResponse = gson.fromJson(strJSON,
					AutoShapesResponse.class);

			return autoShapesResponse.getAutoShape();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	/***********Method  ProtectWorksheet Added by:Zeeshan*******/
	public Boolean ProtectWorksheet(String password, WorksheetProtectionType type, ProtectionOptions opts)
	{
		try
		{
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName ;
			strURI +=  "/worksheets/" +WorkSheetName + "/protection";

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
			Gson gson = new Gson();

			//serialize the JSON request content
			WorksheetProtectionRequest protectionRequest = new WorksheetProtectionRequest();
            protectionRequest.setAllowDeletingColumn ( opts.getAllowDeletingColumn());
            protectionRequest.setAllowDeletingRow ( opts.getAllowDeletingRow());
            protectionRequest.setAllowEditArea ( opts.getAllowEditArea());
            protectionRequest.setAllowFiltering ( opts.getAllowFiltering());
            protectionRequest.setAllowFormattingCell ( opts.getAllowFormattingCell());
            protectionRequest.setAllowFormattingColumn ( opts.getAllowFormattingColumn());
            protectionRequest.setAllowFormattingRow ( opts.getAllowFormattingRow());
            protectionRequest.setAllowInsertingColumn ( opts.getAllowInsertingColumn());
            protectionRequest.setAllowInsertingHyperlink ( opts.getAllowInsertingHyperlink());
            protectionRequest.setAllowInsertingRow ( opts.getAllowInsertingRow());
            protectionRequest.setAllowSelectingLockedCell ( opts.getAllowSelectingLockedCell());
            protectionRequest.setAllowSelectingUnlockedCell ( opts.getAllowSelectingUnlockedCell());
            protectionRequest.setAllowSorting ( opts.getAllowSorting());
            protectionRequest.setAllowUsingPivotTable ( opts.getAllowUsingPivotTable());
            protectionRequest.setPassword ( password);
            protectionRequest.setProtectionType ( type.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, WorksheetProtectionRequest.class);
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}




	}


	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Cell GetCell(String cellName) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/" + cellName;

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

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getCell();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Style GetCellStyle(String cellName) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/" + cellName
					+ "/style";

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

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getStyle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <param name="style"></param>
	// / <returns></returns>
	public boolean SetCellStyle(String cellName, Style style) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/" + cellName
					+ "/style";

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

			strJSON = gson.toJson(style, Style.class);

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

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Chart GetChartByIndex(int index) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/charts/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			ChartsResponse chartsResponse = gson.fromJson(strResponse,
					ChartsResponse.class);

			return chartsResponse.getChart();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Hyperlink GetHyperlinkByIndex(int index) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/hyperlinks/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			HyperlinksResponse hyperlinksResponse = gson.fromJson(strResponse,
					HyperlinksResponse.class);

			return hyperlinksResponse.getHyperlink();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Comment GetComment(String cellName) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/comments/" + cellName;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);
			// Deserializes the JSON to a object.
			CommentsResponse commentResponse = gson.fromJson(strResponse,
					CommentsResponse.class);

			return commentResponse.getComment();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public OleObject GetOleObjectByIndex(int index) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/oleobjects/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			OleObjectsResponse oleObjectsResponse = gson.fromJson(strResponse,
					OleObjectsResponse.class);

			return oleObjectsResponse.getOleObject();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Picture GetPictureByIndex(int index) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/pictures/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			PicturesResponse picturesResponse = gson.fromJson(strResponse,
					PicturesResponse.class);

			return picturesResponse.getPicture();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean AddPicture(String picturePath, PictureLocation location,
			int upperLeftRow, int upperLeftColumn, int lowerRightRow,
			int lowerRightColumn) {
		try {
			if (this.FileName.equals("")) {
				throw new Exception("File Name Not Specified");
			}
			if (this.WorkSheetName.equals("")) {
				throw new Exception("Worksheet Name Not Specified");
			}
			InputStream response = null;
			if (location.equals(PictureLocation.Server)) {
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
						+ "/cells/" + this.FileName;
				strURI += "/worksheets/" + this.WorkSheetName
						+ "/pictures?upperLeftRow=" + upperLeftRow
						+ "&upperLeftColumn=" + upperLeftColumn
						+ "&lowerRightRow=" + lowerRightRow
						+ "&lowerRightColumn=" + lowerRightColumn
						+ "&picturePath=" + picturePath;
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
				response = Utils.ProcessCommand(signedURI, "PUT");
			} else {
				InputStream fileStream = new FileInputStream(new File(
						picturePath));
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
						+ "/cells/" + FileName;
				strURI += "/worksheets/" + WorkSheetName
						+ "/pictures?upperLeftRow=" + upperLeftRow
						+ "&upperLeftColumn=" + upperLeftColumn
						+ "&lowerRightRow=" + lowerRightRow
						+ "&lowerRightColumn=" + lowerRightColumn;
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
				response = Utils.ProcessCommand(signedURI, "PUT", fileStream);
			}
			Gson gson = new Gson();
			String responseString = Utils.StreamToString(response);
			BaseResponse finalResponse = gson.fromJson(responseString,
					BaseResponse.class);
			if (finalResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Validation GetValidationByIndex(int index) {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/validations/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			ValidationsResponse validationsResponse = gson.fromJson(
					strResponse, ValidationsResponse.class);

			return validationsResponse.getValidation();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public MergedCell GetMergedCellByIndex(int index) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/mergedCells/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			MergedCellsResponse mergedCellsResponse = gson.fromJson(
					strResponse, MergedCellsResponse.class);

			return mergedCellsResponse.getMergedCell();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetMergedCellsCount() {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/mergedCells";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getMergedCells().getCount();

		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetValidationsCount() {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/validations";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getValidations().getCount();

		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetPicturesCount() {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/pictures";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getPictures().getPictureList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetOleObjectsCount() {
		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/oleobjects";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getOleObjects().getOleOjectList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetChartsCount() {
		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/charts";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getCharts().getChartList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetCommentsCount() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/comments";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getComments().getCommentList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int GetHyperlinksCount() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/hyperlinks";

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getHyperlinks().getCount();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean HideWorksheet() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName
					+ "/visible?isVisible=false";

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

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean UnhideWorksheet() {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName
					+ "/visible?isVisible=true";

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

	public boolean MoveWorksheet(String worksheetName, Position position) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName
					+ "/worksheets/" + WorkSheetName + "/position";
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
			MoveWorksheet moveWorksheet = new MoveWorksheet();
			moveWorksheet.setDestinationWorksheet(worksheetName);
			moveWorksheet.setPosition(position);

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

	// / <summary>
	// /
	// / </summary>
	// / <param name="formula"></param>
	// / <returns></returns>
	public String CalculateFormula(String formula) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName
					+ "/formulaResult?formula=" + formula;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			CalculateFormulaResponse formulaResponse = gson.fromJson(
					strResponse, CalculateFormulaResponse.class);

			return formulaResponse.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean SetCellValue(String cellName, String valueType, String value) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/cells/" + cellName
					+ "?value=" + value + "&type=" + valueType;

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
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int GetRowsCount(int offset, int count) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/rows?offset=" + offset
					+ "&count=" + count;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowCount();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Row GetRow(int rowIndex) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/rows/" + rowIndex;

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

			Gson gson = new Gson();

			String strResponse = Utils.StreamToString(responseStream);

			// Deserializes the JSON to a object.
			RowsResponse rowsResponse = gson.fromJson(strResponse,
					RowsResponse.class);

			return rowsResponse.getRow();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public boolean AddRow(int rowIndex) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
            strURI += "/worksheets/" + WorkSheetName + "/cells/rows/" + rowIndex;

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

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean EditRow(int rowIndex, int height) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+  "/cells/" + FileName;
	                strURI += "/worksheets/" + WorkSheetName + "/cells/rows/" + rowIndex + "?Height=" + height;

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
	public boolean DeleteRow(int rowIndex) {

		try {

			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/rows/" + rowIndex;

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

	public boolean SortData(DataSort dataSort, String cellArea) {
		try {
			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/sort?cellArea="
					+ cellArea;

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

			strJSON = gson.toJson(dataSort, DataSort.class);

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

	public Column GetColumn(int columnIndex) {

		try {
			// check whether file is set or not
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/columns/"
					+ columnIndex;

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

			// Deserializes the JSON to a object.
			ColumnsResponse columnsResponse = gson.fromJson(strJSON,
					ColumnsResponse.class);

			return columnsResponse.getColumn();
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private String WorkSheetName;
	private String FileName;
	private boolean IsVisible;
	private boolean IsSelected;
	private boolean IsGridLinesVisible;
	private boolean IsProtected;
	private int Index;
	private String Name;

	public String getWorkSheetName() {
		return WorkSheetName;
	}

	public String getFileName() {
		return FileName;
	}

	public boolean getIsVisible() {
		return IsVisible;
	}

	public boolean getIsSelected() {
		return IsSelected;
	}

	public boolean getIsGridLinesVisible() {
		return IsGridLinesVisible;
	}

	public boolean getIsProtected() {
		return IsProtected;
	}

	public int getIndex() {
		return Index;
	}

	public String getName() {
		return Name;
	}
	
	public Boolean UnProtectWorksheet(String password, WorksheetProtectionType type, ProtectionOptions opts)
	{
		try
		{
			if (FileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName ;
			strURI +=  "/worksheets/" +WorkSheetName + "/protection";

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
			Gson gson = new Gson();

			//serialize the JSON request content
			WorksheetProtectionRequest protectionRequest = new WorksheetProtectionRequest();
            protectionRequest.setAllowDeletingColumn ( opts.getAllowDeletingColumn());
            protectionRequest.setAllowDeletingRow ( opts.getAllowDeletingRow());
            protectionRequest.setAllowEditArea ( opts.getAllowEditArea());
            protectionRequest.setAllowFiltering ( opts.getAllowFiltering());
            protectionRequest.setAllowFormattingCell ( opts.getAllowFormattingCell());
            protectionRequest.setAllowFormattingColumn ( opts.getAllowFormattingColumn());
            protectionRequest.setAllowFormattingRow ( opts.getAllowFormattingRow());
            protectionRequest.setAllowInsertingColumn ( opts.getAllowInsertingColumn());
            protectionRequest.setAllowInsertingHyperlink ( opts.getAllowInsertingHyperlink());
            protectionRequest.setAllowInsertingRow ( opts.getAllowInsertingRow());
            protectionRequest.setAllowSelectingLockedCell ( opts.getAllowSelectingLockedCell());
            protectionRequest.setAllowSelectingUnlockedCell ( opts.getAllowSelectingUnlockedCell());
            protectionRequest.setAllowSorting ( opts.getAllowSorting());
            protectionRequest.setAllowUsingPivotTable ( opts.getAllowUsingPivotTable());
            protectionRequest.setPassword ( password);
            protectionRequest.setProtectionType ( type.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, WorksheetProtectionRequest.class);
			InputStream responseStream = Utils.ProcessCommand(signedURI, "DELETE",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}




	}


}
