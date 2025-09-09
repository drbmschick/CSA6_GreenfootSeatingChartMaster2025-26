import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The IshitaPrasad class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class IshitaPrasad extends Student implements SpecialInterestOrHobby
{
    private GreenfootImage originalPortrait;
    private int originalX;
    private int originalY;

    /**
     * Constructor for the IshitaPrasad class.
     */
    public IshitaPrasad(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = 6;
        mySeatY = 6;
        portraitFile = f.toLowerCase() + l.toLowerCase() + ".jpg";    
        standingFile = f.toLowerCase() + l.toLowerCase() + "-standing.jpg";
        soundFile = f.toLowerCase() + l.toLowerCase() + ".wav";  

        GreenfootImage portrait = new GreenfootImage(portraitFile);
        portrait.scale(portrait.getWidth() / 3, portrait.getHeight() / 3);  
        setImage(portrait);
        originalPortrait = portrait;

        sitting = true;
    }

    /**
     * Default constructor, if you don't pass in a name and seating location
     */
    public IshitaPrasad() {
        firstName = "Ishita";
        lastName = "Prasad";
        mySeatX = 6;
        mySeatY = 6;
        portraitFile = firstName.toLowerCase() + lastName.toLowerCase() + ".jpg";
        standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg";
        soundFile = firstName.toLowerCase() + lastName.toLowerCase() + ".wav";

        GreenfootImage portrait = new GreenfootImage(portraitFile);
        portrait.scale(portrait.getWidth() / 3, portrait.getHeight() / 3);  
        setImage(portrait);
        originalPortrait = portrait;

        sitting = true;
    }
    
    /**
     * Act - called whenever the 'Act' or 'Run' button gets pressed
     */   
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            sitting = false;

            originalX = getX();
            originalY = getY();

            GreenfootImage standing = new GreenfootImage(standingFile);
            standing.scale(standing.getWidth() / 15, standing.getHeight() / 15);  
            setImage(standing);

            System.out.println(""); // blank line for spacing
            getName();
            sayName(soundFile);
            myHobby("I like baking/cooking");
            spinAndJump();

            setLocation(originalX, originalY);
            setImage(originalPortrait);
            sitting = true;
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName() {
        System.out.println("My name is " + firstName + " " + lastName);
    }

    /**
     * Animate the character once the image is clicked
     */
    public void spinAndJump() {
        for (int i = 0; i < 360; i += 15) {
            setRotation(i);
            Greenfoot.delay(5);
        }
        for (int i = 0; i < 3; i++) {
            setLocation(getX(), getY() - 1);
            Greenfoot.delay(5);
            setLocation(getX(), getY() + 1);
            Greenfoot.delay(5);
        }
    }

    /**
     * Implementation of SpecialInterestOrHobby interface
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
}
