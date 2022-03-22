package com.aspose.cloud.words;
import java.util.List;


    public class DocumentTextItemsResponse 
    {
        public DocumentTextItemsResponse() { }

        /// <summary>
        /// Link Response related to document text
        /// <link href="http://api.saaspose.com/v1.0/words/TestTextItems.doc/textItems" rel="self" />
        /// </summary>
        private LinkResponse _link;
        public LinkResponse getlink(){return _link;}
        public void setlink(LinkResponse link){_link=link;}


        /// <summary>
        /// TextItem of document
        /// </summary>
        private List<Paragraph> _List;
        public List<Paragraph> getList(){return _List;}
        public void setList(List<Paragraph> List){_List=List;}


    }