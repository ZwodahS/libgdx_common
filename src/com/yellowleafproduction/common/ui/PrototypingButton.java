package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yellowleafproduction.common.Utility;

/**
 * This button is meant for prototyping only(hopefully)
 * It uses the drawRect method in Utility to draw the button.
 * A "boundedText is then use to display the string.
 */
public class PrototypingButton extends Button
{

    private float colorUp;
    private float colorDown;
    private float colorDisabled;
    // width, height - required by button.
    // colorUp , color of the butotn when nothing is done to it.
    // colorDown, color of the button when touch Down on it.
    // colorDisabled, color of the button when disabled
    // text, the text to display.
    //  the x, y position of the text is used as the offset for the text from this button.
    // tex : the texture for the button
    private float textXOffset;
    private float textYOffset;
    private BoundedText text;
    private TextureRegion texture;
    public PrototypingButton(float width, float height, float colorUp, float colorDown, float colorDisabled, BoundedText text, TextureRegion tex)
    {
        super(width, height);
        this.colorUp = colorUp;
        this.colorDown = colorDown;
        this.colorDisabled = colorDisabled;
        this.text = text;
        this.texture = tex;
        this.textXOffset = text.getOriginX();
        this.textYOffset = text.getOriginY();
    }
    @Override
    protected void positionChanged(float x, float y)
    {
        // TODO Auto-generated method stub
        text.setPosition(textXOffset + x, textYOffset + y);
    }

    @Override
    public void draw(Batch batch)
    {
        Utility.drawRect(batch, texture, x, y, width, height, isDisabled ? colorDisabled : isDown ? colorDown : colorUp);
        text.draw(batch);
    }

}
