import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class KhoslaSamreen extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KilgoreTrout class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public KhoslaSamreen(String f, String l, int r, int s) {
    firstName=f;
    lastName=l;
    mySeatX=r;
    mySeatY=s;
    portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";
    standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
    soundFile=f.toLowerCase()+l.toLowerCase()+".wav";
    setImage(portraitFile);
    sitting=true;
}

public KhoslaSamreen() {
    firstName="Samreen";
    lastName="Khosla";
    mySeatX=3;   // choose your seat row
    mySeatY=2;   // choose your seat column
    portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
    standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
    soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
    setImage(portraitFile);
    sitting=true;
}

    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() {
    if(Greenfoot.mouseClicked(this)){
        sitting=false;
        setImage(standingFile);
        System.out.println("");
        getName();
        sayName(soundFile);

        myHobby("I love concerts and baking!");
        spinInPlace();   // your custom animation
        sitDown();
    }
}

    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */

   
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void spinInPlace() {
    for(int i=0; i<36; i++){
        turn(10);
        Greenfoot.delay(5);
    }
    setRotation(0);
}

     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}