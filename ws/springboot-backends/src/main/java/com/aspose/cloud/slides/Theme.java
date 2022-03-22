package com.aspose.cloud.slides;

import java.util.List;

public class Theme {
	private List<LinkResponse> __links;
	public List<LinkResponse> get_links(){return __links;}
	public void set_links(List<LinkResponse> _links){__links=_links;}

	private ThemeColorScheme _ColorScheme;
	public ThemeColorScheme getColorScheme(){return _ColorScheme;}
	public void setColorScheme(ThemeColorScheme ColorScheme){_ColorScheme=ColorScheme;}

	private ThemeFontScheme _FontScheme;
	public ThemeFontScheme getFontScheme(){return _FontScheme;}
	public void setFontScheme(ThemeFontScheme FontScheme){_FontScheme=FontScheme;}

	private ThemeFormatScheme _FormatScheme;
	public ThemeFormatScheme getFormatScheme(){return _FormatScheme;}
	public void setFormatScheme(ThemeFormatScheme FormatScheme){_FormatScheme=FormatScheme;}

	private String _Name;
	public String getName(){return _Name;}
	public void setName(String Name){_Name=Name;}

}
