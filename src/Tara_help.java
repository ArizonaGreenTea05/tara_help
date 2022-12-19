import java.util.Scanner;

public class Tara_help
{


    private void hausaufgaben_26_11_22()
    {
        for (int zaehler = 1; zaehler <= 100; ++zaehler)
        {
            // modulo operator anstatt sich auf int casting zu verlassen
            // -> zaehler % 5 = Rest wenn man zaehler durch 5 teilt
            // -> 10 % 5 = 0, weil 10 durch 5 glatt geht;
            //    11 % 5 = 1, weil 1 als Rest bleibt
            // (aber deine Lösung funktioniert natürlich auch)
            if(zaehler % 5 == 0)
            {
                // wird ausgeführt wenn teilbar durch 5
                System.out.print(zaehler + " ist teilbar durch 5");
                if(zaehler % 3 != 0)
                {
                    // wird ausgeführt wenn teilbar durch 5 & NICHT teilbar durch 3
                    System.out.print(" & nicht durch 3");
                }
            }
            else
            {
                // wird in allen anderen Fällen ausgeführt
                System.out.print("näh");
            }
            // neue Zeile weil schön
            System.out.println("");
        }
    }

    private void zahlenratenUmgekehrt()
    {
        int GREATER = 1;
        int SMALLER = 0;
        int RIGHT_GUESS = 1;
        int WRONG_GUESS = 0;

        Scanner s = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int input = -1;
        int result = -1;
        int mid = -1;
        int greaterOrSmaller = -1;
        int rightOrWrongGuess = -1;

        System.out.print("bruda gib Zahl zwischen " + min + " und " + max + ": ");
        input = s.nextInt();
        do
        {
            mid = min + (max-min)/2;
            System.out.println("ist deine Zahl " + mid + "? (" + RIGHT_GUESS + "=ja, " + WRONG_GUESS + "=nein)");
            rightOrWrongGuess = s.nextInt();
            if(rightOrWrongGuess == RIGHT_GUESS)
            {
                result = mid;
                break;
            }

            System.out.println("ist deine Zahl groesser oder kleiner als " + mid + "? (" + GREATER + "=groesser, " + SMALLER + "=kleiner)");
            greaterOrSmaller = s.nextInt();

            if(greaterOrSmaller == GREATER)
            {
                min = mid;
            }
            else
            {
                max = mid;
            }
        } while(result != input);

        System.out.println("bruda ich bin so schlau ey");
    }

    public static void main(String[] args)
    {
        Tara_help tHelp = new Tara_help();
        //tHelp.hausaufgaben_26_11_22();
        tHelp.zahlenratenUmgekehrt();
    }
}
