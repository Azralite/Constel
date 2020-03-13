package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Controller {

    private ArrayList<String> choixTab = new ArrayList<String>();

    private Random rand = new Random();

    public Controller(String[] choix, String rep){
        int[] tabrand = new int[3];
        tabrand[0] = rand.nextInt(choix.length);
        choixTab.add(choix[tabrand[0]]);
        do {
            tabrand[1] = rand.nextInt(choix.length);
        }while (tabrand[1]==tabrand[0]);
        choixTab.add(choix[tabrand[1]]);
        do {
            tabrand[2] = rand.nextInt(choix.length);
        }while (tabrand[2] == tabrand[1] || tabrand[2] == tabrand[0]);
        choixTab.add(choix[tabrand[2]]);
        choixTab.add(rep);

        Collections.shuffle(choixTab);
    }


    public ArrayList<String> getChoixTab() {
        return choixTab;
    }
}
