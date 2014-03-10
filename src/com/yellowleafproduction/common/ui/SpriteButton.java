package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteButton extends Button
{

    private Sprite up;
    private Sprite down;
    private Sprite disabled;
    
    public SpriteButton(Sprite up, Sprite down, Sprite disabled, float width, float height)
    {
        super(width, height);
        this.up = up;
        this.down = down;
        this.disabled = disabled;
        
        setSpritePosition(x, y);
    }
    
    @Override
    protected void positionChanged(float xDiff, float yDiff)
    {
        setSpritePosition(x, y);
    }
    
    private void setSpritePosition(float x, float y)
    {
        up.setPosition(x, y);
        down.setPosition(x, y);
        disabled.setPosition(x, y);
    }

    @Override
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
    }

}
