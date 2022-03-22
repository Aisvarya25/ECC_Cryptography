package com.aspose.cloud.slides;

import java.util.List;

public class Slide {
	private List<LinkResponse> __links;
	public List<LinkResponse> get_links(){return __links;}
	public void set_links(List<LinkResponse> _links){__links=_links;}

	private Images _Images;
	public Images getImages(){return _Images;}
	public void setImages(Images Images){_Images=Images;}

	private Placeholders _Placeholders;
	public Placeholders getPlaceholders(){return _Placeholders;}
	public void setPlaceholders(Placeholders Placeholders){_Placeholders=Placeholders;}

	private Shapes _Shapes;
	public Shapes getShapes(){return _Shapes;}
	public void setShapes(Shapes Shapes){_Shapes=Shapes;}

	private SlideTheme _Theme;
	public SlideTheme getTheme(){return _Theme;}
	public void setTheme(SlideTheme Theme){_Theme=Theme;}

}
