package com.yellowleafproduction.common.systems;

/**
 * AnimationInstruction cache is the place that instructions should be created.
 */
public interface AnimationInstructionCache
{
    public MoveToInstruction getMoveToInstruction();
    public void freeInstruction(AnimationInstruction instruction);
}
