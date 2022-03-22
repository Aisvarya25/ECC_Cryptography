package com.aspose.cloud.slides;

public class FormatScheme {
	public UriResponse getSelfUri() {
		return SelfUri;
	}

	public void setSelfUri(UriResponse selfUri) {
		SelfUri = selfUri;
	}

	public BackgroundStyles[] getBackgroundStyles() {
		return BackgroundStyles;
	}

	public void setBackgroundStyles(BackgroundStyles[] backgroundStyles) {
		BackgroundStyles = backgroundStyles;
	}

	public EffectStyles[] getEffectStyles() {
		return EffectStyles;
	}

	public void setEffectStyles(EffectStyles[] effectStyles) {
		EffectStyles = effectStyles;
	}

	public FillStyles[] getFillStyles() {
		return FillStyles;
	}

	public void setFillStyles(FillStyles[] fillStyles) {
		FillStyles = fillStyles;
	}

	public LineStyles[] getLineStyles() {
		return LineStyles;
	}

	public void setLineStyles(LineStyles[] lineStyles) {
		LineStyles = lineStyles;
	}

	public FormatScheme() {
	}

	private UriResponse SelfUri;
	private BackgroundStyles[] BackgroundStyles;
	private EffectStyles[] EffectStyles;
	private FillStyles[] FillStyles;
	private LineStyles[] LineStyles;
}
