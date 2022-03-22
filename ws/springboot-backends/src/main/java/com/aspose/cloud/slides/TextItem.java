/**
 * 
 */
package com.aspose.cloud.slides;
import java.lang.String;
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

    private String Text; 
    private ShapeURI Uri;
    
    public String getText(){return Text;}
    public ShapeURI getUri(){return Uri;}
}