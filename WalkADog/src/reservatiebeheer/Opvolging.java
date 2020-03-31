package reservatiebeheer;

public class Opvolging {
    private int opvolgingID;
    private int hondID;
    private int vrijwilligerID;
    private String tekst;

    static int counter = 4000;

    public Opvolging(int hondID, int vrijwilligerID, String tekst) {
        counter++;
        this.opvolgingID = counter;
        this.hondID = hondID;
        this.vrijwilligerID = vrijwilligerID;
        this.tekst = tekst;
    }

    public static void beheer(){
        System.out.println("klasse under construction");
        return;
    }

}
