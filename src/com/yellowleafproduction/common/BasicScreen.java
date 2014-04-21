package com.yellowleafproduction.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class BasicScreen extends CommonScreen implements InputProcessor
{
    protected OrthographicCamera camera;
    protected static Vector3 tmp_vector3 = new Vector3(0, 0, 0);
    
    
    public BasicScreen()
    {
        camera = new OrthographicCamera();
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if(isActive)
        {
            tmp_vector3.x = screenX;
            tmp_vector3.y = screenY;
            tmp_vector3.z = 0;
            camera.unproject(tmp_vector3);
            return touchDown(tmp_vector3.x, tmp_vector3.y, pointer, button);
        }
        return false;
    }
    
    protected boolean touchDown(float stageX, float stageY, int pointer, int button)
    {
        return false;
    }
    

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        if(isActive)
        {
            tmp_vector3.x = screenX;
            tmp_vector3.y = screenY;
            tmp_vector3.z = 0;
            camera.unproject(tmp_vector3);
            return touchUp(tmp_vector3.x, tmp_vector3.y, pointer, button);
        }
        return false;
    }
    
    protected boolean touchUp(float stageX, float stageY, int pointer, int button)
    {
        return false;
    }
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        if(isActive)
        {
            tmp_vector3.x = screenX;
            tmp_vector3.y = screenY;
            tmp_vector3.z = 0;
            camera.unproject(tmp_vector3);
            return touchDragged(tmp_vector3.x, tmp_vector3.y, pointer);
        }
        return false;
    }

    protected boolean touchDragged(float stageX, float stageY, int pointer)
    {
        return false;
    }
 
    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }


    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }


    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }


    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }
    
    
    @Override
    public void show()
    {
        super.show();
        Gdx.input.setInputProcessor(this);
    }
    
    @Override
    public void hide()
    {
        if(Gdx.input.getInputProcessor() == this)
        {
            Gdx.input.setInputProcessor(null);
        }
    }
}
