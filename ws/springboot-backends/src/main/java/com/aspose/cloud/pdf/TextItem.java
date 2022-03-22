/**
 * 
 */
package com.aspose.cloud.pdf;

import java.lang.String;
import java.util.List;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single text item
/// </summary>
public class TextItem
{
    public TextItem() { }

    private List<LinkResponse> _Links;
    public List<LinkResponse> getLinks(){return _Links;}
    public void setLinks(List<LinkResponse> Links){_Links=Links;}

    private TextFormat Format;
    private String Text;
    
    public TextFormat getTextFormat(){return Format;}
    public String getText(){return Text;}

}