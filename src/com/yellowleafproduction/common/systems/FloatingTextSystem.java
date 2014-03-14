package com.yellowleafproduction.common.systems;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class FloatingTextSystem
{
    public class TextObject extends AnimationObject
    {
        private float x;
        private float y;
        private BitmapFont font;
        private String string;
        
        public TextObject()
        {
        }
        
        public void reset()
        {
            font = null;
            string = "";
            super.reset();
        }
        
        public void setDraw(BitmapFont font, String string, float x, float y)
        {
            this.font = font;
            this.string = string;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public void setPosition(float x, float y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public void setPosition(Vector2 position)
        {
            setPosition(position.x, position.y);
        }
        @Override
        public float getPositionX()
        {
            return x;
        }
        @Override
        public float getPositionY()
        {
            return y;
        }
        @Override
        public Vector2 getPosition(Vector2 tmpPosition)
        {
            tmpPosition.x = x;
            tmpPosition.y = y;
            return tmpPosition;
        }
        
        public void draw(Batch batch)
        {
            if(font != null)
            {
                font.draw(batch, string, x, y);
            }
        }
        
        public void update(float delta)
        {
            super.update(delta);
        }
    }
    
    
    private Array<TextObject> objects;
    private Array<TextObject> caches;
    private BasicAnimationInstructionCache instructionCache;
    
    public FloatingTextSystem()
    {
        objects = new Array<TextObject>();
        caches = new Array<TextObject>();
        instructionCache = new BasicAnimationInstructionCache();
    }
    
    public void draw(Batch batch)
    {
        for(TextObject text : objects)
        {
            text.draw(batch);
        }
    }
    
    public void update(float delta)
    {
        for(TextObject text : objects)
        {
            text.update(delta);
        }
        
        for(int i = objects.size - 1; i >= 0 ; i--)
        {
            TextObject obj = objects.get(i);
            if(!obj.hasInstruction())
            {
                obj.free();
                objects.removeIndex(i);
                caches.add(obj);
            }
        }
    }
    
    private TextObject getTextObject()
    {
        if(caches.size == 0)
        {
            TextObject object = new TextObject();
            object.reset();
            return object;
        }
        else
        {
            TextObject object = caches.pop();
            object.reset();
            return object;
        }
    }
    
    public void drawTextAt(BitmapFont font, String string, float startingX, float startingY, float targetX, float targetY, float moveSpeedX, float moveSpeedY)
    {
        TextObject object = getTextObject();
        object.setDraw(font, string, startingX, startingY);
        MoveToInstruction instruction = instructionCache.getMoveToInstruction();
        instruction.moveTo(targetX, targetY, moveSpeedX, moveSpeedY);
        object.addInstruction(instruction);
        objects.add(object);
    }
}
