package com.yellowleafproduction.common;

public enum Direction
{
    None,
    North,
    NorthEast,
    East,
    SouthEast,
    South,
    SouthWest,
    West,
    NorthWest;
    
    private static Vector2i tmp_vector2i = new Vector2i(0, 0);
    
    /**
     * By default, origin is at the bottom left of the screen.
     * This menas that North is (0, 1).
     * 
     * If flipY is true, then origin will be at the top left, then north will be (0, -1)
     */
    public static Vector2i getDirectionalValue(Direction d, boolean flipY)
    {
        switch(d)
        {
        case None: tmp_vector2i.x = 0; tmp_vector2i.y = 0; 
            break;
        case East: tmp_vector2i.x = 1; tmp_vector2i.y = 0;
            break;
        case North: tmp_vector2i.x = 0; tmp_vector2i.y = flipY ? -1 : 1;
            break;
        case NorthEast: tmp_vector2i.x = 1; tmp_vector2i.y = flipY ? -1 : 1;
            break;
        case NorthWest: tmp_vector2i.x = -1; tmp_vector2i.y = flipY ? -1 : 1;
            break;
        case South: tmp_vector2i.x = 0; tmp_vector2i.y = flipY ? 1 : -1;
            break;
        case SouthEast: tmp_vector2i.x = 1; tmp_vector2i.y = flipY ? 1 : -1;
            break;
        case SouthWest: tmp_vector2i.x = -1; tmp_vector2i.y = flipY ? 1 : -1;
            break;
        case West: tmp_vector2i.x = -1; tmp_vector2i.y = 0;
            break;
        default: 
            break;
        }
        return tmp_vector2i;
    }
}
