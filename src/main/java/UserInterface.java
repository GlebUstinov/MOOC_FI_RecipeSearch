import java.util.*;
import java.nio.file.Paths;

public class UserInterface {
    private Recipes rec;
    private Scanner scan;

    public UserInterface(Recipes rec, Scanner scan) {
        this.rec = rec;
        this.scan = scan;
    }

    public void start() {
        readRecipes();
        System.out.println("");
        recipesDistribution();
    }

    public void readRecipes() {
        System.out.println("File to read: ");
        String path = this.scan.nextLine();
        
        try (Scanner sc = new Scanner(Paths.get(path))) {
            while (true) {
                ArrayList<String> recipe = new ArrayList<>();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.isEmpty()) { break; }
                    recipe.add(line);
                }
                this.rec.addRecipe(recipe);
                if(!sc.hasNextLine()) { break; }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void recipesDistribution() {
        System.out.println("Commands:\n" +
        "list - lists the recipes\n" +
        "stop - stops the program\n" + 
        "find name - searches recipes by name\n" +
        "find cooking time - searches recipes by cooking time\n" +
        "find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.println("Enter command: ");
            String line = this.scan.nextLine();
            
            if (line.equals("stop")) { break; }

            if (line.equals("list")) {
                this.rec.writeRecipes();
                System.out.println("");
            }
            
            if (line.equals("find name")) {
                System.out.println("Searched word: ");
                String searchedWord = this.scan.nextLine();
                this.rec.findName(searchedWord);
            }

            if (line.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                String maxTime = this.scan.nextLine();
                this.rec.findTime(maxTime);
            }

            if (line.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingr = this.scan.nextLine();
                this.rec.findByIngr(ingr);
            }
        }
    }
}
