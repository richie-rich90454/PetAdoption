public class Application{
    private Adopter adopter;
    private Pet pet;
    private boolean approved;
    public  Application(Adopter adopter, Pet pet){
        this.adopter=adopter;
        this.pet=pet;
    }
    public void setApproved(boolean approved){
        this.approved=approved;
    }
    public boolean isApproved(){
        return approved;
    }
    public Pet getPet(){
        return pet;
    }
    public Adopter getAdopter(){
        return adopter;
    }
    public boolean equals(Application application){
        return pet.equals(application.pet)&&adopter.equals(application.adopter);
    }
}
