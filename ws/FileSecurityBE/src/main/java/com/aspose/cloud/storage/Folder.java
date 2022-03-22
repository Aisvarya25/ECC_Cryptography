/**
 * 
 */
package com.aspose.cloud.storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SignatureException;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
public class Folder {
	private AsposeAppNonStatic auth;
	private String strURIFolder = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/folder/";
	private String strURIFile = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/file/";
	private String strURIExist = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/exist/";
	private String strURIDisc = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/disc/";

	public Folder() {

	}

	public Folder(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / Retrives the list of files and folders under the specified folder. Use
	// empty string to specify root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	// / <returns></returns>
	public List<com.aspose.cloud.storage.File> GetFilesList(String strFolder) {
		try {
			// StreamReader reader = new StreamReader(Common.
			// Utils.ProcessCommand(CommonUtils.Sign(this.strURIFolder +
			// strFolder), "GET") );
			// further process JSON response
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {

					strJSON = Utils.StreamToString(Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolder,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.StreamToString(Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolder), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<com.aspose.cloud.storage.File> GetFilesList(String strFolder,
			StorageType storageType, String storageName) {
		try {
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strJSON = Utils.StreamToString(Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolder
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.StreamToString(Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolder + "?storage="
								+ storageName), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Deletes a file from the storage. Use "FolderName/FileName" to specify a
	// file under specific folder.
	// / </summary>
	// / <param name="strFileName"></param>
	public boolean DeleteFile(String strFileName) throws Exception {
		try {
			InputStream responseStream;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					responseStream = Utils
							.ProcessCommand(
									Utils.Sign(this.strURIFile + strFileName),
									"DELETE");
				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + strFileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + strFileName), "DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean DeleteFile(String strFileName, StorageType storageType,
			String storageName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {

					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + strFileName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + strFileName + "?storage="
								+ storageName), "DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Deletes an empty folder from the storage. Use
	// "FolderName/SubFolderName" for sub folders.
	// / </summary>
	// / <param name="strFolderName"></param>
	public boolean DeleteFolder(String strFolderName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIFolder, this.auth.getAppKey(),
							this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils
						.ProcessCommand(
								Utils.Sign(this.strURIFolder + strFolderName),
								"DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean DeleteFolder(String strFolderName, StorageType storageType,
			String storageName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolderName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}

			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolderName
								+ "?storage=" + storageName), "DELETE");
			}

			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Uploads a file from your local machine to specified folder / subfolder
	// on Aspose storage.
	// / </summary>
	// / <param name="strFile"></param>
	// / <param name="strFolder"></param>
	public boolean UploadFile(String strFile, String strFolder)
			throws Exception {
		try {
			File localFile = new File(strFile);
			String strRemoteFileName = localFile.getName();
			String strURIRequest = this.strURIFile
					+ (strFolder == "" ? "" : strFolder + "/")
					+ strRemoteFileName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			String strResponse = Utils.UploadFileBinary(localFile,
					strURISigned, "PUT");

			if (strResponse.contains("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	public boolean UploadFile(String strFile, String strFolder,
			StorageType storageType, String storageName) throws Exception {
		try {
			File localFile = new File(strFile);
			String strRemoteFileName = localFile.getName();
			String strURIRequest = this.strURIFile
					+ (strFolder == "" ? "" : strFolder + "/")
					+ strRemoteFileName;
			strURIRequest += "?storage=" + storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			String strResponse = Utils.UploadFileBinary(localFile,
					strURISigned, "PUT");

			if (strResponse.contains("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	// / <summary>
	// / Creates a folder under the specified folder. If no path specified,
	// creates a folder under the root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	public boolean CreateFolder(String strFolder) throws Exception {
		try {
			String strURIRequest = this.strURIFolder + strFolder;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			Utils.ProcessCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean CreateFolder(String strFolder, StorageType storageType,
			String storageName) throws Exception {
		try {
			String strURIRequest = this.strURIFolder + strFolder + "?storage="
					+ storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			Utils.ProcessCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Checks whether file or folder exists on the Aspose storage.
	// / </summary>
	// / <param name="strFolderOrFile"></param>
	// / <returns></returns>
	public com.aspose.cloud.storage.FileExist FileExist(String strFolderOrFile) {
		try {
			String strURIRequest = this.strURIExist + strFolderOrFile;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public com.aspose.cloud.storage.FileExist FileExist(String strFolderOrFile,
			StorageType storageType, String storageName) {
		try {
			String strURIRequest = this.strURIExist + strFolderOrFile
					+ "?storage=" + storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Provides the total / free disc size in bytes for your app.
	// / </summary>
	// / <returns></returns>
	public DiscUsage GetDiscUsage() {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIDisc, this.auth.getAppKey(),
							this.auth.getAppSID()), "GET");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIDisc), "GET");
			}

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public DiscUsage GetDiscUsage(StorageType storageType, String storageName) {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIDisc + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				responseStream = Utils
						.ProcessCommand(
								Utils.Sign(this.strURIDisc + "?storage="
										+ storageName), "GET");
			}

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Get file from Aspose server
	// / </summary>
	// / <param name="fileName">file name on the server</param>
	// / <returns></returns>
	public InputStream GetFile(String fileName) throws SignatureException {
		try {
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					return null;
				} else {
					return Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + fileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET");
				}
			} else {
				return Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + fileName), "GET");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public InputStream GetFile(String fileName, StorageType storageType,
			String storageName) throws SignatureException {
		try {
			if (this.auth != null) {

				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					return null;
				} else {
					return Utils.ProcessCommand(Utils.Sign(this.strURIFile
							+ fileName + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				return Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + fileName + "?storage="
								+ storageName), "GET");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Get file output file name and input stream as arguments and saves file
	// on disk
	// / </summary>

	// / <returns></returns>

	public static boolean SaveStreamToFile(String FileNameWithPath,
			InputStream inputStream) {

		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(FileNameWithPath));

			int read = 0;
			byte[] bytes = new byte[8192];

			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			inputStream.close();
			out.flush();
			out.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
