package Othello;

import java.awt.Color;

//Author: Sai Chand Reddy Bussu
//Modified on 11/05/2018
public abstract class SquareBox
{
  
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

