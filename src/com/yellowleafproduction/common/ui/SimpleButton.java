package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Defines a simple button that have a text and different sprite for the different state
 * 
 * There are 3 state that we will handle.
 * 
 * 1) Normal (up) 
 * 2) Down (down)
 * 3) Disabled 
 * 
 * For some reason the label offset aren't really working properly. Don't use this for now.
 */
public class SimpleButton extends Button
{
    protected BitmapFont font;
    protected String text;
    protected Sprite up;
    protected Sprite down;
    protected Sprite disabled;

    protected AlignmentX alignmentX;
    protected float offsetX;
    protected AlignmentY alignmentY;
    protected float offsetY;

    protected BitmapFont.TextBounds textBound;
    protected float textX;
    protected float textY;
    
    public SimpleButton(BitmapFont font, String text, Sprite up, Sprite down, Sprite disabled, float width, float height)
    {
        super(width, height);
        this.font = font;
        this.text = text;
        this.up = up;
        this.down = down;
        this.disabled = disabled;
        
        this.alignmentX = AlignmentX.Center;
        this.alignmentY = AlignmentY.Top;
        textBound = new TextBounds();
        font.getBounds(text, textBound);
        
        setSpritePosition(x, y);
        calculateLabelPosition();
    }
    
    public void draw(Batch batch)
    {
        if(isDisabled)
        {
            disabled.draw(batch);
        }
        else if(isDown)
        {
            down.draw(batch);
        }
        else
        {
            up.draw(batch);
        }
        font.draw(batch, text, textX, textY);
    }

    public void setLabel(String text)
    {
        this.text = text;
        font.getBounds(text, textBound);
        calculateLabelPosition();
    }
    
    @Override
    protected void positionChanged(float diffX, float diffY)
    {
        setSpritePosition(x, y);
        textX += diffX;
        textY += diffY;
    }
    
    protected void setSpritePosition(float x, float y)
    {
        up.setPosition(x, y);
        down.setPosition(x, y);
        disabled.setPosition(x, y);
    }
    
    protected void calculateLabelPosition()
    {
        // Assume origin at the bottom left
        if(alignmentX == AlignmentX.Center)
        {
            textX = this.x + (width/2) - (textBound.width/2) + offsetX;
        }
        else if(alignmentX == AlignmentX.Left)
        {
            textX = this.x + (offsetX);
        }
        else
        {
            textX = this.x + width - textBound.width + offsetX;
        }
        // font is drawn positioned at the top.
        if(alignmentY == AlignmentY.Center)
        {
            textY = this.y + (height/2) + (textBound.height/2) + offsetY;
        }
        else if(alignmentY == AlignmentY.Top)
        {
            textY = this.y + height - offsetY;
        }
        else
        {
            textY = this.y + textBound.height - (offsetY);
        }
        System.out.println(this.y + " " + this.width + " " + this.height + " " + textBound.width + " " + textBound.height + " " + offsetY);
        System.out.println(this.textX + " " + this.textY);
    }
}
