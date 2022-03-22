/**
 * 
 */
package com.aspose.cloud.slides;
import java.util.List;
import java.lang.String;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents container part of the slides resource response
/// </summary>
public class SlidesEnvelop
{

    private List<String> AlternateLinks;
    private List<LinkResponse> Links;
    private UriResponse SelfUri;
    private List<SlideResponse> SlideList;
    
    public List<String> getAlternateLinks(){return AlternateLinks;}
    public List<LinkResponse> getLinks(){return Links;}
    public List<SlideResponse> getSlideList(){return SlideList;}
    public UriResponse getSelfUri(){return SelfUri;}
}