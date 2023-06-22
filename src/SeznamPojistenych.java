import java.util.ArrayList;
import java.util.Scanner;

public class SeznamPojistenych {
    private static ArrayList<Pojisteny> seznamPojistenych = new ArrayList<Pojisteny>();

    public static void pridejPojisteneho(Pojisteny pojisteny) {
        seznamPojistenych.add(pojisteny);
    }

    public static ArrayList<Pojisteny> getSeznamPojistenych() {
        return seznamPojistenych;
    }

    public static void vytvoritPojisteneho(Scanner sc) {
        System.out.println("Zadejte jmeno:");
        String jmeno = sc.nextLine().trim().toUpperCase();
        System.out.println("Zadejte prijmeni:");
        String prijmeni = sc.nextLine().trim().toUpperCase();
        System.out.println("Zadejte vek:");
        int vek = Integer.parseInt(sc.nextLine());

        String telefon;
        while (true) {
            System.out.println("Zadejte telefonni cislo ve formatu 123456789 nebo stisknete Enter pro preskoceni:");
            telefon = sc.nextLine().trim();
            if (telefon.equals("")) {
                break;
            } else if (telefon.length() != 9 || !telefon.matches("\\d+")) {
                System.out.println("Chybny format telefonniho cisla, zadejte cislo ve formatu 123456789.");
            } else {
                telefon = telefon.substring(0, 3) + " " + telefon.substring(3, 6) + " " + telefon.substring(6);
                break;
            }
        }

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        pridejPojisteneho(pojisteny);
        System.out.println("Pojisteny " + jmeno + " " + prijmeni + " byl pridan do seznamu.");
    }

    public static void vypisPojistene() {
        System.out.println("Seznam pojistenych:");
        System.out.println(String.format("%-20s %-20s %-10s %s", "Jmeno", "Prijmeni", "Vek", "Telefon"));
        for (Pojisteny pojisteny : seznamPojistenych) {
            System.out.println(pojisteny);
        }
    }

    public static void hledejPojisteneho(Scanner sc) {
        System.out.println("Zadejte jmeno:");
        String jmeno = sc.nextLine().trim().toUpperCase();
        System.out.println("Zadejte prijmeni");
        String prijmeni = sc.nextLine().trim().toUpperCase();
        ArrayList<Pojisteny> nalezeni = new ArrayList<Pojisteny>();
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equals(jmeno) || pojisteny.getPrijmeni().equals(prijmeni)) {
                nalezeni.add(pojisteny);
            }
        }
        if (nalezeni.size() == 0) {
            System.out.println("Nenalezen zadny zaznam pro " + jmeno + " " + prijmeni);
        } else {
            System.out.println("Nalezeni pojisteni pro " + jmeno + " " + prijmeni + ":");
            System.out.println(String.format("%-20s %-20s %-10s %s", "Jmeno", "Prijmeni", "Vek", "Telefon"));
            for (Pojisteny pojisteny : nalezeni) {
                System.out.println(pojisteny);
            }
        }
    }
}
