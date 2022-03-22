package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the OleObjects resource
    /// </summary>
    public class OleObjectsResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> OleOjectList ;
        private OleObject OleObject ;

        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getOleOjectList(){return OleOjectList;}
        public OleObject getOleObject(){return OleObject;}
    }