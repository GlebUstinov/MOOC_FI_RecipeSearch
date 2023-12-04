
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recipes rec = new Recipes();
        UserInterface ui = new UserInterface(rec, scanner);
        ui.start();
    }
}
