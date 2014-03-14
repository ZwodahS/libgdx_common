package com.yellowleafproduction.common.systems;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


/**
 * The implementation of animation object.
 * 
 * Sightly different from how I done it in SFML.
 * Main reason is because I need to deal with handling GC.
 */
public abstract class AnimationObject
{

    private Array<AnimationInstruction> instructions;
    
    public AnimationObject()
    {
        instructions = new Array<AnimationInstruction>();
    }
    
    
    public abstract void setPosition(float x, float y);
    public abstract void setPosition(Vector2 position);
    public abstract float getPositionX();
    public abstract float getPositionY();
    public abstract Vector2 getPosition(Vector2 tmpPosition);
    
    
    public void free()
    {
        for(AnimationInstruction instruction : instructions)
        {
            instruction.free();
        }
        instructions.clear();
    }
    
    public void reset()
    {
    }
    
    public void addInstruction(AnimationInstruction instruction)
    {
        instructions.add(instruction);
    }
    
    public void update(float delta)
    {
        for(AnimationInstruction instruction : instructions)
        {
            instruction.update(this, delta);
        }
        for(int i = instructions.size - 1; i >= 0; i--)
        {
            AnimationInstruction instruction = instructions.get(i);
            if(instruction.hasEnded())
            {
                instruction.free();
                instructions.removeIndex(i);
            }
        }
    }
    
    public boolean hasInstruction()
    {
        return instructions.size > 0;
    }
}
