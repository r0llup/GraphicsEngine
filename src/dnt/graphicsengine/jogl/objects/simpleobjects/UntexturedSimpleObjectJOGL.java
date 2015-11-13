package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;

import dnt.graphicsengine.interfaces.UntexturedSimpleObject;
import dnt.graphicsengine.jogl.objects.ObjectJOGL;

public abstract class UntexturedSimpleObjectJOGL extends ObjectJOGL implements UntexturedSimpleObject {
	private Color color;
	private Color selectionColor;
	private Float size;

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Integer r, Integer g, Integer b) {
		this.setColor(new Color(r, g, b));
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public Color getSelectionColor() {
		return selectionColor;
	}

	@Override
	public void setSelectionColor(Integer r, Integer g, Integer b) {
		this.setSelectionColor(new Color(r, g, b));
	}

	@Override
	public void setSelectionColor(Color c) {
		this.selectionColor = c;
	}

	public Float getSize() {
		return size;
	}

	@Override
	public void setSize(Float size) {
		this.size = size;
	}

	@Override
	public void select(Color selectionColor) {
		this.setSelectionColor(selectionColor);
	}
}