/**
 * 
 */
package com.aspose.cloud.pdf;

import java.lang.String;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single bookmark in document
/// </summary>

public class Bookmark
{
    public Bookmark() { }

  //  public List<LinkResponse> Links { get; set; }
    private String Title;
    private boolean Italic;
    private boolean Bold;
    private Color Color;
    
    public String Title(){return Title;}   
    public boolean getIsItalic(){return Italic;}
    public boolean getIsBold(){return Bold;}
    public Color getColor(){return Color;}
}