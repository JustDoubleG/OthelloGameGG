
/**
 * Abstract class Piece - write a description of the class here
 */

//Author: Sai Chand Reddy Bussu
//Modified on 11/05/2018
public abstract class SquareBox
{
    // instance variables - replace the example below with your own
    protected String pieceName;
   
    public SquareBox(String pieceName)
    {
        this.pieceName = pieceName;
    }
   
    public String toString()
    {
        return pieceName;
    }
}

