import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static ArrayList<Application> allPendingApplications=new ArrayList<Application>();
    public static void firstUnitTest(){
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
    }
    public static void secondUnitTest(){
        ArrayList<Pet> pets=new ArrayList<>();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
        Staff defaultStaff=new Staff("Staff", "StaffPassword");
        defaultStaff.addPets(pets);
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
    }
    public static void staffActions(Staff defaultStaff){
        while (true){
            System.out.print("Please enter your password: ");
            String userPassword=Input.safeStringInput();
            if (userPassword.equals(defaultStaff.getPassword())){
                break;
            }
        }
        System.out.println("Welcome, Shelter Staff!\n");
        while (true){
            System.out.println("[1] View all pets");
            System.out.println("[2] Vaccinate a pet");
            System.out.println("[3] Process adoption application");
            System.out.println("[4] Exit to login");
            System.out.print("Choose an option (1-4): ");
            int userChoice=Input.safeIntInput(1,4);
            if(userChoice==4){
                break;
            }
            else if (userChoice==1){
                for (Pet pet: defaultStaff.getPets()){
                    System.out.println(pet);
                }
            }
            else if (userChoice==2){
                for (Pet pet: defaultStaff.getPets()){
                    System.out.println(pet);
                }
                System.out.print("Please enter the pet ID of the pet that you intend to vaccinate: ");
                int petID=Input.safeIntInput();
                for (Pet pet: defaultStaff.getPets()){
                    if (pet.getId()==petID){
                        defaultStaff.changePetStatus(pet, true, false);
                        System.out.println(pet.getName()+" is vaccinated.");
                        break;
                    }
                }
            }
            else if (userChoice==3){
                System.out.println("There are these pending applications");
                for (Application application: allPendingApplications){
                    System.out.print(application);
                }
                if (allPendingApplications.size()==0){
                    System.out.println("There are no pending applications.");
                    continue;
                }
                System.out.print("Which one do you want to process (enter a number between 1 and "+allPendingApplications.size()+" where 1 denotes the first application previously printed for instance): ");
                int applicationIndex=Input.safeIntInput(1, allPendingApplications.size())-1;
                System.out.println("Should the application be approved according to the algorithm: "+allPendingApplications.get(applicationIndex).isAllowedToAdopt());
                System.out.print("Do you want to approve that application (true/false): ");
                boolean approvalStatus=defaultStaff.approveAdoption(allPendingApplications.get(applicationIndex), Input.safeBooleanInput());
                if (!approvalStatus){
                    System.out.println("Not approvable because the animal is not vaccinated and/or is already adopted.");
                }
            }
        }
    }
    public static void adopterActions(ArrayList<Adopter> adopters){
        while (true){
            System.out.print("Please enter your username: ");
            String username=Input.safeStringInput().toLowerCase();
            for (Adopter adopter: adopters){
                if (adopter.getName().toLowerCase().equals(username)){
                    System.out.print("Please enter your password: ");
                    String userPassword=Input.safeStringInput();
                    while (!userPassword.equals(adopter.getPassword())){
                        System.out.print("Wrong Password. Please enter again: ");
                        userPassword=Input.safeStringInput();
                    }
                }
            }
            System.out.print("Adopter not found.");
        }
    }
    public static void main(String[] arg){
        ArrayList<Pet> pets=new ArrayList<Pet>();
//        firstUnitTest();
//        secondUnitTest();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
        Staff defaultStaff=new Staff("Staff", "StaffPassword");
        defaultStaff.addPets(pets);
        ArrayList<Adopter> adopters=new ArrayList<Adopter>();
        adopters.add(new Adopter("John", 45, "Villa", "johnplayswhat"));
        adopters.add(new Adopter("Fred", 19, "Apartment", "fredplayswhat"));
        adopters.get(0).addPet(pets.get(1));
        adopters.get(1).addPet(pets.get(2));
        System.out.println("==========\nPET ADOPTION CENTER\n==========");
        while(true){
            System.out.println("Login or switch roles at any time.");
            System.out.print("Enter role (staff/adopter/quit): ");
            String userRole=Input.safeStringInput().toLowerCase();
            if (userRole.equals("staff")){
                staffActions(defaultStaff);
            }
            else if (userRole.equals("adopter")){
                adopterActions(adopters);
            }
            else if (userRole.equals("quit")){
                return;
            }
        }
    }
}