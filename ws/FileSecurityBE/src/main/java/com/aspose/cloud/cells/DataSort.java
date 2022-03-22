package com.aspose.cloud.cells;
import java.util.List;

public class DataSort
    {
        public DataSort()
        { 
        
        }

        private boolean CaseSensitive ;
        private boolean HasHeaders ;
        private boolean SortLeftToRight ;
        private List <SortKey> KeyList ;
        
        
        public boolean getCaseSensitive(){return CaseSensitive;}
        public boolean getHasHeaders(){return HasHeaders;}
        public boolean getSortLeftToRight(){return SortLeftToRight;}
        public List <SortKey> getKeyList(){return KeyList;}

		public void setCaseSensitive(boolean CaseSensitive) { this.CaseSensitive = CaseSensitive; }
		public void setHasHeaders(boolean HasHeaders) { this.HasHeaders = HasHeaders; }
		public void setSortLeftToRight(boolean SortLeftToRight) { this.SortLeftToRight = SortLeftToRight; }
		public void setKeyList(List<SortKey> KeyList) { this.KeyList = KeyList; }
    }