import asiel.ActiveDog;
import asiel.Dog;
import asiel.PassiveDog;
import reservatiebeheer.Reservatie;
import vrijwilligers.Adres;
import vrijwilligers.Vrijwilliger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {

        //initialisatie hondengegevens
        Dog stompy = new ActiveDog("stompy", 2015, "poodle", "groot", "wit", 10);
        Dog flupper = new PassiveDog("flupper", 2015, "herdershond", "klein", "bruin", true, false);
        Dog dipsy = new ActiveDog("dipsy", 2012, "poodle", "groot", "zwart", 5);
        Dog lompy = new PassiveDog("lompy", 2018, "labrador", "klein", "wit", false, false);
        Dog grumpy = new ActiveDog("grumpy", 2019, "border collie", "groot", "zwart-wit", 9);
        Dog happer = new PassiveDog("happer", 2020, "golden retriever", "klein", "goud", true, true);

        Dog.dogs.add(stompy);
        Dog.dogs.add(flupper);
        Dog.dogs.add(dipsy);
        Dog.dogs.add(lompy);
        Dog.dogs.add(grumpy);
        Dog.dogs.add(happer);


        // initialisatie vrijwilligersgegevens
        Adres adres = new Adres("hoofdstraat", 10, 2896, "bakbeek");
        Adres adres2 = new Adres("kerkstraat", 1, 1020, "oppergem");
        Adres adres3 = new Adres("dorpstraat", 125, 1900, "zandvorst");
        Adres adres4 = new Adres("schoolstraat", 16, 8844, "wemelgroot");

        Vrijwilliger jos = new Vrijwilliger("Jos", "15411512", adres, "jos@email.com", "222245784");
        Vrijwilliger bert = new Vrijwilliger("Bert", "157575", adres2, "bert@email.com", "2275757");
        Vrijwilliger bram = new Vrijwilliger("Bram", "15468686", adres3, "bram15@email.com", "22666558");
        Vrijwilliger lieven = new Vrijwilliger("Lieven", "154575754", adres4, "lieven.l@email.com", "225/558/86");
        Vrijwilliger jozef = new Vrijwilliger("Jozef", "1575754", adres3, "jozef.christus@email.com", "22 5554 7 7");
        Vrijwilliger marie = new Vrijwilliger("Marie", "1545354", adres, "marie.a@email.com", "5553478");
        Vrijwilliger bertrand = new Vrijwilliger("Bertrand", "1547755", adres2, "bertje69@email.com", "+6457672");

        Vrijwilliger.vrijwilligers.add(jos);
        Vrijwilliger.vrijwilligers.add(bert);
        Vrijwilliger.vrijwilligers.add(bram);
        Vrijwilliger.vrijwilligers.add(lieven);
        Vrijwilliger.vrijwilligers.add(jozef);
        Vrijwilliger.vrijwilligers.add(marie);
        Vrijwilliger.vrijwilligers.add(bertrand);

        // initialisatie bestellingsgegevens
        Reservatie b1 = new Reservatie(2001, 1001, formatter.parse("2018-01-21"), formatter.parse("2018-01-23"));
        Reservatie b2 = new Reservatie(2002, 1004, formatter.parse("2018-01-22"), formatter.parse("2018-01-24"));
        Reservatie b3 = new Reservatie(2004, 1003, formatter.parse("2018-01-23"), formatter.parse("2018-01-25"));
        Reservatie b4 = new Reservatie(2005, 1005, formatter.parse("2020-05-21"), formatter.parse("2020-05-24"));
        Reservatie b5 = new Reservatie(2002, 1002, formatter.parse("2020-05-22"), formatter.parse("2020-05-25"));
        Reservatie b6 = new Reservatie(2001, 1006, formatter.parse("2020-05-23"), formatter.parse("2020-05-26"));

        Reservatie.reservaties.add(b1);
        Reservatie.reservaties.add(b2);
        Reservatie.reservaties.add(b3);
        Reservatie.reservaties.add(b4);
        Reservatie.reservaties.add(b5);
        Reservatie.reservaties.add(b6);


        int keuze = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("____________________WELKOM______________________\n" +
                    "Wat wenst u te doen?\n" +
                    "1. Honden beheren\n" +
                    "2. Vrijwilligers beheren\n" +
                    "3. Reservaties beheren\n" +
                    "0. Programma beeindigen");
            keuze = s.nextInt();
            if(keuze == 1 || keuze == 2 || keuze == 3) {
                switch (keuze) {
                    case 1: Dog.main(args);
                    break;
                    case 2: Vrijwilliger.main(args);
                    break;
                    case 3: Reservatie.main(args);
                    break;
                }
            }
        } while (keuze != 0);
        System.out.println("Programma correct afgesloten");
    }
}
