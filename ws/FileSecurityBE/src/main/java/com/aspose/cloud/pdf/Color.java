/**
 * 
 */
package com.aspose.cloud.pdf;
//import java.util.List;

/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single text item
/// </summary>
public class Color
{
    public Color() { }
    public Color(int a, int r, int g, int b)
    {
        A = a;
        B = b;
        R = r;
        G = g;
    }

//    public List<LinkResponse> Links;
    private int A;
    private int B;
    private int G;
    private int R;

    public int getA(){return A;}
    public int getB(){return B;}
    public int getG(){return G;}
    public int getR(){return R;}
    

}