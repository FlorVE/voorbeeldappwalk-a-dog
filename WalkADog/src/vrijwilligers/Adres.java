package vrijwilligers;

import java.util.Scanner;

public class Adres {
    private String straatnaam;
    private int huisnummer;
    private int postcode;
    private String woonplaats;

    public Adres(String straatnaam, int huisnummer, int postcode, String woonplaats) {
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public static Adres nieuwAdres(Scanner s){
        String straatnaam, woonplaats;
        int huisnummer, postcode;
        System.out.println("straatnaam: ");
        straatnaam = s.nextLine();
        System.out.println("huisnummer: ");
        huisnummer = s.nextInt();
        System.out.println("postcode: ");
        postcode = s.nextInt();
        System.out.println("woonplaats: ");
        s.nextLine();
        woonplaats = s.nextLine();

        Adres adres = new Adres(straatnaam, huisnummer, postcode, woonplaats);
        return adres;
    }


    @Override
    public String toString() {
        return "{" +
                "straatnaam='" + straatnaam + '\'' +
                ", huisnummer=" + huisnummer +
                ", postcode=" + postcode +
                ", woonplaats='" + woonplaats + '\'' +
                '}';
    }
}
