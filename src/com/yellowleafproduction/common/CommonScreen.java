package com.yellowleafproduction.common;

import com.badlogic.gdx.Screen;

public abstract class CommonScreen implements Screen
{
    
    protected boolean isActive;
    public CommonScreen()
    {
        isActive = false;
    }
    @Override
    public void hide()
    {
        this.isActive = false;
    }
    @Override
    public void show()
    {
        this.isActive = true;
    }
    
}
