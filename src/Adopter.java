import java.util.ArrayList;

public class Adopter{
    private ArrayList<Pet> adoptedPets;
    private int age;
    private String homeType;
    private String password;
    public Adopter(int age, String homeType, String password){
        this.age=age;
        this.homeType=homeType;
        this.password=password;
        this.adoptedPets=new ArrayList<>();
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
}
