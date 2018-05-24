public class Crossword
{
  private Square[][] puzzle;

  /* Part (b) */

  public Crossword(boolean[][] blackSquares) {
  
      int num = 1;
      puzzle = new Square[blackSquares.length][blackSquares[0].length];
      for (int r=0; r<blackSquares.length; r++){
          for (int c=0; c<blackSquares[0].length; c++){
              if (blackSquares[r][c]) {
                  puzzle[r][c] = new Square(true, 0);
              } else if (toBeLabeled(r,c,blackSquares)) {
                  puzzle[r][c] = new Square(false, num);
                  num++;
              } else {
                  puzzle[r][c] = new Square(false, 0);
              }
              // Other way to do it is to 'if' toBeLabeled
              // and else is new square, in boolean spot call blacksquares[r][c]
          }
      }
      
  }

  /* Part (a) */

  private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {

          // NEED to do row & col = 0 first, so 'return' can short-circuit
          return ((!blackSquares[r][c]) && (r==0 || c==0 || blackSquares[r-1][c] || blackSquares[r][c-1]));
          
  }

  public Square getSquare(int r, int c) { return puzzle[r][c]; }
}
