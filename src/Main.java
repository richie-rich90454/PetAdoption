import java.util.ArrayList;

public class Main{
    public static void main(String[] arg){
        //First Unit Test
        ArrayList<Pet> pets=new ArrayList<Pet>();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
        //shows that the toString method works=>deduced that the getters and setters also work, as teh toString method depends on the getter and setter methods and proves that the constructor works as intended to initialize all values
        for (Pet pet:pets){
            System.out.println(pet);
        }
    }
}