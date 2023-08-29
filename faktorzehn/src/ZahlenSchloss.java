import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ZahlenSchloss {

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
            } else {
                pinIsCorrect(startKombination);
            }
        }
    }

    //when the startKombination is correct (4 digit-number)
    public static String pinIsCorrect(String startKombination) {
        int drehung = 0;
        List<Integer> parallelList = new ArrayList<>();    //array to save the parallel numbers and their index
        String[] arrOfStr = startKombination.split("", 4);  //split the first four inputs of startKombination
        int[] nummern = {Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3])};   //change the input to integer and save it in int array.
        if (Arrays.stream(arrOfStr).allMatch(s -> s.equals(arrOfStr[0]))) {     //when the array arrOfStr has same numbers.
            System.out.println("Die Drehungen sind: " + drehung + "\nDie Kombinationsnummer ist: " + startKombination);
        } else {
            for (int i = 0; i < nummern.length; i++) {
                for (int j = i + 1; j < nummern.length; j++) {
                    if (nummern[i] == nummern[j]) {
                        parallelList.add(i);    //saving the index of parallel numbers, used array because I can have (size, index)
                    }
                }
            }
            if (parallelList.size() == 3) { //case three parallel numbers
                drehung = 1;
                startKombination = nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)];
                System.out.println("Die Drehungen sind: " + drehung + "\nDie Kombinationsnummer ist: " + startKombination);
            } else if (parallelList.size() == 2) {  //case two parallel numbers
                drehung = 2;
                startKombination = nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)];
                System.out.println("Die Drehungen sind: " + drehung + "\nEntweder die Kombinationsnummer ist: " + startKombination);
                startKombination = nummern[parallelList.get(1)] + "" + nummern[parallelList.get(1)] + "" + nummern[parallelList.get(1)] + "" + nummern[parallelList.get(1)];
                System.out.println("Oder die Kombinationsnummer ist: " + startKombination);
            } else if (parallelList.size() == 1) {  //case one parallel numbers
                drehung = 2;
                startKombination = nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)] + "" + nummern[parallelList.get(0)];
                System.out.println("Die Drehungen sind: " + drehung + "\nDie Kombinationsnummer ist: " + startKombination);
            } else {    //case all numbers are different
                drehung = 3;
                System.out.println("Die Drehungen sind: " + drehung + "\nDie Kombinationsnummeren sind: ");
                for (int i = 0; i < nummern.length; i++) {
                    startKombination = nummern[i] + "" + nummern[i] + "" + nummern[i] + "" + nummern[i];
                    System.out.println("Option " + (i + 1) + ": " + startKombination);
                }
            }
        }
        System.out.print("_________________________________________________\nGeben Sie eine 4-stellige Kombinationsnummer ein!\n");
        return startKombination;
    }
}

