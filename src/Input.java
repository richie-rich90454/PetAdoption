import java.util.Scanner;
public class Input{
    public static Scanner input=new Scanner(System.in);
    public static int safeIntInput(){
        boolean isValid=false;
        int intInput=0;
        while (!isValid){
            String stringInput=input.nextLine();
            try{
                intInput=Integer.parseInt(stringInput);
                isValid=true;
            }
            catch (NumberFormatException exception){
                System.out.print("Please enter a valid integer input: ");
            }
        }
        return intInput;
    }
    public static String safeStringInput(){
        boolean isValid=false;
        String stringInput=input.nextLine();
        while (!isValid){
            if (!stringInput.trim().equals("")){
                isValid=true;
            }
            else {
                System.out.print("Please enter a valid String input: ");
                stringInput=input.nextLine();
            }
        }
        return stringInput;
    }
    public static String safeStringInput(String inputOptions){
        boolean isValid=false;
        String stringInput=input.nextLine();
        while (!isValid){
            if (!stringInput.trim().equals("")){
                isValid=true;
            }
            else {
                System.out.print("Please enter a valid String input ("+inputOptions+"): ");
                stringInput=input.nextLine();
            }
        }
        return stringInput;
    }
    public static int safeIntInput(int min, int max){
        boolean isValid=false;
        int intInput=0;
        while (!isValid){
            String stringInput=input.nextLine();
            try{
                intInput=Integer.parseInt(stringInput);
                isValid=(intInput>=min&&intInput<=max);
                if (isValid){
                    break;
                }
            }
            catch (NumberFormatException exception){
            }
            System.out.print("Please enter a valid integer input between "+min+" and "+max+": ");
        }
        return intInput;
    }
    public static boolean safeBooleanInput(){
        boolean booleanInput=false;
        boolean isValid=false;
        while (!isValid){
            String stringInput=input.nextLine().trim().toLowerCase();
            if (stringInput.equals("true")||stringInput.equals("false")){
                booleanInput=stringInput.equals("true");
                isValid=true;
            }
            else{
                System.out.print("Please enter a valid boolean input: ");
            }
        }
        return booleanInput;
    }
}