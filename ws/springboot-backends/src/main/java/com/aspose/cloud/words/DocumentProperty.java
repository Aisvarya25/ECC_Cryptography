package com.aspose.cloud.words;

    public class DocumentProperty 
    {
        public DocumentProperty() { }

        /// <summary>
        /// Resource BuiltIn Property
        /// </summary>
        private Boolean _BuiltIn;
        public Boolean getBuiltIn(){return _BuiltIn;}
        public void setBuiltIn(Boolean BuiltIn){_BuiltIn=BuiltIn;}
        /// <summary>
        /// Resource Name Property
        /// </summary>
        private String _Name;
        public String getName(){return _Name;}
        public void setName(String Name){_Name=Name;}

        /// <summary>
        /// Resource Value Property
        /// </summary>
        private String _Value;
        public String getValue(){return _Value;}
        public void setValue(String Value){_Value=Value;}


        /// <summary>
        /// Link Response related to document properties
        /// <link href="http://api.saaspose.com/v1.0/words/TestProperties.doc/documentProperties/Author" rel="self" />
        /// </summary>
        private LinkResponse _link;
        public LinkResponse getlink(){return _link;}
        public void setlink(LinkResponse link){_link=link;}


        public DocumentProperty(String propName, String propValue)
        {
            _Name = propName;
            _Value = propValue;
        }
    }