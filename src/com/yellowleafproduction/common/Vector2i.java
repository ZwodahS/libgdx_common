package com.yellowleafproduction.common;

/**
 * A implementation similar to Vector2, except that this is integer.
 * Some operator are not supported because of that.
 * 
 * In additional to that, this will be used like cell value.
 * Therefore some additional methods are provided. 
 * 
 */
public class Vector2i
{
    public int x;
    public int y;
    
    public Vector2i()
    {
        this.x = 0;
        this.y = 0;
    }
    
    public Vector2i(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Vector2i(Vector2i copy)
    {
        this.x = copy.x;
        this.y = copy.y;
    }
    
    public Vector2i add(int x, int y)
    {
        this.x += x;
        this.y += y;
        return this;
    }
    
    public Vector2i add(Vector2i vector)
    {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }
    
    public Vector2i sub(int x, int y)
    {
        this.x -= x;
        this.y -= y;
        return this;
    }
    
    public Vector2i sub(Vector2i vector)
    {
        this.x -= vector.x;
        this.y -= vector.y;
        return this;
    }
    
    public Vector2i set(int x, int y)
    {
        this.x = x;
        this.y = y;
        return this;
    }
    
    public Vector2i set(Vector2i copy)
    {
        this.x = copy.x;
        this.y = copy.y;
        return this;
    }
    
    public String toString()
    {
        return "("+x+","+y+")";
    }
    
    /**
     * Adjacent position are (1, 0), (-1, 0), (0, 1), (0, -1)
     */
    public boolean isAdjacentTo(int x, int y)
    {
        return isAdjacent(this.x, this.y, x, y);
    }
    
    public static boolean isAdjacent(int x1, int y1, int x2, int y2)
    {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2) == 1);
    }
    
    
    /**
     * Around blocks are adjacent + the four diagonal spots. 
     */
    public boolean isAround(int x, int y)
    {
        return isAround(this.x, x, this.y, y);
    }
    
    public static boolean isAround(int x1, int y1, int x2, int y2)
    {
        return (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) && !( (x1 - x2) == 0 && (y1 - y2) == 0);
    }
    
}
