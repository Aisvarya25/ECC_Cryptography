package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Pictures resource
    /// </summary>
    public class PicturesResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link;
        private List<LinkResponse> PictureList;
        private Picture Picture;
        
        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getPictureList(){return PictureList;}
        public Picture getPicture(){return Picture;}

    }