package com.yellowleafproduction.common;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;

/**
 * This class is the generic game class that I used with some common methods that it useful,
 * for example calculating stage size using screen size etc.
 */
public abstract class GenericGame extends Game implements AssetsHolder
{
    private float stageWidth;
    private float stageHeight;
    
    /**
     * Store the list of texture.
     */
    private ArrayMap<String, Texture> textureMap;
    /**
     * Store a map of all the texture region.
     */
    private ArrayMap<String, TextureRegion> regionMap;
    /**
     * Getter for stage width
     */
    private ArrayMap<String, BitmapFont> fontMap;
    /**
     * Store the list of sound.
     */
    private ArrayMap<String, Sound> soundMap;
    /**
     * Stores the animation frames
     */
    private ArrayMap<String, TextureRegion[]> animationFrames;
    
    public GenericGame()
    {
        textureMap = new ArrayMap<String, Texture>();
        regionMap = new ArrayMap<String, TextureRegion>();
        fontMap = new ArrayMap<String, BitmapFont>();
        soundMap = new ArrayMap<String, Sound>();
        animationFrames = new ArrayMap<String, TextureRegion[]>();
    }
    
    public float getStageWidth()
    {
        return stageWidth;
    }
    /**
     * Getter for stage height
     */
    public float getStageHeight()
    {
        return stageHeight;
    }
    /**
     * Recalculate the stage size based on a fixed width
     * Call this when width/height is changed.
     */
    public void calculateStageSizeByWidth(float screenWidth, float screenHeight, float targetWidth)
    {
        stageWidth = targetWidth;
        stageHeight = (screenHeight/screenWidth) * stageWidth;
    }
    
    public void calculateStageSizeByHeight(float screenWidth, float screenHeight, float targetHeight)
    {
        stageHeight = targetHeight;
        stageWidth = (screenWidth/screenHeight) * stageHeight;
    }
    public void calculateStageSizeByBothWidthFirst(float screenWidth, float screenHeight, float minimumWidth, float minimumHeight)
    {
        float heightIfWidth = (screenHeight/screenWidth) * minimumWidth;
        if(heightIfWidth > minimumHeight)
        {
            stageHeight = heightIfWidth;
            stageWidth = minimumWidth;
        }
        else
        {
            stageHeight = minimumHeight;
            stageWidth = (screenWidth/screenHeight) * minimumHeight;
        }
    }
    public void calculateStageSizeByBothHeightFirst(float screenWidth, float screenHeight, float minimumWidth, float minimumHeight)
    {
        float widthIfHeight = (screenWidth/screenHeight) * minimumHeight;
        if(widthIfHeight > minimumWidth)
        {
            stageHeight = minimumHeight;
            stageWidth = widthIfHeight;
        }
        else
        {
            stageHeight = (screenHeight/screenWidth) * minimumWidth;
            stageWidth = minimumWidth;
        }
    }
    /**
     * Add a texture.
     * if texture exist, it will be overwrite.
     */
    public Texture addTexture(String id, Texture t)
    {
        if(t == null)
        {
            return null;
        }
        textureMap.put(id, t);
        return t;
    }
    /**
     * Return the texture with this id.
     * return ull if not exist.
     */
    public Texture getTexture(String id)
    {
        return textureMap.get(id);
    }
    /**
     * Load the texture from the path and put it into the id.
     * Return the texture that is loaded.
     */
    public Texture loadTexture(String id, String path)
    {
        Texture texture = new Texture(Gdx.files.internal("data/main.png"));
        addTexture(id, texture); 
        return texture;
    }
    
    public TextureRegion[] addAnimations(String id, TextureRegion[] regions)
    {
        if(regions == null)
        {
            return null;
        }
        animationFrames.put(id, regions);
        return regions;
    }
    
    public TextureRegion[] getAnimationFrames(String id)
    {
        return animationFrames.get(id);
    }
    /**
     * Add a texture region
     */
    public TextureRegion addTextureRegion(String id, TextureRegion t)
    {
        if(t == null)
        {
            return null;
        }
        regionMap.put(id, t);
        return t;
    }
    /**
     * Return the texture region of this id.
     * return null if do not exist.
     */
    public TextureRegion getTextureRegion(String id)
    {
        return regionMap.get(id);
    }
    /**
     * Add a bitmap font.
     */
    /**
     * Create a sprite using a texture region.
     * If texture region do not exist, then return null.
     */
    public Sprite createSprite(String id)
    {
        TextureRegion region = regionMap.get(id);
        return region == null ? null : new Sprite(region);
    }
    /**
     * add a bitmap font
     */
    public BitmapFont addBitmapFont(String id, BitmapFont font)
    {
        if(font == null)
        {
            return null;
        }
        fontMap.put(id, font);
        return font;
    }
    /**
     * get a bitmap font
     */
    public BitmapFont getBitmapFont(String id)
    {
        return fontMap.get(id);
    }
    /**
     * add a sound
     */
    public Sound addSound(String id, Sound sound)
    {
        if(sound == null)
        {
            return null;
        }
        soundMap.put(id, sound);
        return sound;
    }
    /**
     * get a sound
     */
    public Sound getSound(String id)
    {
        return soundMap.get(id);
    }
    @Override
    /**
     * Dispose all the resources.
     */
    public void dispose() 
    {
        super.dispose();
        for(Texture t : textureMap.values())
        {
            t.dispose();
        }
        textureMap.clear();
        regionMap.clear();
        for(BitmapFont f : fontMap.values())
        {
            f.dispose();
        }
        for(Sound s : soundMap.values())
        {
            s.dispose();
        }
    }
}
