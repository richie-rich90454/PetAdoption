/*
    The Main class of the overall project that has the entrypoint main function that is the entrypoint for user input, creating Pet, Adopter, Application, and Staff objects, and calling instance methods from those objects or static methods from the Input class (for input handling and validation) to make the program able to start and be functional
    By Richard Jiang
    2026/11/13
 */
/*
    Reflection Questions:
    1.	Design Insight: Which rule was hardest to encode in code — and why? How did you ensure it was enforced consistently?
        The rule that was the hardest to follow is the requirement of encapsulation, and this project does indeed not perfectly follow it, as it uses a significant number of call-by-reference operations, such as the passing around of the ArrayLists for the contents to be modified in other methods through changing the object at the passed in memory address. This rule is not perfectly followed and is hence the hardest to follow because call-by-reference does dramatically simplify the difficulty and the amount of code required in the program for the code to be functional in the given short development time, so it is essentially a tradeoff between development requirement time and the security and encapsulation of the code. The project would be much harder to achieve and fulfill if call-by-reference was not used, and it would likely take multitudes more time and effort that would not be applicable given the time limit. However, in terms of other places, encapsulation is enforced rather well, especially with primitive data types, and they are often enforced with limiting the ability of setters to update values (by directly not implementing some setter methods to make certain fields/instance methods effectively immutable outside of the class it has) or guarding the acceptable values assigned with the setter methods, which makes those data fields have controlled access and controlled mutation.
    2.	Encapsulation Check: Name one piece of data that only one class should control. How did you prevent other classes/users from changing it directly?
        One piece of data that only one class should control is the name and age values of the Pet and Adopter classes, as that is critical (especially the latter) in determining the viability of adoption and is a crucial determining factor in the recommendation algorithm, so its mutation should only be handled by the respective classes to prevent issues. To address this requirement, the name and age values are set to be immutable (only getter methods created, and there are no setter methods) so that the values would not be changeable by outside classes through methods and is only changeable within the class.
    3.	Trust Through Design: If a staff member or adopter makes a mistake (e.g., tries to adopt an unvaccinated pet), how does your system respond? Why is this kind of “fail-safe” behavior important in real software?
        Cases like the adoption of an unvaccinated pet are initially prevented by not displaying unadoptable (from reasons like them being already adopted or being unvaccinated) pets in the user select menu, so the user would not know of them and would likely not be able to enter in the ID of them to adopt them. However, even if the user entered an ID of the non-adoptable pet, the system would refuse the application submission and not create an application as well as throw the reason to the user. Even if some unfound error allows the adoption of such pets and has an application filed, the staff would not be able to approve the application with the system throwing the reason. These multiple fail-safe safeguards ensure the software is fully versatile in all cases, and it could almost fully prevent such issues from ever occuring. Similar measures are also implemented for other situations as well.
    4.	Teamwork & Collaboration (For Pair Work): How did your group divide the work and integrate your code? Describe one challenge you faced while merging your classes or resolving conflicts, and how you resolved it together.
        This project is developed by myself only, so this question is not applicable for my case. However, I did mostly follow conventional commits and ensure all code is retracable and well-reviewed.
 */
/*
    Contribution Log
    Since this is an individual project, Richard solely completed all classes, implemented all methods, wrote the unit tests, created the UML diagrams, and created the demo video.
 */
/*
    See TestResults.txt for the test case output (all test outputs are as expected)
    See SampleOutput.txt for an example flow and execution of the program
 */
