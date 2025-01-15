import java.util.Random;
import java.util.Scanner;

// Létrehozzuk a csiga osztályt, és benne a tulajdonságait
class csiga {
    private String szine; // Private field
    private int tavolsag; // Private field
    private boolean gyorsito; // Private field

    // Konstruktor
    public csiga(String szine) {
        this.szine = szine;
        this.tavolsag = 0;
        this.gyorsito = false;
    }

    // Getter methods
    public String getSzine() {
        return szine;
    }

    public int getTavolsag() {
        return tavolsag;
    }

    public boolean isGyorsito() {
        return gyorsito;
    }

    // Setter methods for gyorsito and tavolsag (optional, if needed)
    public void setGyorsito(boolean gyorsito) {
        this.gyorsito = gyorsito;
    }

    public void setTavolsag(int tavolsag) {
        this.tavolsag = tavolsag;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Írd be melyik csiga fog nyerni:\npiros, zöld vagy a kék");

        // Be tudunk írni a konzolra
        Scanner szken = new Scanner(System.in);
        String fogadas = szken.nextLine();

        // Létrehozzuk a 3 csigát
        csiga csiga1 = new csiga("piros");
        csiga csiga2 = new csiga("zöld");
        csiga csiga3 = new csiga("kék");

        // Random szám generálás 1 és 20 között
        Random random = new Random();

        // Körök 1-től 5-ig
        int korok = 1;
        while (korok <= 5) {
            System.out.println("\n" + korok + ". kör");

            // 20% esély számolása
            if (random.nextDouble() < 0.2) {
                int gyorsito = random.nextInt(3);
                if (gyorsito == 0) {
                    csiga1.setGyorsito(true);
                    System.out.println(csiga1.getSzine() + " csiga felgyorsult");
                } else if (gyorsito == 1) {
                    csiga2.setGyorsito(true);
                    System.out.println(csiga2.getSzine() + " csiga felgyorsult");
                } else {
                    csiga3.setGyorsito(true);
                    System.out.println(csiga3.getSzine() + " csiga felgyorsult");
                }
            }

            // Csigák mozgásának végrehajtása, ha kell sebesség duplázódik
            int mozgas1 = random.nextInt(4);
            if (csiga1.isGyorsito()) {
                mozgas1 *= 2;
                csiga1.setGyorsito(false);
            }
            csiga1.setTavolsag(csiga1.getTavolsag() + mozgas1);

            int mozgas2 = random.nextInt(4);
            if (csiga2.isGyorsito()) {
                mozgas2 *= 2;
                csiga2.setGyorsito(false);
            }
            csiga2.setTavolsag(csiga2.getTavolsag() + mozgas2);

            int mozgas3 = random.nextInt(4);
            if (csiga3.isGyorsito()) {
                mozgas3 *= 2;
                csiga3.setGyorsito(false);
            }
            csiga3.setTavolsag(csiga3.getTavolsag() + mozgas3);

            korok++;

            // Kiírás a csigák aktuális távolságáról
            System.out.println(csiga1.getSzine() + " csiga ment: " + csiga1.getTavolsag());
            System.out.println(csiga2.getSzine() + " csiga ment: " + csiga2.getTavolsag());
            System.out.println(csiga3.getSzine() + " csiga ment: " + csiga3.getTavolsag());
        }

        // Nyertes meghatározása
        csiga nyert_csiga = csiga1;
        if (csiga2.getTavolsag() > nyert_csiga.getTavolsag()) {
            nyert_csiga = csiga2;
        }
        if (csiga3.getTavolsag() > nyert_csiga.getTavolsag()) {
            nyert_csiga = csiga3;
        }

        // Nyertes kiírása
        System.out.println("\nA " + nyert_csiga.getSzine() + " csiga nyert\n" +
                "Táv: " + nyert_csiga.getTavolsag() + "\n");

        if (nyert_csiga.getSzine().equals(fogadas)) {
            System.out.println("Eltaláltad!");
        } else {
            System.out.println("Nem találtad el!");
        }

        szken.close();
    }
}
