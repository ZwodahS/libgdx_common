package com.yellowleafproduction.common.systems;

import com.badlogic.gdx.math.Vector2;

/**
 * move to this position using the given speed
 * 
 */
public class MoveToInstruction extends AnimationInstruction
{

    private float targetX;
    private float targetY;
    private float moveSpeedX;
    private float moveSpeedY;

    private Vector2 tmp_position;

    private boolean instructionStarted;
    private boolean instructionEnded;

    public MoveToInstruction(AnimationInstructionCache cache)
    {
        super(cache);
        tmp_position = new Vector2();
    }

    @Override
    public void update(AnimationObject object, float delta)
    {
        if(instructionStarted && !instructionEnded)
        {
            object.getPosition(tmp_position);
            if(tmp_position.x < targetX)
            {
                tmp_position.x += delta * moveSpeedX;
                if(tmp_position.x > targetX)
                {
                    tmp_position.x = targetX;
                }
            }
            else if(tmp_position.x > targetX)
            {
                tmp_position.x -= delta * moveSpeedX;
                if(tmp_position.x < targetX)
                {
                    tmp_position.x = targetX;
                }
            }
            
            if(tmp_position.y < targetY)
            {
                tmp_position.y += delta * moveSpeedY;
                if(tmp_position.y > targetY)
                {
                    tmp_position.y = targetY;
                }
            }
            else if(tmp_position.y > targetY) 
            {
                tmp_position.y -= delta * moveSpeedY;
                if(tmp_position.y < targetY)
                {
                    tmp_position.y = targetY;
                }
            }
            
            object.setPosition(tmp_position);
            if(tmp_position.x == targetX && tmp_position.y == targetY)
            {
                instructionEnded = true;
            }
        }
    }

    @Override
    public AnimationInstruction reset()
    {
        instructionStarted = false;
        return super.reset();
    }

    public void moveTo(float targetX, float targetY, float moveSpeedX, float moveSpeedY)
    {
        this.targetX = targetX;
        this.targetY = targetY;
        this.moveSpeedX = moveSpeedX;
        this.moveSpeedY = moveSpeedY;
        this.instructionStarted = true;
        this.instructionEnded = false;
    }

    public boolean hasStarted()
    {
        return instructionStarted;
    }

    public boolean hasEnded()
    {
        return instructionEnded;
    }
}
