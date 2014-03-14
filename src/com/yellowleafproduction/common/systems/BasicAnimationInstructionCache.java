package com.yellowleafproduction.common.systems;

import com.badlogic.gdx.utils.Array;

public class BasicAnimationInstructionCache implements AnimationInstructionCache
{
    private Array<MoveToInstruction> moveToInstructions;
    public BasicAnimationInstructionCache()
    {
        moveToInstructions = new Array<MoveToInstruction>();
    }
    
    
    
    @Override
    public MoveToInstruction getMoveToInstruction()
    {
        if(moveToInstructions.size != 0)
        {
            return (MoveToInstruction)(moveToInstructions.pop().reset());
        }
        else
        {
            MoveToInstruction instruction = new MoveToInstruction(this);
            return (MoveToInstruction)(instruction.reset());
        }
    }
    @Override
    public void freeInstruction(AnimationInstruction instruction)
    {
        if(instruction instanceof MoveToInstruction)
        {
            moveToInstructions.add((MoveToInstruction)instruction);
        }
    }
}
