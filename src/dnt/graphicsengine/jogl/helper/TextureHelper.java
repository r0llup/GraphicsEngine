package dnt.graphicsengine.jogl.helper;

import java.io.File;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 * Manage a TextureHelper
 * @author Sh1fT
 *
 */
public class TextureHelper {
	/**
	 * Load a texture
	 * @param filename
	 * @return
	 */
	public static Texture loadTexture(GL2 gl2, String filename) {
		Texture texture = null;
		try {
			texture = TextureIO.newTexture(new File(filename), false);
			texture.setTexParameteri(gl2, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_NEAREST);
			texture.setTexParameteri(gl2, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_NEAREST);
		} catch(Exception ex) {
			System.out.println("Error: Failed to load the texture '" + filename + "' :\n" + ex.getLocalizedMessage());
		}
		return texture;
	}
}