package com.yellowleafproduction.common;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface AssetsHolder
{
    public Texture getTexture(String id);
    public TextureRegion getTextureRegion(String id);
    public Sprite createSprite(String id);
    public BitmapFont getBitmapFont(String id);
    public Sound getSound(String id);
}
