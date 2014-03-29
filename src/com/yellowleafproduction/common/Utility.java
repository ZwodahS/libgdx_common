package com.yellowleafproduction.common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Here contains all the utility stuffs i found on the net
 * 
 */
public class Utility
{

    /**
     * A draw rect method 
     * http://www.java-gaming.org/index.php?topic=28457.0
     */
    private static float[] verts = new float[20];
    public static void drawRect(Batch batch, TextureRegion tex, float x, float y, float width, float height, 
            float r, float g, float b, float a)
    {
        float ca = Color.toFloatBits(r, g, b, a);
        drawRect(batch, tex, x, y, width, height, ca);
    }
    
    /**
     * Use Color.toFloatBits() to get the float value for color.
     */
    public static void drawRect(Batch batch, TextureRegion tex, float x, float y, float width, float height, float color)
    {
        int idx = 0;
        verts[idx++] = x;
        verts[idx++] = y;
        verts[idx++] = color; // bottom left
        verts[idx++] = tex.getU(); //NOTE: texture coords origin is top left
        verts[idx++] = tex.getV2();

        verts[idx++] = x;
        verts[idx++] = y + height;
        verts[idx++] = color; // top left
        verts[idx++] = tex.getU();
        verts[idx++] = tex.getV();

        verts[idx++] = x + width;
        verts[idx++] = y + height;
        verts[idx++] = color; // top right
        verts[idx++] = tex.getU2();
        verts[idx++] = tex.getV();

        verts[idx++] = x + width;
        verts[idx++] = y;
        verts[idx++] = color; // bottom right
        verts[idx++] = tex.getU2();
        verts[idx++] = tex.getV2();

        batch.draw(tex.getTexture(), verts, 0, verts.length);
    }
}
