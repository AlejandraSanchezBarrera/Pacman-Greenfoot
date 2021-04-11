import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    PacmanLevel1 myWorld;
    int width;
    int height=56;
    int score=0;
    GreenfootImage boardImage;
    GreenfootImage playerImage;
    TextScore textScore;
    
    public void addedToWorld(World w){
        PacmanLevel1 thisWorld=(PacmanLevel1)w;
        width=thisWorld.getWidth();
        height=thisWorld.getScoreAreaHeight();
        boardImage=new GreenfootImage(width,height);
        boardImage.setColor(Color.BLACK);
        setImage(boardImage);
        textScore = new TextScore();
        playerImage = thisWorld.getPlayerImage();
    }
    
    public void addScore(int amount){
        score+=amount;
    }
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        boardImage.clear();
        textScore.drawScore(score);
        boardImage.fillRect(0,25,width,height);
        boardImage.drawImage(textScore, 0, height/2);
    }    
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public void changeScore(int amount){
        score+=amount;
    }
    
    class TextScore extends GreenfootImage{
        public TextScore(){
            super(200,100);
            score = 0;
        }
        
        public void drawScore(int score){
            this.clear();
            Font f = new Font("SansSerif",20);
            Color c = Color.WHITE;
            setFont(f);
            setColor(c);
            drawString("Score: " + score, 20, 20);
        }
    }
}
