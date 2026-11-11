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
}
