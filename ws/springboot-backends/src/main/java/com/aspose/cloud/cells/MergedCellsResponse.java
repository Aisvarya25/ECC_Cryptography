package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the MergedCells resource
    /// </summary>
    public class MergedCellsResponse extends com.aspose.cloud.common.BaseResponse
    {      
        private LinkResponse link ;
        private int Count ;
        private List<LinkResponse> MergedCellList ;
        private MergedCell MergedCell ;
        
        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}
        public List<LinkResponse> getMergedCellList(){return MergedCellList;}
        public MergedCell getMergedCell(){return MergedCell;}

    }