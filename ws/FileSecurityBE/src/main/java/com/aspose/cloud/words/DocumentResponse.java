package com.aspose.cloud.words;

    public class DocumentResponse extends com.aspose.cloud.common.BaseResponse
    {
        /// <summary>
        /// Document Properties response
        /// </summary>
    	private DocumentPropertiesResponse _DocumentProperties;
    	public DocumentPropertiesResponse getDocumentProperties(){return _DocumentProperties;}
    	public void setDocumentProperties(DocumentPropertiesResponse DocumentProperties){_DocumentProperties=DocumentProperties;}


        /// <summary>
        /// Document Property response
        /// </summary>
    	private DocumentProperty _DocumentProperty;
    	public DocumentProperty getDocumentProperty(){return _DocumentProperty;}
    	public void setDocumentProperty(DocumentProperty DocumentProperty){_DocumentProperty=DocumentProperty;}

    }