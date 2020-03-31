package vrijwilligers;


import java.util.ArrayList;
import java.util.Scanner;

public class Vrijwilliger {
    private int id;
    private String naam;
    private String rekeningnummer;
    private Adres adres;
    private String email;
    private String tel;

    private static int counter = 2000;

    public static ArrayList<Vrijwilliger> vrijwilligers = new ArrayList<Vrijwilliger>();

    public Vrijwilliger(String naam, String rekeningnummer, Adres adres, String email, String tel) {
        counter++;
        this.id = counter;
        this.naam = naam;
        this.adres = adres;
        this.rekeningnummer = rekeningnummer;
        this.email = email;
        this.tel = tel;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Vrijwilliger{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", rekeningnummer='" + rekeningnummer + '\'' +
                ", adres=" + adres.toString() +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'';
    }

    public static void vrijwilligersWeergeven() {
        System.out.println("Lijst van vrijwilligers: ");
        for (Vrijwilliger vrijwilliger : vrijwilligers) {
            System.out.println(vrijwilliger.toString());
        }
    }

    public static void vrijwilligerToevoegen(Scanner s) {
        String name, rekeningnummer, email, tel;
        Adres adres;

        s.nextLine();
        Vrijwilliger vrijwilliger = null;
        System.out.println("Naam: ");
        name = s.nextLine();
        System.out.println("_______________Adres_______________ ");
        adres = Adres.nieuwAdres(s);
        System.out.println("rekeningnummer: ");
        rekeningnummer = s.nextLine();
        System.out.println("email: ");
        email = s.nextLine();
        System.out.println("tel: ");
        tel = s.nextLine();
        vrijwilliger = new Vrijwilliger(name, rekeningnummer, adres, email, tel);
        Vrijwilliger.vrijwilligers.add(vrijwilliger);
    }

    public static void vrijwilligerBewerken(int id, Scanner s){
        int keuze = 0;
        if (vrijwilligers.size() > 0){
            for (Vrijwilliger vrijwilliger : vrijwilligers) {
                if (vrijwilliger.id == id) {
                    System.out.println("U koos vrijwilliger: " + vrijwilliger.toString());
                    System.out.println("Wat wenst u te wijzigen?\n" +
                            "1. Naam\n" +
                            "2. Adres\n" +
                            "3. Rekeningnummer\n" +
                            "4. Email\n" +
                            "5. Tel");
                    keuze = s.nextInt();
                    if (keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4 || keuze == 5) {
                        String nieuw;
                        Adres nieuwAdres;
                        switch (keuze){
                            case 1:
                                s.nextLine();
                                System.out.println("Nieuwe naam: ");
                                nieuw = s.nextLine();
                                vrijwilliger.setNaam(nieuw);
                                System.out.println("Naam gewijzigd!");
                                break;
                            case 2:
                                s.nextLine();
                                System.out.println("Nieuwe adres: ");
                                nieuwAdres= Adres.nieuwAdres(s);
                                vrijwilliger.adres = nieuwAdres;
                                System.out.println("Adres gewijzigd!");
                                break;
                            case 3:
                                s.nextLine();
                                System.out.println("Nieuw rekeningnummer: ");
                                nieuw = s.nextLine();
                                vrijwilliger.setRekeningnummer(nieuw);
                                System.out.println("Rekeningnummer gewijzigd!");
                                break;
                            case 4:
                                s.nextLine();
                                System.out.println("Nieuw emailadres: ");
                                nieuw = s.nextLine();
                                vrijwilliger.setEmail(nieuw);
                                System.out.println("Emailadres gewijzigd!");
                                break;
                            case 5:
                                s.nextLine();
                                System.out.println("Nieuw telefoonnummer: ");
                                nieuw = s.nextLine();
                                vrijwilliger.setTel(nieuw);
                                System.out.println("telefoonnummer gewijzigd!");
                                break;
                        }
                    }
                    return;
                }
                return;
            }
        }else System.out.println("Het bestand bevat geen bewerkbare vrijwilligers, probeer later opnieuw!");
        return;
    }

    public static void vrijwilligerVerwijderen(int id) {
        if (vrijwilligers.size() > 0) {
            for (Vrijwilliger vrijwilliger : vrijwilligers){
                if(vrijwilliger.id == id){
                    vrijwilligers.remove(vrijwilliger);
                    System.out.println("Vrijwilliger succesvol verwijderd!");
                    return;
                }
            }

        } else System.out.println("De lijst van vrijwilligers is leeg, gelieve eerst vrijwilligers toe te voegen");
        return;
    }

    public static void beheer(Scanner s){
        int invoer = 0;
        do {
            System.out.println("WELKOM \n" +
                    "_____________________________________________________\n" +
                    "Maak uw keuze: \n" +
                    "1. Alle vrijwilligers weergeven \n" +
                    "2. Vrijwilliger toevoegen \n" +
                    "3. Vrijwilliger bewerken \n" +
                    "4. Vrijwilliger verwijderen \n" +
                    "0. Terug \n");
            invoer = s.nextInt();
            switch (invoer) {
                case 1:
                    if (vrijwilligers.size() > 0) {
                        System.out.println("\n\n\n");
                        vrijwilligersWeergeven();
                    } else System.out.println("\n\n\nGeen vrijwilligers beschikbaar");
                    System.out.println("press enter...");
                    s.nextLine();
                    break;
                case 2:
                    vrijwilligerToevoegen(s);
                    System.out.println("vrijwilliger succesvol toegevoegd!");
                    break;
                case 3:
                    System.out.println("Welke vrijwilliger wenst u te bewerken? (id)");
                    int keuze2 = 0;
                    keuze2 = s.nextInt();
                    vrijwilligerBewerken(keuze2, s);
                    break;
                case 4:
                    int keuze3;
                    System.out.println("Welke vrijwilliger wenst u te verwijderen?");
                    keuze3 = s.nextInt();
                    vrijwilligerVerwijderen(keuze3);
                    break;
                default:
                    invoer = 0;
            }
        } while (invoer != 0);
        return;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Vrijwilliger.beheer(s);
    }

    public static Vrijwilliger find(int id) {
        for (Vrijwilliger vrijwilliger : vrijwilligers){
            if (vrijwilliger.id == id)
                return vrijwilliger;
        }
        return null;
    }

}
