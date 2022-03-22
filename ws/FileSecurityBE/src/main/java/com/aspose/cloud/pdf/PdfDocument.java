package com.aspose.cloud.pdf;

public class PdfDocument {
	private LinkResponse[] _Links;
	public LinkResponse[] getLinks(){return _Links;}
	public void setLinks(LinkResponse[] Links){_Links=Links;}

	private DocumentPropertiesEnvelop _DocumentProperties;
	public DocumentPropertiesEnvelop getDocumentProperties(){return _DocumentProperties;}
	public void setDocumentProperties(DocumentPropertiesEnvelop DocumentProperties){_DocumentProperties=DocumentProperties;}

	private PagesEnvelop _Pages;
	public PagesEnvelop getPages(){return _Pages;}
	public void setPages(PagesEnvelop Pages){_Pages=Pages;}

}
