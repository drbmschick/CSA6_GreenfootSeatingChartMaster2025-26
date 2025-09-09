import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KhoslaSamreen class represents Samreen’s avatar in the AP CSA seating chart.
 * Adapted from KilgoreTrout.
 */
public class KhoslaSamreen extends Student implements SpecialInterestOrHobby
{
    /**
     * Constructor with parameters.
     */
    public KhoslaSamreen(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = f.toLowerCase() + l.toLowerCase() + ".jpg";
        standingFile = "samreenkhosla-standing.jpg";
        soundFile = f.toLowerCase() + l.toLowerCase() + ".wav";
        setImage(portraitFile);
        sitting = true;
    }

    /**
     * Default constructor — sets Samreen in the right seat.
     */
    public KhoslaSamreen() {
    firstName = "Samreen";
    lastName = "Khosla";
    mySeatX = 20;   
    mySeatY = 10;   

    portraitFile = "samreenkhosla.jpg";
    standingFile = "samreenkhosla-standing.jpg";
    soundFile = "samreenkhosla.wav";

    setImage(portraitFile);

    GreenfootImage img = getImage();
    img.scale(55, 65);

    sitting = true;
}


    /**
     * Act method — called when you click Samreen.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            sitting = false;
            setImage(standingFile);
            GreenfootImage standImg = getImage();
            standImg.scale(100, 100);

            System.out.println("Hi, My name is Samreen and I like to read.");
            getName();
            sayName(soundFile);
            Greenfoot.playSound(soundFile);

            spin();           // custom animation
            returnToSeat();   // go back to seat
        }
    }

    /**
     * Prints name to console.
     */
    public void getName() {
        System.out.println("My name is " + firstName + " " + lastName);
    }

    /**
     * Custom animation: spin in place.
     */
    public void spin() {
        for (int i = 0; i < 36; i++) {
            turn(10);
            Greenfoot.delay(5);
        }
        setRotation(0);
    }

    /**
     * Return to seat with portrait reset & scaled.
     */
    public void returnToSeat() {
    setLocation(mySeatX, mySeatY);   // back to seat
    setImage(portraitFile);          // reset portrait

    GreenfootImage portImg = getImage();
    portImg.scale(55, 65);

    sitting = true;
}


    /**
     * Hobby method from the interface.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
}
