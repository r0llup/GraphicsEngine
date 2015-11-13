package dnt.graphicsengine.jogl.objects.complexobjects;

import java.awt.Color;
import java.util.List;

import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.interfaces.ComplexObject;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.interfaces.UntexturedSimpleObject;
import dnt.graphicsengine.jogl.objects.ObjectJOGL;

public abstract class ComplexObjectJOGL extends ObjectJOGL implements ComplexObject {
	private List<Object> objects;
	private Position3D startPosition;

	public List<Object> getObjects() {
		return objects;
	}

	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}

	public Position3D getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Position3D startPosition) {
		this.startPosition = startPosition;
	}

	@Override
	public List<Object> getChildren() {
		return this.getObjects();
	}

	@Override
	public void addObject(Object object) {
		this.getObjects().add(object);
	}

	@Override
	public void removeObject(Object object) {
		this.getObjects().remove(object);
	}

	@Override
	public void select(Color selectionColor) {
		for (Object o : this.getObjects())
			this.fetchObj(o, selectionColor);
	}

	private void fetchObj(Object obj, Color selectColor) {
		if (obj instanceof UntexturedSimpleObject)
			((UntexturedSimpleObject) obj).setSelectionColor(selectColor);
		else if (obj instanceof ComplexObject) {
			for (Object o : ((ComplexObject) obj).getChildren())
				this.fetchObj(o, selectColor);
		}
	}
}