import java.util.ArrayList;

public class Adopter{
    private String name;
    private ArrayList<Pet> adoptedPets;
    private int age;
    private String homeType;
    private String password;
    public Adopter(String name, int age, String homeType, String password){
        this.name=name;
        this.age=age;
        this.homeType=homeType;
        this.password=password;
        this.adoptedPets=new ArrayList<Pet>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<Pet> getAdoptedPets(){
        return this.adoptedPets;
    }
    public int getAge(){
        return age;
    }
    public String getHomeType(){
        return homeType;
    }
    public String getPassword(){
        return password;
    }
    public void addPet(Pet pet){
        this.adoptedPets.add(pet);
    }
    public Application createApplication(Pet petChosen){
        return new Application(this, petChosen);
    }
    public boolean equals(Adopter adopter){
        return this.adoptedPets.equals(adopter.adoptedPets)&&this.age==adopter.age&&this.homeType.equals(adopter.homeType)&&this.password.equals(adopter.password);
    }
    public String toString(){
        return name+" (age "+age+") with a home type of "+homeType+" with "+(adoptedPets.size()+1)+" pets adopted";
    }
}
