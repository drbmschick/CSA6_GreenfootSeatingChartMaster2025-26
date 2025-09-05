import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The EngelbertsonSpencer class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class EngelbertsonSpencer extends Student implements SpecialInterestOrHobby
{
    private ArrayList<Student> miniMes = new ArrayList<Student>();
    private boolean isClickable = true;
    /**
     * Constructor for the EngelbertsonSpencer class.
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
    public EngelbertsonSpencer(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public EngelbertsonSpencer(boolean isOriginal) {
        if (!isOriginal){
            isClickable = false;
        }
        firstName="Spencer";
        lastName="Engelbertson";
        mySeatX=2;
        mySeatY=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       if (isOriginal){
           portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       } else{
           portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       }
       standingFile= firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the EngelbertsonSpencer actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this) && isClickable){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like sculpting");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This is a local method specific to the EngelbertsonSpencer class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        int currentMe = 0;
        for (int i = getX(); i >= 0; i--){
            setLocation(i, getY());
            Greenfoot.delay(10);
        }
        for (int i = getY(); i >= 0; i--){
            setLocation(getX(), i);
            Greenfoot.delay(10);
        }
        int currentStep = 0;
        // this loop serves to create each of the mini mes around myself kind of in an backwards L shape
        for (int i=1; i<=13; i++){
                boolean hitBottom = false; // this variable checks that the the mini mes have completed the adjacent vertical column
                // this loop runs 13 times and accounts for each enclosing set of images
                // j <= 1 + 2i accounts for the growing amount of pictures as we get further out on images
                for (int j = 0; j < 1 + 2*i; j++){
                    EngelbertsonSpencer newMe = new EngelbertsonSpencer(false);
                    miniMes.add(newMe);
                    if (!hitBottom){
                        // while the bottom is not hit draw an image with each image being 1 unit below the last
                        getWorld().addObject(newMe, currentStep+1, j);
                    } else{
                        // if we have hit the bottom we move left towards the edge with each image
                        getWorld().addObject(newMe, currentStep+1-(j-i), currentStep+1);
                    }
                    if (newMe.getY() > currentStep && hitBottom == false){
                        hitBottom = true;
                    }
                    Greenfoot.delay(2);
                }
                currentStep++;
        }
        Greenfoot.delay(70);
        //delete all the images that are not the original
        for (int i = 0; i < miniMes.size(); i++){
            if (miniMes.get(i) != null){
                getWorld().removeObject(miniMes.get(i));
                i--;
            }
            i++;
        }
        
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
