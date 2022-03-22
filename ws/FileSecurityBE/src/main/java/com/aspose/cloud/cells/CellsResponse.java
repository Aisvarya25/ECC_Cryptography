package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Cells resource
    /// </summary>
    public class CellsResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link ;
        private int CellCount ;               
        private List<LinkResponse> CellList ;
        private int MaxRow ;
        private int MaxColumn ;
        private Cell Cell ;
        private Style Style ;
        
        public LinkResponse getlink(){return link;}
        public int getCellCount(){return CellCount;}               
        public List<LinkResponse> getCellList(){return CellList;}
        public int getMaxRow(){return MaxRow;}
        public int getMaxColumn(){return MaxColumn;}
        public Cell getCell(){return Cell;}
        public Style getStyle(){return Style;}
        
        
    }