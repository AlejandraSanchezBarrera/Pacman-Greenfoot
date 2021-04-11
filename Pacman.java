import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends MovingActor
{
    private int currentImage;
    private int counter;

    public Pacman()
    {
        setImage("images/pacman1.png");
        length=getImage().getWidth();
    }

    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveMouth();
        handleDirection();
    }   
    
    public void handleDirection(){
        if(Greenfoot.isKeyDown("right")){
            move(Direction.RIGHT);
        }else if(Greenfoot.isKeyDown("left")){
            move(Direction.LEFT);
        }else if(Greenfoot.isKeyDown("down")){
            move(Direction.DOWN);
        }else if(Greenfoot.isKeyDown("up")){
            move(Direction.UP);
        }
    }

    public void moveMouth(){
        if(counter == 0){
            if(currentImage == 0){
                setImage("images/pacman1.png");
            } else if (currentImage == 1){
                setImage("images/pacman2.png");
            }
            currentImage = (currentImage + 1) % 2;
        }
        counter = (counter + 1)%10;
    }
}