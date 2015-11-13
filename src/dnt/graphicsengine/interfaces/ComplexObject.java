package dnt.graphicsengine.interfaces;

import java.util.List;

/**
 * Declaration of a ComplexObject
 * @author Sh1fT
 *
 */
public interface ComplexObject extends Object {
	public List<Object> getChildren();
	public void addObject(Object object);
	public void removeObject(Object object);
}