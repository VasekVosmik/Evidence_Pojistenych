import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"Windows-1250");
        SeznamPojistenych seznamPojistenych = new SeznamPojistenych();

        System.out.println("--------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("--------------------------");

        while (true) {
            System.out.println();
            System.out.println("Vyberte akci, kterou chcete provest:");
            System.out.println("1 - Pridat nového pojisteneho");
            System.out.println("2 - Seznam všech pojistenych");
            System.out.println("3 - Vyhledat podle jmena a prijmeni");
            System.out.println("0 - Ukoncit program");
            int volba = Integer.parseInt(sc.nextLine().trim());

            switch (volba) {
                case 1:
                    seznamPojistenych.vytvoritPojisteneho(sc);
                    break;
                case 2:
                    seznamPojistenych.vypisPojistene();
                    break;
                case 3:
                    seznamPojistenych.hledejPojisteneho(sc);
                    break;
                case 0:
                    System.out.println("Opravdu si prejete ukoncit program? (A/N)");
                    String ukonceni = sc.nextLine().toUpperCase().trim();
                    while (!ukonceni.equals("A") && !ukonceni.equals("N")) {
                        System.out.println("Neplatná odpoved, zadejte prosim 'ano'(A) nebo 'ne'(N): ");
                        ukonceni = sc.nextLine().toUpperCase().trim();
                    }
                    if (ukonceni.equals("A")) {
                        System.out.println("Ukonceni programu.");
                        return;
                    } else {
                        break;
                    }
                default:
                    System.out.println("Neplatny prikaz.");
                    break;
            }
        }
    }
}