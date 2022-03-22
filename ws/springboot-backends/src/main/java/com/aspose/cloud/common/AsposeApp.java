package com.aspose.cloud.common;


import java.lang.String;
/**
 * @author Mudassir
 *
 */
public class AsposeApp {
    /// <summary>
    /// Represents AppSID for the app.
    /// </summary>
    private static String AppSID;
    /// <summary>
    /// Represnts the AppKey for the app.
    /// </summary>
    private static String AppKey;
    
    public static String getAppSID(){return AppSID;}
    public static String getAppKey(){return AppKey;}
    public static void setAppSID(String appSID){ AppSID=appSID;}
    public static void setAppKey(String appKey){ AppKey=appKey;}
    public static void setAppInfo(String appKey, String appSID)
    {
    	AppSID=appSID;
    	AppKey=appKey;
    }

}
