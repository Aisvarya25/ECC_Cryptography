package com.aspose.cloud.words;

import com.aspose.cloud.common.AsposeApp;
import com.aspose.cloud.common.Product;

    /// <summary>
    /// Performs any validation related tasks
    /// </summary>
    public class Validator
    {
        public Validator(String fileName)
        {
            //set default values
            FileName = fileName;
        }

        /// <summary>
        /// get or set file name
        /// </summary>
        public String FileName ;


        /// <summary>
        /// Performs input validation on the client end or local server
        /// </summary>
        public static void LocalValidation()
        {
            try
            {
                // Throws exception if product server is not specified
                if (Product.getBaseProductUri() + "/words/" == null || (Product.getBaseProductUri() + "/words/").length() == 0)
                    throw new Exception("App Server is not specified. Please set Server property.");

                // Throw exception if App Key is empty
                if (AsposeApp.getAppKey() == null || AsposeApp.getAppKey().length() == 0)
                    throw new Exception("App Key is not specified. Please set the App Key property.");

                // Throw exception if App SID is empty
                if (AsposeApp.getAppSID() == null || AsposeApp.getAppSID().length() == 0)
                    throw new Exception("App SID is not specified. Please set App SID property.");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
       
       /* public Boolean validateFile()
        {

            if (Path.GetExtension(FileName).ToLower() == "." +  SaveFormat.Doc.ToString().ToLower() || Path.GetExtension(FileName).ToLower() == "." + SaveFormat.Docx.ToString().ToLower())
                return true;
            else
                return false;
        }*/
    }