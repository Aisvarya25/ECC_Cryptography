package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Hyperlinks resource
    /// </summary>
    public class HyperlinksResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link;
        private int Count;               
        private List<LinkResponse> HyperlinkList;
        private Hyperlink Hyperlink;

        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}               
        public List<LinkResponse> getHyperlinkList(){return HyperlinkList;}  
        public Hyperlink getHyperlink(){return Hyperlink;} 
      
    }