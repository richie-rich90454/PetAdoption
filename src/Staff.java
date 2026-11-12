import java.util.ArrayList;

public class Staff{
    private String name;
    private ArrayList<Pet> pets;
    private String password;
    private ArrayList<Application> applications;
    public Staff(String name, String password){
        this.name=name;
        this.password=password;
        this.pets=new ArrayList<Pet>();
        this.applications=new ArrayList<Application>();
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public boolean approveAdoption(Application application, boolean approved, ArrayList<Application> allApplications){
        applications=allApplications;
        if (approved&&application.isAllowedToAdopt()){
            application.setApprovalStatus("APPROVED");
            this.changePetStatus(application.getPet(), application.getPet().isVaccinated(), true);
            application.getAdopter().addPet(application.getPet());
            System.out.println("Application approved.");
            return true;
        }
        else if (!approved&&application.isAllowedToAdopt()){
            application.setApprovalStatus("REJECTED");
            System.out.println("Application rejected by staff.");
            return true;
        }
        //auto-reject other applications for the same pet once this one is done
        for (Application otherApplication: applications){
            if (!otherApplication.equals(application)&&otherApplication.getPet().equals(application.getPet())&&otherApplication.getApprovalStatus().equals("PENDING")){
                otherApplication.setApprovalStatus("REJECTED");
                System.out.println("Conflicting application from "+otherApplication.getAdopter().getName()+" automatically rejected.");
            }
        }
        application.setApprovalStatus("REJECTED");
        return false;
    }
    public void changePetStatus(Pet pet, boolean vaccinated, boolean adopted){
        pet.setVaccinated(vaccinated);
        pet.setAdopted(adopted);
    }
    public void addPets(ArrayList<Pet> pets){
        this.pets.addAll(pets);
    }
    public ArrayList<Pet> getPets(){
        return pets;
    }
}
