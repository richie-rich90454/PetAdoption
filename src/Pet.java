public class Pet {
    private String name;
    private int age;
    private String type;
    private boolean vaccinated;
    private boolean adopted;
    private int id;
    private static int currentID=1000;
    public Pet(String name, int age, String type){
        currentID++;
        this.name=name;
        this.age=age;
        this.type=type;
        this.id=currentID;
        this.vaccinated=false;
        this.adopted=false;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getType(){
        return type;
    }
    public boolean isVaccinated(){
        return vaccinated;
    }
    public boolean isAdopted(){
        return adopted;
    }
    public int getId(){
        return id;
    }
    public boolean equals(Pet otherPet){
        return this.name.equals(otherPet.name)&&this.age==otherPet.age&&this.type.equals(otherPet.type)&&this.id==otherPet.id;
    }
    public String toString(){
        String petReturnString="ID: "+this.getId()+"\tName: "+this.getName()+"\tAge: "+this.getAge()+"\tType: "+this.getType();
        petReturnString+="Vaccinated: "+this.isVaccinated()+"\tAdopted: "+this.isAdopted();
        return petReturnString;
    }
    public void setAdopted(boolean adopted){
        this.adopted=adopted;
    }
    public void setVaccinated(boolean vaccinated){
        this.vaccinated=vaccinated;
    }
}
