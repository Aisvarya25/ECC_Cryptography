package com.aspose.cloud.words;
import java.util.List;

    public class DocumentPropertiesResponse
    {
        public DocumentPropertiesResponse() { }

        /// <summary>
        /// Link Response related to document properties
        /// <link href="http://api.saaspose.com/v1.0/words/TestProperties.doc/documentProperties/Author" rel="self" />
        /// </summary>
        private LinkResponse _link ;
        private List<DocumentProperty> _List;
        
        public LinkResponse getlink(){return _link;} 
        public List<DocumentProperty> getList(){return _List;}
        
        public void setlink (LinkResponse link){_link=link;}
        public void setList(List<DocumentProperty> List){_List=List;}
    }