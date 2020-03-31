package asiel;

import java.util.Scanner;

public class ActiveDog extends Dog {
    public int wandelAfstand;

    public ActiveDog(String name, int geboortejaar, String ras, String type, String kleur, int wandelAfstand) {
        super(name, geboortejaar, ras, type, kleur);
        this.wandelAfstand = wandelAfstand;
    }

    public static void ActiveHondToevoegen(Scanner s) {
        String name, ras, type, kleur;
        int geboortejaar, wandelafstand;


            ActiveDog dog = null;
            System.out.println("Naam: ");
            name = s.next();
            System.out.println("Geboortejaar: ");
            geboortejaar = s.nextInt();
            System.out.println("ras: ");
            ras = s.next();
            System.out.println("type: ");
            type = s.next();
            System.out.println("kleur: ");
            kleur = s.next();
            System.out.println("Wandelafstand: ");
            wandelafstand = s.nextInt();
            dog = new ActiveDog(name, geboortejaar, ras, type, kleur, wandelafstand);
            Dog.dogs.add(dog);

    }

    public void setWandelAfstand(int wandelAfstand) {
        this.wandelAfstand = wandelAfstand;
    }

    @Override
    public String toString() {
        return super.toString() +
                " wandelAfstand=" + wandelAfstand + "km";
    }

    public static void wijzigen(ActiveDog dog, Scanner s){
        int keuze = 0;
        System.out.println("U kan enkel de wandelafstand wijzigen! Nieuwe wandelafstand: ");
        keuze = s.nextInt();
        dog.setWandelAfstand(keuze);
        System.out.println("Hond succesvol gewijzigd!");
    }
}
