package com.yellowleafproduction.common.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;

public class BoundedText
{
    public static final String END = "_____END_____";
    private String string;
    private float x;
    private float y;
    private BitmapFont font;

    public BoundedText()
    {
        string = "";
        x = 0;
        y = 0;
        font = null;
    }
    
    public void draw(Batch batch)
    {
        if(font != null)
        {
            font.draw(batch, string, x, y);
        }
    }
    
    public BoundedText setDrawParameter(String string)
    {
        if(font == null)
        {
            return this;
        }
        return setDrawParameter(this.font, this.x, this.y, string);
    }
    
    public BoundedText setDrawParameter(BitmapFont font, float x, float y, String string)
    {
        return setDrawParameter(font, x, y, string, AlignmentX.Center);
    }
    
    public BoundedText setDrawParameter(BitmapFont font, float x, float y, String string, AlignmentX alignmentX)
    {
        if(font == null)
        {
            return this;
        }
        if(alignmentX == AlignmentX.Left)
        {
            this.x = x;
        }
        else
        {
            TextBounds bound = font.getBounds(string);
            if(alignmentX == AlignmentX.Center)
            {
                this.x = x - (bound.width == 0 ? 0 : (bound.width/2));
            }
            else
            {
                this.x = x - bound.width;
            }
        }
        this.y = y;
        this.string = string;
        this.font = font;
        return this;
    }
    
    /**
     * This is extremely slow, use with care.
     * Ignoring resizing, 
     * TODO : make tempString resize if the strings get too large.
     * Assumption : NO STRING ARE BIGGER THAN WIDTH, else infinite loop is guaranteed.
     */
    public static String[] tempStrings = new String[20];
    public static char[] endings = new char[]{' ', '.', ',', '!', '?'};
    public static String[] split(String string, float maxWidth, BitmapFont font)
    {
        int start = 0;
        for(int i = 0; i < tempStrings.length; i++)
        {
            tempStrings[i] = "";
        }
        int i = 0;
        while(start != string.length())
        {
            int count = font.computeVisibleGlyphs(string, start, string.length(), maxWidth);
            if(count + start != string.length()) // have not reach the end
            {
                while(!contains(string.charAt(count + start), endings))
                {
                    count --;
                }
            }
            tempStrings[i] = string.substring(start, start+count);
            start += count;
            i++;
        }
        tempStrings[i] = END;
        return tempStrings;
    }

    private static boolean contains(char charAt, char[] endings2)
    {
        for(char c : endings2)
        {
            if(c == charAt)
            {
                return true;
            }
        }
        return false;
    }
}
