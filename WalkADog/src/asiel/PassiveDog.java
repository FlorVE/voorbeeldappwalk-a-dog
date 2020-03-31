package asiel;

import java.util.Scanner;

public class PassiveDog extends Dog {
    private boolean kindvriendelijk;
    private boolean diervriendelijk;

    public PassiveDog(String name, int geboortejaar, String ras, String type, String kleur, boolean kindvriendelijk, boolean diervriendelijk) {
        super(name, geboortejaar, ras, type, kleur);
        this.kindvriendelijk = kindvriendelijk;
        this.diervriendelijk = diervriendelijk;
    }

    public static void PassiveHondToevoegen(Scanner s) {
        String name, ras, type, kleur, kind, dier;
        int geboortejaar;
        boolean kindvriendelijk, diervriendelijk;


            PassiveDog dog = null;
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
            System.out.println("kindvriendelijk: ");
            kind = s.next();
            if (kind.equals("ja")) kindvriendelijk = true;
            else kindvriendelijk = false;
            System.out.println("diervriendelijk: ");
            dier = s.next();
            if (dier.equals("ja")) diervriendelijk = true;
            else diervriendelijk = false;
            dog = new PassiveDog(name, geboortejaar, ras, type, kleur, kindvriendelijk, diervriendelijk);
            dogs.add(dog);

    }

    public boolean isKindvriendelijk() {
        return kindvriendelijk;
    }

    public void setKindvriendelijk(boolean kindvriendelijk) {
        this.kindvriendelijk = kindvriendelijk;
    }

    public boolean isDiervriendelijk() {
        return diervriendelijk;
    }

    public void setDiervriendelijk(boolean diervriendelijk) {
        this.diervriendelijk = diervriendelijk;
    }

    @Override
    public String toString() {
        return super.toString() +
                " kindvriendelijk=" + kindvriendelijk +
                ", diervriendelijk=" + diervriendelijk;
    }

    public static void wijzigen(PassiveDog dog, Scanner s){
        int keuze = 0;
        do {
            System.out.println("1. kindvriendelijkheid automatisch wijzigen\n2. Diervriendelijkheid automatisch wijzigen");
            keuze = s.nextInt();
        }while (!(keuze == 1 || keuze == 2));
        if (keuze == 1){
            if (dog.isKindvriendelijk()) dog.setKindvriendelijk(false);
            else dog.setKindvriendelijk(true);
        }
        else if (keuze == 1){
            if (dog.isDiervriendelijk()) dog.setDiervriendelijk(false);
            else dog.setDiervriendelijk(true);
        }
        System.out.println("Hond succesvol gewijzigd!");
    }

}
