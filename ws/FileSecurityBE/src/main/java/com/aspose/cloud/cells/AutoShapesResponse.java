package com.aspose.cloud.cells;


import java.util.List;

    /// <summary>
    /// Represents response from the Autoshape resource
    /// </summary>
    public class AutoShapesResponse extends com.aspose.cloud.common.BaseResponse
    {
       
        private LinkResponse link ;
                
        private List<LinkResponse> AuotShapeList ;

        private AutoShape AutoShape ;
        
        
        public LinkResponse getlink(){return link;}
        
        public List<LinkResponse> getAuotShapeList(){return AuotShapeList;}
        
        public AutoShape getAutoShape(){return AutoShape;}
    }