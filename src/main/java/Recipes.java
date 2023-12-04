import java.util.*;
public class Recipes {
    private ArrayList<ArrayList<String>> listOfRecipes;

    public Recipes() {
        this.listOfRecipes = new ArrayList<>();
    }

    public void addRecipe(ArrayList<String> recipe) {
        listOfRecipes.add(recipe);
    }

    public void findName(String searchedWord) {
        System.out.println("Recipes:");

        for (ArrayList<String> el : this.listOfRecipes) {
            if (el.get(0).contains(searchedWord)) {
                System.out.println(el.get(0) + ", cooking time: " + el.get(1));
            }
        }
    }

    public void findTime(String maxTime) {
        System.out.println("Recipes:");
        int numMaxTime = Integer.valueOf(maxTime);

        for (ArrayList<String> el : this.listOfRecipes) {
            int timeOfCooking = Integer.valueOf(el.get(1));
            
            if (timeOfCooking <= numMaxTime) {
                System.out.println(el.get(0) + ", cooking time: " + el.get(1));
            }
        }
    }

    public void findByIngr(String ingr) {
        System.out.println("Recipes:");

        for (ArrayList<String> el : this.listOfRecipes) {
            for (int i = 2; i < el.size(); i++) {
                if (ingr.equals(el.get(i))) {
                    System.out.println(el.get(0) + ", cooking time: " + el.get(1));
                }
            }
        }
    }

    public void writeRecipes() {
        System.out.println("Recipes:");

        for (ArrayList<String> el : this.listOfRecipes) {
            System.out.println(el.get(0) + ", cooking time: " + el.get(1));
        }
    }
}
