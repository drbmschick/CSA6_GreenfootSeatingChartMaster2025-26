import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BishalDas class represents you and your seating location in AP CSA
 * 
 * @author Bishal
 * @version 1.0 Aug 29, 2025
 */
public class BishalDas extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the BishalDas class.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     */
    public BishalDas(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = "bishaldas" + ".jpg";    
        standingFile = "bishaldas" + "-standing.jpg";
        soundFile = "kilgoretrout"+ ".wav";  
        setImage(portraitFile);
        sitting = true;
    }
    
    /**
     * Default constructor if no name/seat info is passed in.
     */
    public BishalDas() {
        firstName = "Bishal";
        lastName = "Das";
        mySeatX = 1;
        mySeatY = 1;
        portraitFile = "bishaldas"+".jpg";
        standingFile = "bishaldas" +"-standing.jpg";
        soundFile = "bishaldas" +".wav";
        setImage(portraitFile);
        sitting = true;
    }
    
    /**
     * Act - do whatever BishalDas should do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */   
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            sitting = false;
            setImage(standingFile);
            System.out.println(""); 
            getName();
            sayName(soundFile);
            myHobby("I like to enjoy nature!");
            
            spiralMotion();   // your special animation
           
            sitDown();
        }
    } 
    
    /**
     * Prints the first and last name to the console.
     */
    public void getName() {
        System.out.println("My name is " + firstName + " " + lastName);
    }

    /**
     * Special animation for BishalDas.
     * Currently moves around the classroom in a square.
     */
    public void spiralMotion() {
    int centerX = getWorld().getWidth() / 2;
    int centerY = getWorld().getHeight() / 2;

    double angle = 0;       // starting angle
    double radius = 8;      // starting radius (distance from center)

    while (radius > 0) {
        int x = centerX + (int)(radius * Math.cos(angle));
        int y = centerY + (int)(radius * Math.sin(angle));

        setLocation(x, y);
        Greenfoot.delay(5);

        angle += Math.PI / 8;   // rotate around
        radius -= 0.1;          // slowly move inward
    }

    Greenfoot.delay(20);
    returnToSeat();
}
    
    /**
     * Prints your hobby to the console.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
}
