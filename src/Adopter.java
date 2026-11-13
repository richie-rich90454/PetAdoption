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
    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null||object.getClass()!=this.getClass()){
            return false;
        }
        Adopter otherAdopter=(Adopter) object;
        return otherAdopter.name.equals(this.name)&&otherAdopter.getAdoptedPets().equals(this.adoptedPets)&&otherAdopter.age==this.age&&otherAdopter.homeType.equals(this.homeType)&&otherAdopter.password.equals(this.password);
    }
    public String toString(){
        return name+" (age "+age+") with a home type of "+homeType+" with "+adoptedPets.size()+" pets adopted";
    }
}
