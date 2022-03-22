/**
 * 
 */
package com.aspose.cloud.pdf;
import java.util.List;

/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents container part of the Annotations resource response
/// </summary>
public  class AnnotationsEnvelop
{
    private List<LinkResponse> Links;
    private List<Annotation> List;
    
    public List<LinkResponse> getLinkResponseList(){return Links;}
    public List<Annotation> getAnnotationList(){return getList();}
	public List<Annotation> getList() {
		return List;
	}
	public void setList(List<Annotation> list) {
		List = list;
	}
    

}
