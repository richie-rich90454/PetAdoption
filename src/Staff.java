import java.util.ArrayList;

public class Staff{
    private String name;
    private ArrayList<Pet> pets;
    private String password;
    private ArrayList<Adopter> adopters;
    private ArrayList<Application> applications;
    public Staff(String name, String password){
        this.name=name;
        this.password=password;
        this.pets=new ArrayList<Pet>();
        this.adopters=new ArrayList<Adopter>();
        this.applications=new ArrayList<Application>();
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public boolean approveAdoption(Application application, boolean approved){
        if (approved&&application.isAllowedToAdopt()){
            application.setApprovalStatus("APPROVED");
            this.changePetStatus(application.getPet(), application.getPet().isVaccinated(), true);
            application.getAdopter().addPet(application.getPet());
            Main.allPendingApplications.remove(application);
            return true;
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
