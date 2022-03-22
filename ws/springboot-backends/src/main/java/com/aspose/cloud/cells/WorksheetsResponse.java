package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the worksheets resource
    /// </summary>
    public class WorksheetsResponse extends com.aspose.cloud.common.BaseResponse
    {

        private List<Worksheet> WorksheetList;
        private LinkResponse Link ;
        
        public List<Worksheet> getWorksheetList(){return WorksheetList;}
        public LinkResponse getLink(){return Link;}

    }