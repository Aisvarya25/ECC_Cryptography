package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Column resource
    /// </summary>
    public class ColumnsResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link ;
        private int MaxColumn ;
        private List<LinkResponse> ColumnsList ;
        private Column Column ;
        
        public LinkResponse getlink(){return link;}
        public int getMaxColumn(){return MaxColumn;}
        public List<LinkResponse> getColumnsList(){return ColumnsList;}
        public Column getColumn(){return Column;}
       
    }