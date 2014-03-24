package com.yellowleafproduction.common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * C, also known as Chaining, allow easy chaining of methods.
 * 
 * A static class that contains some static method that can be used for chaining.
 * 
 * The idea of chaining is to allow the output of a method to be the input of another by returning the input.
 * 
 * For example, Sprite's set Color not return itself.
 * Because of that if you need to set the color and the size of the sprite you need to do it in 2 lines.
 *  
 *  Chaining is best uses during construction of objects and in objects where the behavior of those methods are clear, like setColor setSize.
 */
public class C
{
    /**
     * Private constructor to make the class static
     */
    private C()
    {
    }
    /**
     * Set the color of the sprite, and return the sprite
     */
    public final static Sprite setColor(Sprite sprite, Color color)
    {
        sprite.setColor(color);
        return sprite;
    }
    /**
     * Flip the sprite.
     */
    public final static Sprite flip(Sprite sprite, boolean flipX, boolean flipY)
    {
        sprite.flip(flipX, flipY);
        return sprite;
    }
    /**
     * Set the position of the sprite
     */
    public final static Sprite setPosition(Sprite sprite, float x, float y)
    {
        sprite.setPosition(x, y);
        return sprite;
    }
    
    public final static BitmapFont setColor(BitmapFont font, Color color)
    {
        font.setColor(color);
        return font;
    }
}
