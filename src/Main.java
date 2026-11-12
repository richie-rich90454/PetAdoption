import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] arg){
//        //First Unit Test
        ArrayList<Pet> pets=new ArrayList<Pet>();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
//        //shows that the toString method works=>deduced that the getters and setters also work, as teh toString method depends on the getter and setter methods and proves that the constructor works as intended to initialize all values
//        for (Pet pet:pets){
//            //proven to work given:
//            // ID: 1001	Name: Karel	Age: 8	Type: German Shepard DogVaccinated: false	Adopted: false
//            //ID: 1002	Name: William	Age: 4	Type: Labrador DogVaccinated: false	Adopted: false
//            //ID: 1003	Name: Joanna	Age: 5	Type: Brown CatVaccinated: false	Adopted: false
//            System.out.println(pet);
//        }
        //Second Unit Test
        Adopter johnAdopter=new Adopter("John", 45, "Villa", "johnplayswhat");
        Adopter fredAdopter=new Adopter("Fred", 19, "Apartment", "fredplayswhat");
        johnAdopter.addPet(pets.get(1));
        johnAdopter.addPet(pets.get(2));
        //same output as the output in the first unit test, which suggests that the adopter is able to hold/adopt animals properly
//        for (Pet pet:johnAdopter.getAdoptedPets()){
//            System.out.println(pet);
//        }
//        Application newApplicationCreated=johnAdopter.createApplication(pets.get(0));
        //proves all getters and setters in the related classes (the Adopter and the Pet class as well as the Application class) work given by output:
            //ID: 1002	Name: William	Age: 4	Type: Labrador DogVaccinated: false	Adopted: false
            //ID: 1003	Name: Joanna	Age: 5	Type: Brown CatVaccinated: false	Adopted: false
            //adopter John (age 45) with a home type of Villa with 3 pets adopted wants to adopt pet Karel with ID 1001, an age of 8, a type of German Shepard Dog, and is not vaccinated
//        System.out.println(newApplicationCreated);
//        System.out.println("==========\nPET ADOPTION CENTER\n==========");
//        Scanner input=new Scanner(System.in);
//        while(true){
//            System.out.println("Login or switch roles at any time.");
//            System.out.print("Enter role (staff/adopter/quit): ");
//            String userRole=input.nextLine().trim().toLowerCase();
//            if (userRole.equals("staff")){
//                System.out.println("Welcome, Shelter Staff!\n");
//                System.out.println("[1] View all pets");
//                System.out.println("[2] Vaccinate a pet");
//                System.out.println("[3] Process adoption application");
//                System.out.println("[4] Exit to login");
//                System.out.print("Choose an option (1-4): ");
//            }
//            else if (userRole.equals("adopter")){
//
//            }
//            else if (userRole.equals("quit")){
//                return;
//            }
//        }
    }
}