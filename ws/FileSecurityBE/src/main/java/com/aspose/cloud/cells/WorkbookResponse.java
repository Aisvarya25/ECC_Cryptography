package com.aspose.cloud.cells;

public class WorkbookResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private DocumentPropertiesResponse DocumentProperties;
        private WorksheetsResponse Worksheets;
        private NamesResponse Names;
        private TextItemsResponse TextItems;
        private DocumentProperty DocumentProperty;
        private Workbook Workbook;
        private Worksheet Worksheet;
        private Name Name;
        private TextItem TextItem;
        private Style Style;
        
        
        public DocumentPropertiesResponse getDocumentProperties(){return DocumentProperties;}
        public WorksheetsResponse getWorksheets(){return Worksheets;}
        public NamesResponse getNames(){return Names;}
        public TextItemsResponse getTextItems(){return TextItems;}
        public DocumentProperty getDocumentProperty(){return DocumentProperty;}
        public Workbook getWorkbook(){return Workbook;}
        public Worksheet getWorksheet(){return Worksheet;}
        public Name getName(){return Name;}
        public TextItem getTextItem(){return TextItem;}
        public Style getStyle(){return Style;}
    }