import java.util.ArrayList;
public class Main{
    public static ArrayList<Application> allApplications=new ArrayList<Application>();
    public static void firstUnitTest(){
        //First Unit Test
        System.out.println("First unit test");
        ArrayList<Pet> pets=new ArrayList<Pet>();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
        //shows that the toString method works=>deduced that the getters and setters also work, as teh toString method depends on the getter and setter methods and proves that the constructor works as intended to initialize all values
        for (Pet pet:pets){
            //proven to work given:
            // ID: 1001	Name: Karel	Age: 8	Type: German Shepard DogVaccinated: false	Adopted: false
            //ID: 1002	Name: William	Age: 4	Type: Labrador DogVaccinated: false	Adopted: false
            //ID: 1003	Name: Joanna	Age: 5	Type: Brown CatVaccinated: false	Adopted: false
            System.out.println(pet);
        }
        //proves the setter methods work as intended to update the values
        pets.get(0).setVaccinated(true);
        pets.get(0).setAdopted(true);
        System.out.println("\nAfter setter method setting vaccination and adoption: ");
        System.out.println(pets.get(0));
    }
    public static void secondUnitTest(){
        System.out.println("Second unit test");
        ArrayList<Pet> pets=new ArrayList<>();
        pets.add(new Pet("Karel", 8, "German Shepard Dog"));
        pets.add(new Pet("William", 4, "Labrador Dog"));
        pets.add(new Pet("Joanna", 5, "Brown Cat"));
        Staff defaultStaff=new Staff("Staff", "StaffPassword");
        defaultStaff.addPets(pets);
        Adopter johnAdopter=new Adopter("John", 45, "Villa", "johnplayswhat");
        Adopter fredAdopter=new Adopter("Fred", 19, "Apartment", "fredplayswhat");
        Adopter georgeAdopter=new Adopter("George", 15, "Tent", "georgeplayswhat");
        johnAdopter.addPet(pets.get(1));
        johnAdopter.addPet(pets.get(2));
        //same output as the output in the first unit test, which suggests that the adopter is able to hold/adopt animals properly
        for (Pet pet:johnAdopter.getAdoptedPets()){
            System.out.println(pet);
        }
        Application newApplicationCreated=johnAdopter.createApplication(pets.get(0));
        //proves all getters and setters in the related classes (the Adopter and the Pet class as well as the Application class) work given by output:
        //adopter John (age 45) with a home type of Villa with 2 pets adopted wants to adopt pet Karel (ID 1001, age 8, German Shepard Dog, is not vaccinated, is not adopted)
        System.out.println(newApplicationCreated);
        //expect false because the pet is not vaccinated
        System.out.println(newApplicationCreated.isAllowedToAdopt());
        defaultStaff.changePetStatus(pets.get(0), true, false);
        //expect true because the pet is vaccinated and the adopter is eligible
        System.out.println(newApplicationCreated.isAllowedToAdopt());
        Application georgeApplication=georgeAdopter.createApplication(pets.get(0));
        //expect false because the person is a minor and hence the points would not qualify
        System.out.println(georgeApplication.isAllowedToAdopt());
        //test the staff fail-safe (expect false because staff cannot force approve an ineligible application)
        ArrayList<Application> testApplications=new ArrayList<Application>();
        testApplications.add(georgeApplication);
        System.out.println(defaultStaff.approveAdoption(georgeApplication, true, testApplications));
        //expect REJECTED because the fail-safe blocked it
        System.out.println(georgeApplication.getApprovalStatus());
        //test competing applications (expect true because John's application is valid and gets approved)
        Application fredApplication=fredAdopter.createApplication(pets.get(0));
        testApplications.add(fredApplication);
        testApplications.add(newApplicationCreated);
        System.out.println(defaultStaff.approveAdoption(newApplicationCreated, true, testApplications));
        //expect APPROVED for John
        System.out.println(newApplicationCreated.getApprovalStatus());
        //expect REJECTED for Fred because John already adopted the pet (competing application)
        System.out.println(fredApplication.getApprovalStatus());
        //expect true because the pet is now adopted
        System.out.println(pets.get(0).isAdopted());
    }
    public static void thirdUnitTest(){
        System.out.println("Third unit test");
        Pet firstPet=new Pet("Karel", 8, "German Shepard Dog");
        Pet secondPet=new Pet("Joanna", 5, "Brown Cat");
        Adopter johnAdopter=new Adopter("John", 45, "Villa", "johnplayswhat");
        Adopter fredAdopter=new Adopter("Fred", 19, "Apartment", "fredplayswhat");
        //test the equals methods for Pet and Adopter
        //expect true because it is the exact same object reference
        System.out.println(firstPet.equals(firstPet));
        //expect false because they have different names, ages, types, and IDs
        System.out.println(firstPet.equals(secondPet));
        //expect true because it is the exact same object reference
        System.out.println(johnAdopter.equals(johnAdopter));
        //expect false because they have different names, ages, home types, and passwords
        System.out.println(johnAdopter.equals(fredAdopter));
        //test the equals method for Application
        Application johnApplication=johnAdopter.createApplication(firstPet);
        Application newJohnApplication=johnAdopter.createApplication(firstPet);
        //expect true because they belong to the same adopter and are for the same pet
        System.out.println(johnApplication.equals(newJohnApplication));
        //test staff manually rejecting a valid application
        Staff defaultStaff=new Staff("Staff", "StaffPassword");
        ArrayList<Application> testApplications=new ArrayList<Application>();
        defaultStaff.changePetStatus(firstPet, true, false);
        testApplications.add(johnApplication);
        //expect true because the method executes successfully
        System.out.println(defaultStaff.approveAdoption(johnApplication, false, testApplications));
        //expect REJECTED because staff manually rejected it
        System.out.println(johnApplication.getApprovalStatus());
        //expect false because the pet was not adopted
        System.out.println(firstPet.isAdopted());
        //test applying for an already adopted pet
        secondPet.setAdopted(true);
        Application fredApplication=fredAdopter.createApplication(secondPet);
        //expect false because the pet is already adopted
        System.out.println(fredApplication.isAllowedToAdopt());
    }
    public static void fourthUnitTest(){
        System.out.println("Fourth unit test");
        Adopter maximumScoreAdopter=new Adopter("Maximum", 35, "Townhouse", "maximumplayswhat");
        maximumScoreAdopter.addPet(new Pet("First", 1, "Dog"));
        Adopter minimumScoreAdopter=new Adopter("Minimum", 17, "House", "minimumplayswhat");
        Pet testPet=new Pet("Karel", 8, "German Shepard Dog");
        testPet.setVaccinated(true);
        Application maximumApplication=maximumScoreAdopter.createApplication(testPet);
        Application minimumApplication=minimumScoreAdopter.createApplication(testPet);
        //expect 75 (25 for having a pet +25 for townhouse +25 for age 18-35)
        System.out.println(maximumApplication.getRecommendationScore());
        //expect 25 (10 for no pets +10 for house +5 for age under 18)
        System.out.println(minimumApplication.getRecommendationScore());
        Staff defaultStaff=new Staff("Staff", "StaffPassword");
        ArrayList<Application> testApplications=new ArrayList<Application>();
        testApplications.add(maximumApplication);
        testApplications.add(minimumApplication);
        //staff tries to approve the minimum score adopter, and this expects false because score is below 50
        System.out.println(defaultStaff.approveAdoption(minimumApplication, true, testApplications));
        //expect REJECTED because the fail-safe blocked it
        System.out.println(minimumApplication.getApprovalStatus());
        //staff approves the maximum score adopter
        //expect true because score is above 50 and pet is vaccinated
        System.out.println(defaultStaff.approveAdoption(maximumApplication, true, testApplications));
        //expect APPROVED because of the previous approveAdoption method
        System.out.println(maximumApplication.getApprovalStatus());
        //expect true because pet is now adopted
        System.out.println(testPet.isAdopted());
    }
    public static void staffActions(Staff defaultStaff){
        while (true){
            System.out.print("Please enter your password (enter \"quit\" to exit to login): ");
            String userPassword=Input.safeStringInput();
            if (userPassword.toLowerCase().trim().equals("quit")){
                return;
            }
            if (userPassword.equals(defaultStaff.getPassword())){
                break;
            }
            System.out.println("Wrong password. Please enter again: ");
        }
        System.out.println("Welcome, Shelter Staff!");
        while (true){
            System.out.println("\n\n\n[1] View all pets");
            System.out.println("[2] Vaccinate a pet");
            System.out.println("[3] Process adoption application");
            System.out.println("[4] Exit to login");
            System.out.print("Choose an option (1-4): ");
            int userChoice=Input.safeIntInput(1,4);
            System.out.println();
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
                boolean petExists=false;
                for (Pet pet: defaultStaff.getPets()){
                    if (pet.getId()==petID){
                        defaultStaff.changePetStatus(pet, true, pet.isAdopted());
                        System.out.println(pet.getName()+" is vaccinated.");
                        petExists=true;
                        break;
                    }
                }
                if (!petExists){
                    System.out.println("Pet not found and hence not vaccinated.");
                }
            }
            else if (userChoice==3){
                ArrayList<Application> allPendingApplications=new ArrayList<Application>();
                for (Application application: allApplications){
                    if (application.getApprovalStatus().equals("PENDING")){
                        allPendingApplications.add(application);
                    }
                }
                if (allPendingApplications.size()==0){
                    System.out.println("There are no pending applications.");
                    continue;
                }
                System.out.println("There are these pending applications: ");
                for (int i=0;i<allPendingApplications.size();i++){
                    System.out.println("["+(i+1)+"]"+allPendingApplications.get(i));
                }
                System.out.print("Which one do you want to process (enter a number between 1 and "+ allPendingApplications.size()+" where 1 denotes the first application previously printed for instance): ");
                int applicationIndex=Input.safeIntInput(1, allPendingApplications.size())-1;
                System.out.println("Should the application be approved according to the algorithm: "+ allPendingApplications.get(applicationIndex).isAllowedToAdopt());
                System.out.print("Do you want to approve that application (true/false): ");
                boolean approvalStatus=defaultStaff.approveAdoption(allPendingApplications.get(applicationIndex), Input.safeBooleanInput(), allApplications);
                if (!approvalStatus){
                    System.out.println("Not approvable because the pet is not vaccinated or is already adopted.");
                }
            }
        }
    }
    public static void adopterActions(ArrayList<Adopter> adopters, Staff defaultStaff){
        Adopter currentAdopter=null;
        while (true){
            System.out.print("Please enter your username (enter \"quit\" to return to login): ");
            String username=Input.safeStringInput().toLowerCase();
            if (username.toLowerCase().trim().equals("quit")){
                return;
            }
            boolean adopterExists=false;
            for (Adopter adopter: adopters){
                if (adopter.getName().toLowerCase().equals(username)){
                    System.out.print("Please enter your password (enter \"quit\" to return to login): ");
                    String userPassword=Input.safeStringInput();
                    if (userPassword.toLowerCase().trim().equals("quit")){
                        return;
                    }
                    while (!userPassword.equals(adopter.getPassword())){
                        if (userPassword.toLowerCase().trim().equals("quit")){
                            return;
                        }
                        System.out.print("Wrong Password. Please enter again: ");
                        userPassword=Input.safeStringInput();
                    }
                    currentAdopter=adopter;
                    adopterExists=true;
                    break;
                }
            }
            if (adopterExists){
                break;
            }
            System.out.println("Adopter not found.");
        }
        System.out.println("Welcome, "+currentAdopter.getName()+"!");
        while (true){
            System.out.println("\n\n\n[1] View available pets");
            System.out.println("[2] Submit an adoption application");
            System.out.println("[3] Check my application status");
            System.out.println("[4] Exit to login");
            System.out.print("Choose an option (1-4): ");
            int userChoice=Input.safeIntInput(1,4);
            System.out.println();
            if (userChoice==4){
                break;
            }
            else if (userChoice==1){
                for (Pet pet: defaultStaff.getPets()){
                    if (!pet.isAdopted()&&pet.isVaccinated()){
                        System.out.println(pet);
                    }
                }
            }
            else if (userChoice==2){
                for (Pet pet: defaultStaff.getPets()){
                    if (!pet.isAdopted()&&pet.isVaccinated()){
                        System.out.println(pet);
                    }
                }
                System.out.print("Please enter the pet ID of the pet that you intend to adopt: ");
                int petID=Input.safeIntInput();
                boolean petExists=false;
                for (Pet pet: defaultStaff.getPets()){
                    if (pet.getId()==petID){
                        petExists=true;
                        if (!pet.isAdopted()&&pet.isVaccinated()){
                            Application newApplication=currentAdopter.createApplication(pet);
                            boolean hasApplicationBefore=false;
                            for (Application application: allApplications){
                                if (application.getAdopter().equals(currentAdopter)&&application.getPet().equals(pet)&&application.getApprovalStatus().equals("PENDING")){
                                    System.out.println("Cannot submit an application for the same pet twice.");
                                    hasApplicationBefore=true;
                                    break;
                                }
                            }
                            if (!hasApplicationBefore){
                                allApplications.add(newApplication);
                                System.out.println("Application submitted for "+pet.getName()+". Waiting for staff review and approval.");
                            }
                        }
                        else{
                            System.out.println("The pet is not available for adoption because it is not vaccinated or is already adopted.");
                        }
                        break;
                    }
                }
                if (!petExists){
                    System.out.println("Pet does not exist and is hence not adoptable.");
                }
            }
            else if (userChoice==3){
                boolean hasAdoptions=false;
                for (Application application: allApplications){
                    if (application.getAdopter().equals(currentAdopter)){
                        System.out.println(application);
                        hasAdoptions=true;
                    }
                }
                if (!hasAdoptions){
                    System.out.println("You have not adopted any pets before.");
                }
            }
        }
    }
    public static void main(String[] args){
        ArrayList<Pet> pets=new ArrayList<Pet>();
        firstUnitTest();
        secondUnitTest();
        thirdUnitTest();
        fourthUnitTest();
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
                adopterActions(adopters, defaultStaff);
            }
            else if (userRole.equals("quit")){
                return;
            }
        }
    }
}