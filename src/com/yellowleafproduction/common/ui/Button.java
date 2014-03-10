package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * This is a simple version of button that can be used instead of LibGdx scene's Button.
 * 
 * I prefer to manage a lot of things myself instead of using the scene stuffs.
 * 
 */
public abstract class Button
{
    /**
     * The x/y/width/height of this button
     */
    protected float width;
    protected float height;
    protected float x;
    protected float y;
    /**
     * Standard possible state of the button.
     */
    /**
     * Boolean representing whether this button is being pressed.
     */
    public boolean isDown;
    /**
     * Boolean representing if this button is enabled.
     */
    public boolean isDisabled;
    
    public Button(float width, float height)
    {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        this.isDown = false;
        this.isDisabled = false;
    }
    /**
     * return true if the button contains this position
     */
    public boolean contains(float positionX, float positionY)
    {
        return this.x <= positionX && positionX < this.x + width && this.y <= positionY && positionY < this.y + height;
    }
    public boolean contains(Vector2 position)
    {
        return contains(position.x, position.y);
    }
    /**
     * The set position method
     */
    public final void setPosition(float x, float y)
    {
        float diffX = x - this.x;
        float diffY = y - this.y;
        this.x = x;
        this.y = y;
        positionChanged(diffX, diffY);
    }
    /**
     * override by child to be informed of position changes.
     * x y is the difference between the previous position and the current position, or the moved amount
     * (newX - oldX)
     * (newY - oldY)
     */
    protected abstract void positionChanged(float x, float y);
    /*
     * Getters for position
     */
    public float getPositionX()
    {
        return x;
    }
    public float getPositionY()
    {
        return y;
    }
    /**
     * The information of the position will be put into the position
     */
    public final Vector2 getPosition(Vector2 position)
    {
        position.x = x;
        position.y = y;
        return position;
    }
    /**
     * Return the Vector2 containing the position of this button.
     * Will create a new object. pass in a Vector2 to prevent creation of a object.
     */
    public final Vector2 getPosition()
    {
        Vector2 position = new Vector2();
        return getPosition(position);
    }
    /**
     * Get the rectangle bound for this button
     */
    public final Rectangle getBound(Rectangle bound)
    {
        bound.x = this.x;
        bound.y = this.y;
        bound.width = this.width;
        bound.height = this.height;
        return bound;
    }
    
    public final Rectangle getBound()
    {
        Rectangle bound = new Rectangle();
        return getBound(bound);
    }
    /**
     * The abstract draw method to be used by subclass 
     */
    public abstract void draw(Batch batch);
    
    public void setDisabled(boolean b)
    {
        isDisabled = b;
    }
    
    public void setDown(boolean b)
    {
        isDown = b;
    }
    
}
