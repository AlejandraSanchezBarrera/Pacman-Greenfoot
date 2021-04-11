import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanLevel1 extends World
{
    String[] textMap={
        "***********",
        "*.........*",
        "*P        *",
        "*         *",
        "*  ** **  *",
        "*  *   *  *",
        " / * B * / ",
        "   *   *   ",
        "*  *   *  *",
        "*  *****  *",
        "*    C    *",
        "*         *",
        "*.........*",
        "***********",
    };
    
    Scoreboard sb;
    int scoreAreaHeight = 60;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
   public PacmanLevel1()
   {    
       // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(792, 773, 1); 
       drawMap();
       sb=new Scoreboard();
       addObject(sb,getWidth()/2,15);
   }
   
   public void addScore(int amount){
       sb.addScore(amount);
   }
   
   public int getAdjustedHeight(){
       return getHeight()-scoreAreaHeight;
   }
   
   public int getScoreAreaHeight(){
       return scoreAreaHeight;
   }
   
   public GreenfootImage getPlayerImage(){
       Pacman p = new Pacman();
       return p.getImage();
   }
   
   public void changeScore(int amount){
       sb.changeScore(amount);
   }
   
   private void drawMap(){
            for(int i=0;i<textMap.length;i++){
                String mapLine=textMap[i];
                for(int j=0;j<mapLine.length();j++){
                    char mapChar=mapLine.charAt(j); 
                    int y=i*56+28;
                    int x=j*72+36;
                    switch(mapChar){
                        case '*':
                            addObject(new Wall(), x, y);
                            break;
                        case '.':
                            addObject(new Pill1(), x, y);
                            break;
                        case '/':
                            addObject(new Pill2(),x,y+27);
                            break;
                        case 'P':
                            addObject(new Pacman(),x+7,y+14);
                            break;
                        case 'B':
                            addObject(new Banana(),x,y+25);
                            break;
                        case 'C':
                            addObject(new Cherries(),x,y+20);
                            break;
                        default: 
                            break;
                    }
            }
        }
    }
}