package asiel;

import asiel.ActiveDog;
import asiel.PassiveDog;
import vrijwilligers.Vrijwilliger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public abstract class Dog {
    private String name;
    private int geboortejaar;
    private String ras;
    private String type;
    private String kleur;
    private Opmerking[] opmerkingen;
    private int id;

    private static int counter = 1000;

    public static ArrayList<Dog> dogs = new ArrayList<Dog>();

    public Dog() {
    }

    public Dog(String name, int geboortejaar, String ras, String type, String kleur) {
        counter++;
        this.name = name;
        this.geboortejaar = geboortejaar;
        this.ras = ras;
        this.type = type;
        this.kleur = kleur;
        this.id = counter;
    }


    @Override
    public String toString() {
        return "id: " + this.id +
                ", doeleinde: " + this.getClass().getSimpleName() +
                ", name='" + name + '\'' +
                ", geboortejaar=" + geboortejaar +
                ", ras='" + ras + '\'' +
                ", type='" + type + '\'' +
                ", kleur='" + kleur + '\'' +
                ", opmerkingen=" + Arrays.toString(opmerkingen) + ","
                ;
    }

    public static void hondenWeergeven() {
        System.out.println("Lijst van honden: ");
        for (Dog dog : dogs) {
            System.out.println(dog.toString());
        }
    }

    public static void hondVerwijderen(int id) {
        if (dogs.size() > 0) {
            for (Dog dog : dogs){
                if(dog.id == id){
                    dogs.remove(dog);
                    System.out.println("Hond succesvol verwijderd!");
                    return;
                }
            }

        } else System.out.println("De lijst van honden is leeg, gelieve eerst honden toe te voegen");
    }

    public static void hondBewerken(int id, Scanner s) {
        if (dogs.size() > 0) {
            for (Dog dog : dogs) {
                if (dog.id == id) {
                    System.out.println("U koos hond" + dog.toString());
                    if (dog instanceof ActiveDog) {
                        ActiveDog a = (ActiveDog)dog;
                        ActiveDog.wijzigen(a, s);
                        return;
                    } else if (dog instanceof PassiveDog) {
                        PassiveDog p = (PassiveDog)dog;
                        PassiveDog.wijzigen(p, s);
                        return;
                    }
                }
            }
        } else System.out.println("De lijst van honden is leeg, gelieve eerst honden toe te voegen");
    }

    public static void beheer(Scanner s) {
        int invoer = 0;
        do {
            System.out.println("WELKOM \n" +
                    "_____________________________________________________\n" +
                    "Maak uw keuze: \n" +
                    "1. Alle honden weergeven \n" +
                    "2. Hond toevoegen \n" +
                    "3. Hond bewerken \n" +
                    "4. Hond verwijderen \n" +
                    "0. Terug \n");
            invoer = s.nextInt();
            switch (invoer) {
                case 1:
                    if (dogs.size() > 0) {
                        System.out.println("\n\n\n");
                        hondenWeergeven();
                    } else System.out.println("\n\n\nGeen honden beschikbaar");
                    System.out.println("press enter...");
                    s.nextLine();
                    break;
                case 2:
                    int keuze = 0;
                    do {
                        System.out.println("\n1. Actieve hond toevoegen\n2. Passieve hond toevoegen");
                        keuze = s.nextInt();
                    } while (!(keuze == 1 || keuze == 2));
                    if (keuze == 1) ActiveDog.ActiveHondToevoegen(s);
                    else if (keuze == 2) PassiveDog.PassiveHondToevoegen(s);
                    System.out.println("Hond succesvol toegevoegd!");
                    break;
                case 3:
                    System.out.println("Welke hond wenst u te bewerken? (id)");
                    int keuze2 = 0;
                    keuze2 = s.nextInt();
                    hondBewerken(keuze2, s);
                    break;
                case 4:
                    int keuze3;
                    System.out.println("Welke hond wenst u te verwijderen?");
                    keuze3 = s.nextInt();
                    hondVerwijderen(keuze3);
                    break;
                default:
                    invoer = 0;
            }
        } while (invoer != 0);
        return;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Dog.beheer(s);
    }

    public static Dog find(int id) {
        for (Dog dog : dogs){
            if (dog.id == id)
                return dog;
        }
        return null;
    }

}


