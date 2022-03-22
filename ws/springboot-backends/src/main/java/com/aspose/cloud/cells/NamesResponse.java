package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Names resource
    /// </summary>
    public class NamesResponse extends com.aspose.cloud.common.BaseResponse
    {
       
        private LinkResponse link;
        private int Count;
        private List<Name> NameList;
        
        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}
        public List<Name> getNameList(){return NameList;}
    }