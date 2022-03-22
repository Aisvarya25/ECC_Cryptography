package com.aspose.cloud.cells;

import java.util.List;

public class ProtectionOptions
{
	private boolean _AllowDeletingColumn;
	public boolean getAllowDeletingColumn(){return _AllowDeletingColumn;}
	public void setAllowDeletingColumn(boolean AllowDeletingColumn){_AllowDeletingColumn=AllowDeletingColumn;}

	private boolean _AllowDeletingRow;
	public boolean getAllowDeletingRow(){return _AllowDeletingRow;}
	public void setAllowDeletingRow(boolean AllowDeletingRow){_AllowDeletingRow=AllowDeletingRow;}

	private List<String> _AllowEditArea;
	public List<String> getAllowEditArea(){return _AllowEditArea;}
	public void setAllowEditArea(List<String> AllowEditArea){_AllowEditArea=AllowEditArea;}

	private boolean _AllowFiltering;
	public boolean getAllowFiltering(){return _AllowFiltering;}
	public void setAllowFiltering(boolean AllowFiltering){_AllowFiltering=AllowFiltering;}

	private boolean _AllowFormattingCell;
	public boolean getAllowFormattingCell(){return _AllowFormattingCell;}
	public void setAllowFormattingCell(boolean AllowFormattingCell){_AllowFormattingCell=AllowFormattingCell;}

	private boolean _AllowFormattingColumn;
	public boolean getAllowFormattingColumn(){return _AllowFormattingColumn;}
	public void setAllowFormattingColumn(boolean AllowFormattingColumn){_AllowFormattingColumn=AllowFormattingColumn;}

	private boolean _AllowFormattingRow;
	public boolean getAllowFormattingRow(){return _AllowFormattingRow;}
	public void setAllowFormattingRow(boolean AllowFormattingRow){_AllowFormattingRow=AllowFormattingRow;}

	private boolean _AllowInsertingColumn;
	public boolean getAllowInsertingColumn(){return _AllowInsertingColumn;}
	public void setAllowInsertingColumn(boolean AllowInsertingColumn){_AllowInsertingColumn=AllowInsertingColumn;}

	private boolean _AllowInsertingHyperlink;
	public boolean getAllowInsertingHyperlink(){return _AllowInsertingHyperlink;}
	public void setAllowInsertingHyperlink(boolean AllowInsertingHyperlink){_AllowInsertingHyperlink=AllowInsertingHyperlink;}

	private boolean _AllowInsertingRow;
	public boolean getAllowInsertingRow(){return _AllowInsertingRow;}
	public void setAllowInsertingRow(boolean AllowInsertingRow){_AllowInsertingRow=AllowInsertingRow;}

	private boolean _AllowSelectingLockedCell;
	public boolean getAllowSelectingLockedCell(){return _AllowSelectingLockedCell;}
	public void setAllowSelectingLockedCell(boolean AllowSelectingLockedCell){_AllowSelectingLockedCell=AllowSelectingLockedCell;}

	private boolean _AllowSelectingUnlockedCell;
	public boolean getAllowSelectingUnlockedCell(){return _AllowSelectingUnlockedCell;}
	public void setAllowSelectingUnlockedCell(boolean AllowSelectingUnlockedCell){_AllowSelectingUnlockedCell=AllowSelectingUnlockedCell;}

	private boolean _AllowSorting;
	public boolean getAllowSorting(){return _AllowSorting;}
	public void setAllowSorting(boolean AllowSorting){_AllowSorting=AllowSorting;}

	private boolean _AllowUsingPivotTable;
	public boolean getAllowUsingPivotTable(){return _AllowUsingPivotTable;}
	public void setAllowUsingPivotTable(boolean AllowUsingPivotTable){_AllowUsingPivotTable=AllowUsingPivotTable;}
   
    public ProtectionOptions()
    { }
    public ProtectionOptions(boolean allowDeletingColumn, boolean allowDeletingRow, List<String> allowEditArea, boolean allowFiltering, boolean allowFormattingCell, boolean allowFormattingColumn, boolean allowFormattingRow, boolean allowInsertingColumn, boolean allowInsertingHyperlink, boolean allowInsertingRow, boolean allowSelectingLockedCell, boolean allowSelectingUnlockedCell, boolean allowSorting, boolean allowUsingPivotTable)
    {
        _AllowDeletingColumn = allowDeletingColumn;
        _AllowDeletingRow = allowDeletingRow;
        _AllowEditArea = allowEditArea;
        _AllowFiltering = allowFiltering;
        _AllowFormattingCell = allowFormattingCell;
        _AllowFormattingColumn = allowFormattingColumn;
        _AllowFormattingRow = allowFormattingRow;
        _AllowInsertingColumn = allowInsertingColumn;
        _AllowInsertingHyperlink = allowInsertingHyperlink;
        _AllowInsertingRow = allowInsertingRow;
        _AllowSelectingLockedCell = allowSelectingLockedCell;
        _AllowSelectingUnlockedCell = allowSelectingUnlockedCell;
        _AllowSorting = allowSorting;
        _AllowUsingPivotTable = allowUsingPivotTable;
    }
}
