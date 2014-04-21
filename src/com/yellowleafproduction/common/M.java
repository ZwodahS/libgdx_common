package com.yellowleafproduction.common;

public class M
{
    public static float bound(float value, float min, float max)
    {
        return value < min ? min : value > max ? max : value;
    }
    
    public static int bound(int value, int min, int max)
    {
        return value < min ? min : value > max ? max : value;
    }
}
