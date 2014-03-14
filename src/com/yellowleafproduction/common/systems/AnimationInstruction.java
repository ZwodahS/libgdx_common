package com.yellowleafproduction.common.systems;

public abstract class AnimationInstruction
{
    /**
     * The cache that this instruction is created in.
     */
    private AnimationInstructionCache cache;
    
    public AnimationInstruction(AnimationInstructionCache cache)
    {
        this.cache = cache;
    }
    
    public abstract void update(AnimationObject object, float delta);
 // like a constructor , but called when the object is taken from cache.
    public AnimationInstruction reset() 
    {
        return this;
    }

    /**
     * Free this instruction, and return it to the cache.
     * 
     * If there are additional things to be done, child class must call this after they are done with their cleanup.
     */
    public void free() 
    {
        cache.freeInstruction(this);
    }
    
    public abstract boolean hasStarted();
    public abstract boolean hasEnded();
}
