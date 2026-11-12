public class Application{
    private Adopter adopter;
    private Pet pet;
    private boolean approved;
    public Application(Adopter adopter, Pet pet){
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
    public String toString(){
        String adopterMessage="adopter "+adopter.toString()+" wants to adopt pet "+pet.getName()+" with ID "+pet.getId()+", an age of "+pet.getAge()+", a type of "+pet.getType();
        if (pet.isVaccinated()){
            adopterMessage+=", and is vaccinated";
        }
        else{
            adopterMessage+=", and is not vaccinated";
        }
        return adopterMessage;
    }
    public boolean adoptOrNotRecommendation(){
        int recommendationIndex=0;//0-50=not recommend, 50-75=conditional, 75-100=recommend
        if (pet.isVaccinated()==false){
            return false;
        }
        if (adopter.getAdoptedPets().size()>=1){
            recommendationIndex+=25;
        }
        else{
            recommendationIndex+=10;
        }
        if (adopter.getHomeType().toLowerCase().trim().equals("villa")||adopter.getHomeType().toLowerCase().trim().equals("apartment")||adopter.getHomeType().toLowerCase().trim().equals("townhouse")){
            recommendationIndex+=25;
        }
        else{
            recommendationIndex+=10;
        }
        if (adopter.getAge()<=35&&adopter.getAge()>=18){
            recommendationIndex+=25;
        }
        else if (adopter.getAge()>=35){
            recommendationIndex+=15;
        }
        else{
            recommendationIndex+=5;
        }
        return false;
    }
}
