/**
 * 
 */
package com.aspose.cloud.storage;
import java.util.List;

import com.google.gson.Gson;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents collection of File objects
/// </summary>
public class FileCollection {

    private FileCollection() { }
    /// <summary>
    /// Represents a list fo File Objects.
    /// </summary>
    private FileCollection _File;
    public FileCollection getFile(){return _File;}
    public void setFile(FileCollection File){_File=File;}
/// <summary>
    /// returns a list of File objects
    /// </summary>
    
    
    public static List<com.aspose.cloud.storage.File> getFilesList(String strJSON)
    {
        try
        {
        //	strJSON=strJSON.replaceFirst("1327228690298-0600", "1327228690298+0600");
        	Gson gson =GsonDateParser.createWcfGson();
            FolderResponse folderResponse = gson.fromJson(strJSON,FolderResponse.class);;
            //	files = folderResponse.Files;
            List<com.aspose.cloud.storage.File> files =folderResponse.getFiles();

            return files;

        }
        catch (Exception ex)
        {
           ex.printStackTrace();
           return null;
        }
	
    }
}
