package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteTextButton extends SpriteButton
{
    private Sprite spriteText;
    private float textOffsetX;
    private float textOffsetY;
    
    public SpriteTextButton(Sprite up, Sprite down, Sprite disabled, Sprite text, float width, float height)
    {
        super(up, down, disabled, width, height);
        this.textOffsetX = 0;
        this.textOffsetY = 0;
    }

    public void draw(Batch batch)
    {
        super.draw(batch);
        spriteText.draw(batch);
    }
    
    @Override
    protected void positionChanged(float diffX, float diffY)
    {
        super.positionChanged(diffX, diffY);
        setSpriteTextPosition(x, y);
    }
    
    private void setSpriteTextPosition(float x, float y)
    {
        spriteText.setPosition(x + textOffsetX, y + textOffsetY);
    }
    
    public void setTextOffset(float offX, float offY)
    {
        this.textOffsetX = offX;
        this.textOffsetY = offY;
        setSpriteTextPosition(x, y);
    }
}
