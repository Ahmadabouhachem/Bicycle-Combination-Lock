import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZahlenSchloss {
    private static int turn = 0;
    private static int countUp = 0;
    private static int countDown = 0;
    private static int[] lockNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie eine 4-stellige Kombinationsnummer ein!");

        while (scanner.hasNext()) {

            String startKombination = scanner.next();

            boolean isDigits = startKombination.matches("\\d+");   //isDigits is true, when String startKombination does only have numbers.

            if (startKombination.length() != 4) {   //when startKombination more or less than 4 digit-number
                System.out.println("Die eingegebene Kombinationsnummer ist nicht vierstellig!\nVersuchen Sie noch einmal...");
            } else if (!isDigits) {
                System.out.println("Bitte keine Buchstaben oder Sonderzeichen eingeben!\nVersuchen Sie noch einmal...");
            } else {  //the startKombination was entered correctly (4 digit-number)
                editPinCode(startKombination);
            }
        }
    }

    public static String editPinCode(String startKombination) {

        String[] arrOfStr = startKombination.split("", 4);  //split the first four inputs of startKombination

        int[] nummern = {Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3])};   //change the input to integer and save it in int array.

        if (Arrays.stream(arrOfStr).allMatch(s -> s.equals(arrOfStr[0]))) {     //when the array arrOfStr has same numbers.
            turn = 0;
            System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
        } else {

            ArrayList<Integer> sameNumber = new ArrayList<Integer>(); //array for same numbers
            ArrayList<Integer> diffNumber = new ArrayList<Integer>(); //array for different numbers
            for (int i = 0; i < nummern.length; i++) {           //save the same number in sameNumber array
                for (int j = i + 1; j < nummern.length; j++) {
                    if (nummern[i] == nummern[j]) {
                        sameNumber.add(nummern[i]);
                    }
                }
            }
            if (sameNumber.iterator().hasNext()) {              //if the number were 1234, I will get error because sameNumber.get(0) ist null!
                for (int i = 0; i < nummern.length; i++) {      ////save the different number in diffNumber array
                    if (nummern[i] != sameNumber.get(0)) {
                        diffNumber.add(nummern[i]);
                    }
                }
            }
            /*
             ***
             *  I could have 4 Situations:
             * Situation 1: 3 numbers are same -> sameNumber.size() = 3 , diffNumber.size() = 1
             * Situation 2: 2 numbers are same and 2 are diff -> sameNumber.size() = 1 , diffNumber.size() = 2
             * Situation 3: 2 numbers are same and 2 are diff sameNumber.size() = 2 , diffNumber.size() = 2
             * Situation 4: 4 number are diff -> sameNumber.size() = 0 , diffNumber.size() = 0
             ***
             */
            //3 numbers same
            if (sameNumber.size() == 3 && diffNumber.size() == 1) {
                turn = countTurnsOne(diffNumber.get(0), sameNumber.get(0));
                startKombination = sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0);
                System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
            }

            //2 numbers same
            else if (sameNumber.size() == 1 && diffNumber.size() == 2) {
                turn = countTurnsTwo(diffNumber.get(0), diffNumber.get(1), sameNumber.get(0));
                startKombination = sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0);
                System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
            }

            //2 parallel numbers same
            else if (sameNumber.size() == 2 && diffNumber.size() == 2) {
                turn = countTurnsTwo(diffNumber.get(0), diffNumber.get(1), sameNumber.get(0));
                startKombination = sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0) + "" + sameNumber.get(0);
                System.out.println("Die Drehungen sind: " + turn + "\nyou have 2 choices: \nFirst: Die Kombinationsnummer ist: " + startKombination);
                startKombination = diffNumber.get(0) + "" + diffNumber.get(0) + "" + diffNumber.get(0) + "" + diffNumber.get(0);
                System.out.println("Second: Die Kombinationsnummer ist: " + startKombination);
            }

            // all numbers different
            else {
                int turn1 = countTurnsThree(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3]));
                int turn2 = countTurnsThree(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[3]), Integer.parseInt(arrOfStr[2]));
                int turn3 = countTurnsThree(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3]), Integer.parseInt(arrOfStr[1]));
                int turn4 = countTurnsThree(Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3]), Integer.parseInt(arrOfStr[0]));
                turn = Math.min(turn1, Math.min(turn2, Math.min(turn3, turn4)));  // take the minitest value of the four turns

                if (turn == turn1) {
                    startKombination = Integer.parseInt(arrOfStr[3]) + "" + Integer.parseInt(arrOfStr[3]) + "" + Integer.parseInt(arrOfStr[3]) + "" + Integer.parseInt(arrOfStr[3]);
                    System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
                }
                if (turn == turn2) {
                    startKombination = Integer.parseInt(arrOfStr[2]) + "" + Integer.parseInt(arrOfStr[2]) + "" + Integer.parseInt(arrOfStr[2]) + "" + Integer.parseInt(arrOfStr[2]);
                    System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
                }
                if (turn == turn3) {
                    startKombination = Integer.parseInt(arrOfStr[1]) + "" + Integer.parseInt(arrOfStr[1]) + "" + Integer.parseInt(arrOfStr[1]) + "" + Integer.parseInt(arrOfStr[1]);
                    System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
                }
                if (turn == turn4) {
                    startKombination = Integer.parseInt(arrOfStr[0]) + "" + Integer.parseInt(arrOfStr[0]) + "" + Integer.parseInt(arrOfStr[0]) + "" + Integer.parseInt(arrOfStr[0]);
                    System.out.println("Die Drehungen sind: " + turn + "\nDie Kombinationsnummer ist: " + startKombination);
                }
            }
        }
        System.out.print("_________________________________________________\nGeben Sie eine 4-stellige Kombinationsnummer ein!\n");
        return startKombination;
    }

    public static int countTurnsOne(int num1, int goal) {
        turn = 0;
        int j = num1;
        int k = num1;
        while (lockNumbers[j] != goal) {
            j++;
            countUp++;
            if (j == 10) {
                j = 0;
            }
        }
        while (lockNumbers[k] != goal) {
            k--;
            countDown++;
            if (k == -1) {
                k = 9;
            }
        }
        return turn += countUp > countDown ? countDown : countUp;
    }

    public static int countTurnsTwo(int num1, int num2, int goal) {
        turn = 0;
        int loop = 2;
        while (loop > 0) {
            countUp = 0;
            countDown = 0;
            int j = loop == 2 ? num1 : num2;
            int k = loop == 2 ? num1 : num2;
            while (lockNumbers[j] != goal) {
                j++;
                countUp++;
                if (j == 10) {
                    j = 0;
                }
            }
            while (lockNumbers[k] != goal) {
                k--;
                countDown++;
                if (k == -1) {
                    k = 9;
                }
            }
            turn += countUp > countDown ? countDown : countUp;
            loop--;
        }
        return turn;
    }

    public static int countTurnsThree(int num1, int num2, int num3, int goal) {
        turn = 0;
        int loop = 3;
        while (loop > 0) {
            countUp = 0;
            countDown = 0;
            int j = (loop == 3) ? num1 : ((loop == 2) ? num2 : num3);
            int k = (loop == 3) ? num1 : ((loop == 2) ? num2 : num3);
            while ((lockNumbers[j] != goal)) {
                j++;
                countUp++;
                if (j == 10) {
                    j = 0;
                }
            }
            while (lockNumbers[k] != goal) {
                k--;
                countDown++;
                if (k == -1) {
                    k = 9;
                }
            }
            turn += countUp > countDown ? countDown : countUp;
            loop--;
        }
        return turn;
    }
}