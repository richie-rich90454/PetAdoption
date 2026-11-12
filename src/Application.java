public class Application{
    private Adopter adopter;
    private Pet pet;
    private String approvalStatus;
    public Application(Adopter adopter, Pet pet){
        this.adopter=adopter;
        this.pet=pet;
        approvalStatus="PENDING";
    }
    public void setApprovalStatus(String approvalStatus){
        this.approvalStatus=approvalStatus;
    }
    public String getApprovalStatus(){
        return approvalStatus;
    }
    public Pet getPet(){
        return pet;
    }
    public Adopter getAdopter(){
        return adopter;
    }
    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null||object.getClass()!=this.getClass()){
            return false;
        }
        Application otherApplication=(Application)object;
        return (pet.equals(otherApplication.pet)&&adopter.equals(otherApplication.adopter));
    }
    public String toString(){
        String adopterMessage="["+approvalStatus+"] adopter "+adopter.toString()+" wants to adopt pet "+pet.getName()+" (ID "+pet.getId()+", age "+pet.getAge()+", "+pet.getType();
        if (pet.isVaccinated()){
            adopterMessage+=", is vaccinated";
        }
        else{
            adopterMessage+=", is not vaccinated";
        }
        if (pet.isAdopted()){
            adopterMessage+=", is adopted";
        }
        else{
            adopterMessage+=", is not adopted";
        }
        adopterMessage+=")";
        return adopterMessage;
    }
    public int getRecommendationScore(){
        int recommendationScore=0;//0-50=not recommend, 50-75=recommend with range 0-75
        if (adopter.getAdoptedPets().size()>=1){
            recommendationScore+=25;
        }
        else{
            recommendationScore+=10;
        }
        if (adopter.getHomeType().toLowerCase().trim().equals("villa")||adopter.getHomeType().toLowerCase().trim().equals("apartment")||adopter.getHomeType().toLowerCase().trim().equals("townhouse")){
            recommendationScore+=25;
        }
        else{
            recommendationScore+=10;
        }
        if (adopter.getAge()<=35&&adopter.getAge()>=18){
            recommendationScore+=25;
        }
        else if (adopter.getAge()>35){
            recommendationScore+=15;
        }
        else{
            recommendationScore+=5;
        }
        return recommendationScore;
    }
    public boolean isAllowedToAdopt(){
        if (pet.isVaccinated()){
            if (!pet.isAdopted()){
                if (getRecommendationScore()>=50){
                    return true;
                }
            }
        }
        return false;
    }
}
