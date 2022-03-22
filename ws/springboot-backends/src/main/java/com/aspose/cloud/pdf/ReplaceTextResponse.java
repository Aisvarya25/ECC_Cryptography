package com.aspose.cloud.pdf;

import java.util.ArrayList;

/** 
represents response of a single text item
*/
public class ReplaceTextResponse extends com.aspose.cloud.common.BaseResponse
{
	private ArrayList<LinkResponse> Links;
	private int Matches;
	
	public final ArrayList<LinkResponse> getLinks(){ return Links; }
	public final int getMatches(){ return Matches; }
	
	public final void setLinks(ArrayList<LinkResponse> value){ Links = value; }
	public final void setMatches(int value){ Matches = value; }
}
