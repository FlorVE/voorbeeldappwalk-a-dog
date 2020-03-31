package reservatiebeheer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import vrijwilligers.*;
import asiel.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservatie {
    private int vrijwilligerId;
    private int hondId;
    private Date beginDatum;
    private Date eindDatum;
    private int vergoeding;
    private int bestelId;

    static int counter = 3000;

    public static ArrayList<Reservatie> reservaties = new ArrayList<Reservatie>();

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Reservatie(int vrijwilligerId, int hondId, Date beginDatum, Date eindDatum) {
        counter++;
        this.vrijwilligerId = vrijwilligerId;
        this.hondId = hondId;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.bestelId = counter;
        this.vergoeding = 12;
    }

    public static void reservatiesWeergeven(Scanner s) throws ParseException {
        int keuze = 0;
        System.out.println("1. Alle reservaties weergeven\n" +
                "2. Toekomstige reservaties weergeven");
        keuze = s.nextInt();
        if (keuze == 1 || keuze == 2 ) {
            if (keuze == 1) {
                System.out.println("Lijst van reservaties: ");
                for (Reservatie reservatie : reservaties) {
                    System.out.println(reservatie.toString());
                }
            }
            else if (keuze == 2) {
                System.out.println("Lijst van reservaties: ");
                for (Reservatie reservatie : reservaties)
                    // verglijken van einddatum van reservatie met huidige datum om te zien welke reservaties nog moeten beginnen
                    if(reservatie.eindDatum.compareTo(formatter.parse(String.valueOf(LocalDate.now()))) > 0){
                        System.out.println(reservatie.toString());
                    }
            }
        } else System.out.println("Foutieve invoer!");
        return;
    }

    public static void reservatieToevoegen(Scanner s){
        // parameters constructor declareren
        int vrijwilligerId = 0, hondId = 0;
        Date beginDatum, eindDatum;

        // aanmaak tijdelijke parameters om controles uit te voeren
        int vrijwilligerIdTemp, hondIdtemp;
        String begin, eind;

        // aanmaak tijdelijke vrijwilliger en hond
        Vrijwilliger temp;
        Dog temp2;


        s.nextLine();


        // nieuwe reservatie creeren
        Reservatie reservatie = null;

        // parameters invullen

        // VRIJWILLIGERSID
        do {
            System.out.println("Vrijwilliger ID: ");
            vrijwilligerIdTemp = s.nextInt();
            temp = Vrijwilliger.find(vrijwilligerIdTemp);
            // indien het pas ingegeven vrijwilligerID gelijk is aan een id in de lijst vrijwilligers wordt de info van deze vrijwlliger weergegeven
            if (temp != null) {
                System.out.println("U koos voor vrijwilliger: ");
                System.out.println(temp.toString());
                // indien alles goed wordt vrijwilligersId gelijkgesteld aan vrijwilligersidtemp
                vrijwilligerId = vrijwilligerIdTemp;
            } else {
                System.out.println("incorrect vrijwilligersID");

            }
        } while (temp == null);

        // HONDID
        do {
            System.out.println("Hond ID: ");
            hondIdtemp = s.nextInt();
            temp2 = Dog.find(hondIdtemp);
            // indien het pas ingegeven hondID gelijk is aan een id in de lijst vrijwilligers wordt de info van deze vrijwlliger weergegeven
            if (temp2 != null) {
                System.out.println("U koos voor hond: ");
                System.out.println(temp2.toString());
                // indien alles goed wordt hondId gelijk gesteld aan hondId Temp
                hondId = hondIdtemp;
            } else {
                System.out.println("incorrect hondID");

            }
        } while (temp2 == null);
        s.nextLine();

        // BEGINDATUM
        System.out.println("Begindatum \"yyyy-MM-dd\": ");
        begin = s.nextLine();
        try {
            beginDatum = formatter.parse(begin);
        } catch (ParseException e) {
            e.printStackTrace();
           beginDatum = null;
            System.out.println("ongeldige datum!");
        }

        // EINDDATUM
        System.out.println("Einddatum \"yyyy-MM-dd\": ");
        eind = s.nextLine();
        try {
            eindDatum = formatter.parse(eind);
        } catch (ParseException e) {
            e.printStackTrace();
            eindDatum = null;
            System.out.println("ongeldige datum!");
        }

        // testen naar correcte datum-invoer en of begindatum niet groter is of gelijk aan einddatum
        if ((beginDatum != null && eindDatum != null) || (beginDatum.compareTo(eindDatum) > 0 || beginDatum.compareTo(eindDatum) == 0)) {
            for (Reservatie test : reservaties) {

                // alle reeds bestaande reservaties worden gecontroleerd
                for (Dog dog : Dog.dogs){

                    // voor elke reservatie wordt nagegaan op welke hond deze van toepassing is door alle hondId's uit de lijst de controleren met het id op de reservatie
                    if (dog.getId() == hondId){

                        // test of de hond uit de reservatie al reservaties heeft met dezelfde data
                        // test 1: ligt de begindatum van de nieuwe reservatie tussen de begin en einddatum van een reeds bestaande reservatie van deze hond
                        if ((beginDatum.compareTo(test.beginDatum) > 0) && (beginDatum.compareTo(test.eindDatum) < 0)){
                            System.out.println(" de hond is op dit moment niet beschikbaar, reservatie mislukt!");
                            return;
                        }

                        // test 2: ligt de einddatum van de nieuwe reservatie tussen de begin en einddatum van een reeds bestaande reservatie van deze hond
                        else if ((eindDatum.compareTo(test.beginDatum) > 0) && (eindDatum.compareTo(test.eindDatum) < 0)){
                            System.out.println(" de hond is op dit moment niet beschikbaar, reservatie mislukt!");
                            return;
                        }

                        // test 3: liggen de begin en einddatum van de nieuwe reservatie ronde de begin en einddatum van een bestaande reservatie
                        else if ((beginDatum.compareTo(test.beginDatum) > 0) && (eindDatum.compareTo(test.eindDatum) < 0)){
                            System.out.println(" de hond is op dit moment niet beschikbaar, reservatie mislukt!");
                            return;
                        }
                    }
                }

            }
            if (vrijwilligerId != 0 && hondId != 0) {
                reservatie = new Reservatie(vrijwilligerId, hondId, beginDatum, eindDatum);
                Reservatie.reservaties.add(reservatie);
                System.out.println("Reservatie succesvol toegevoegd!");
            }
            else {
                System.out.println("reservatie mislukt, probeer opnieuw");
            }
        } else System.out.println("reservatie mislukt, probeer opnieuw");

    }

    public static void reservatieBewerken(int id, Scanner s) throws ParseException {
        int keuze = 0;
        if (reservaties.size() > 0){
            for (Reservatie reservatie : reservaties) {
                if (reservatie.bestelId == id){
                    System.out.println("Wat wenst u te bewerken?\n" +
                            "1. Hond\n" +
                            "2. Begindatum\n" +
                            "3. Einddatum\n" +
                            "4. Vergoeding");
                    keuze = s.nextInt();
                    int invoer = 0;
                    String invoerString = null;
                    switch (keuze) {
                        case 1:
                            System.out.println("Nieuw hond: ");
                            invoer = s.nextInt();
                            reservatie.setHondId(invoer);
                            break;
                        case 2:
                            s.nextLine();
                            System.out.println("nieuwe begindatum \"yyyy-MM-dd\":");
                            invoerString = s.nextLine();
                            reservatie.setBeginDatum(formatter.parse(invoerString));
                            break;
                        case 3:
                            s.nextLine();
                            System.out.println("nieuwe einddatum \"yyyy-MM-dd\":");
                            invoerString = s.nextLine();
                            reservatie.setEindDatum(formatter.parse(invoerString));
                            break;
                        case 4:
                            System.out.println("Nieuw vergoeding: ");
                            invoer = s.nextInt();
                            reservatie.setVergoeding(invoer);
                            break;
                    }
                    System.out.println("Wijziging succesvol!");
                    return;
                }
            }
        } else System.out.println("geen reservaties beschikbaar, voeg eerst s toe!");
        return;
    }

    public static void reservatieVerwijderen(int id) {
        if (reservaties.size() > 0) {
            for (Reservatie reservatie : reservaties){
                if(reservatie.bestelId == id){
                    reservaties.remove(reservatie);
                    System.out.println("Reservatie succesvol verwijderd!");
                    return;
                }
            }

        } else System.out.println("De lijst van reservaties is leeg, gelieve eerst reservaties toe te voegen");
        return;
    }

    public static void beheer(Scanner s) throws ParseException {
        int invoer = 0;
        do {
            System.out.println("WELKOM \n" +
                    "_____________________________________________________\n" +
                    "Maak uw keuze: \n" +
                    "1. reservaties weergeven \n" +
                    "2. Reservatie toevoegen \n" +
                    "3. Reservatie bewerken \n" +
                    "4. Reservatie verwijderen \n" +
                    "5. Opvolgingen beheren \n" +
                    "0. Terug \n");
            invoer = s.nextInt();
            switch (invoer) {
                case 1:
                    if (reservaties.size() > 0) {
                        reservatiesWeergeven(s);
                    } else System.out.println("\n\n\nGeen reservaties beschikbaar");
                    System.out.println("press enter...");
                    s.nextLine();
                    break;
                case 2:
                    reservatieToevoegen(s);

                    break;
                case 3:
                    System.out.println("Welke reservatie wenst u te bewerken? (id)");
                    int keuze2 = 0;
                    keuze2 = s.nextInt();
                    reservatieBewerken(keuze2, s);
                    break;
                case 4:
                    int keuze3;
                    System.out.println("Welke reservatie wenst u te verwijderen?");
                    keuze3 = s.nextInt();
                    reservatieVerwijderen(keuze3);
                    break;
                case 5:
                    Opvolging.beheer();
                default:
                    invoer = 0;
            }
        } while (invoer != 0);
        return;
    }

    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        Reservatie.beheer(s);

    }

    @Override
    public String toString() {
        return "Reservatie ID: " + bestelId +
                ", klantId=" + vrijwilligerId +
                ", hondId=" + hondId +
                ", beginDatum=" + formatter.format(beginDatum) +
                ", eindDatum=" + formatter.format(eindDatum) +
                ", vergoeding=" + vergoeding;
    }

    public void setHondId(int hondId) {
        this.hondId = hondId;
    }

    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public void setVergoeding(int vergoeding) {
        this.vergoeding = vergoeding;
    }
}
