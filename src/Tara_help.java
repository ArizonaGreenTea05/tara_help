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

    public static void main(String[] args)
    {
        Tara_help tHelp = new Tara_help();
        tHelp.hausaufgaben_26_11_22();
    }
}
