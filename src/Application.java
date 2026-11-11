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
}
