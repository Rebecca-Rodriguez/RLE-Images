import java.util.Scanner;

public class RleProgram {
    // Converts byte array into string of hexadecimal
    public static String toHexString(byte[] data) {
        String toHexString = "";
        String[] hexString = new String[data.length];

        // assign each data the hexadecimal equivalent
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                hexString[i] = "0";
            }
            if (data[i] == 1) {
                hexString[i] = "1";
            }
            if (data[i] == 2) {
                hexString[i] = "2";
            }
            if (data[i] == 3) {
                hexString[i] = "1";
            }
            if (data[i] == 4) {
                hexString[i] = "4";
            }
            if (data[i] == 5) {
                hexString[i] = "5";
            }
            if (data[i] == 6) {
                hexString[i] = "6";
            }
            if (data[i] == 7) {
                hexString[i] = "7";
            }
            if (data[i] == 8) {
                hexString[i] = "8";
            }
            if (data[i] == 9) {
                hexString[i] = "9";
            }
            if (data[i] == 10) {
                hexString[i] = "a";
            }
            if (data[i] == 11) {
                hexString[i] = "b";
            }
            if (data[i] == 12) {
                hexString[i] = "c";
            }
            if (data[i] == 13) {
                hexString[i] = "d";
            }
            if (data[i] == 14) {
                hexString[i] = "e";
            }
            if (data[i] == 15) {
                hexString[i] = "f";
            }
        }

        // link together the string array and to return new hexadecimal string
        for (int j = 0; j < hexString.length; j++) {
            toHexString += hexString[j];
        }
        return toHexString;
    }

    // Returns the number of runs of data in an image data set
    public static int countRuns(byte[] flatData) {
        int count = 1;
        int fifteenCount = 1;

        // used to count the runs
        for (int i = 0; i < flatData.length - 1; i++) {
            if (flatData[i] != flatData[i + 1]) {
                count++;
                fifteenCount = 1;
            }

            if (flatData[i] == flatData[i + 1]) {
                fifteenCount++;
            }

            if (fifteenCount >= 16) {
                fifteenCount = 1;
                count++;
            }
        }
        return count;
    }

    // Encodes the raw data passed in
    public static byte[] encodeRle(byte[] flatData) {
        byte count1 = 1;
        int count2 = 0;
        byte count3 = 0;
        byte[] encodeRle = new byte[countRuns(flatData) * 2];       // times by 2 to get length of encoded byte array

        for (int i = 0; i < (flatData.length - 1); i++) {
            count3 = flatData[i];
            if (flatData[i] == flatData[i + 1] && count1 < 15) {
                count1++;
            }
            else {
                encodeRle[count2] = count1;
                count1 = 1;
                encodeRle[count2 + 1] = count3;
                count2 += 2;
            }
        }

        encodeRle[count2] = count1;
        encodeRle[count2 + 1] = count3;
        encodeRle[encodeRle.length - 1] = flatData[flatData.length - 1];

        return encodeRle;
    }

    // Returns decompressed length of RLE data
    public static int getDecodedLength(byte[] rleData) {
        int decodedLength = 0;

        for (int i = 0; i < (rleData.length / 2); i++) {        // remember the length is doubled
            decodedLength += rleData[2 * i];
        }

        return decodedLength;

    }

    // Returns the decoded data set from RLE encoded data
    public static byte[] decodeRle(byte[] rleData) {
        byte[] decodeRle = new byte[getDecodedLength(rleData)];
        int count;
        int counter1 = 0;

        for (int i = 0; i < (rleData.length / 2); i++) {
            count = rleData[2 * i];
            for (int j = 0; j < count; j++) {
                decodeRle[counter1] = rleData[1 + (2 * i)];
                counter1++;
            }
        }
        return (decodeRle);
    }

    // Translates a string in hexadecimal formal into byte data
    public static byte[] stringToData(String dataString) {
        byte[] stringToData = new byte[dataString.length()];

        for (int i = 0; i < dataString.length(); i++) {
            if (dataString.substring(i, i + 1).equals("0")) {
                stringToData[i] = 0;
            }
            if (dataString.substring(i, i + 1).equals("1")) {
                stringToData[i] = 1;
            }
            if (dataString.substring(i, i + 1).equals("2")) {
                stringToData[i] = 2;
            }
            if (dataString.substring(i, i + 1).equals("3")) {
                stringToData[i] = 3;
            }
            if (dataString.substring(i, i + 1).equals("4")) {
                stringToData[i] = 4;
            }
            if (dataString.substring(i, i + 1).equals("5")) {
                stringToData[i] = 5;
            }
            if (dataString.substring(i, i + 1).equals("6")) {
                stringToData[i] = 6;
            }
            if (dataString.substring(i, i + 1).equals("7")) {
                stringToData[i] = 7;
            }
            if (dataString.substring(i, i + 1).equals("8")) {
                stringToData[i] = 8;
            }
            if (dataString.substring(i, i + 1).equals("9")) {
                stringToData[i] = 9;
            }
            if (dataString.substring(i, i + 1).equals("A") || dataString.substring(i, i + 1).equals("a")) {
                stringToData[i] = 10;
            }
            if (dataString.substring(i, i + 1).equals("B") || dataString.substring(i, i + 1).equals("b")) {
                stringToData[i] = 11;
            }
            if (dataString.substring(i, i + 1).equals("C") || dataString.substring(i, i + 1).equals("c")) {
                stringToData[i] = 12;
            }
            if (dataString.substring(i, i + 1).equals("D") || dataString.substring(i, i + 1).equals("d")) {
                stringToData[i] = 13;
            }

            if (dataString.substring(i, i + 1).equals("E") || dataString.substring(i, i + 1).equals("e")) {
                stringToData[i] = 14;
            }

            if (dataString.substring(i, i + 1).equals("F") || dataString.substring(i, i + 1).equals("f")) {
                stringToData[i] = 15;
            }
        }
        return (stringToData);
    }

    // Translates RLE data into a human-readable representation
    public static String toRleString(byte[] rleData) {
        String rleString = "";
        String[] rleStringArray = new String[rleData.length];

        for (int i = 0; i < rleData.length; i++) {
            // Display the run length in decimal and the run value in hexadecimal
            if (rleData[i] == 0) {rleStringArray[i] = "0";}
            if (rleData[i] == 1) {rleStringArray[i] = "1";}
            if (rleData[i] == 2) {rleStringArray[i] = "2";}
            if (rleData[i] == 3) {rleStringArray[i] = "3";}
            if (rleData[i] == 4) {rleStringArray[i] = "4";}
            if (rleData[i] == 5) {rleStringArray[i] = "5";}
            if (rleData[i] == 6) {rleStringArray[i] = "6";}
            if (rleData[i] == 7) {rleStringArray[i] = "7";}
            if (rleData[i] == 8) {rleStringArray[i] = "8";}
            if (rleData[i] == 9) {rleStringArray[i] = "9";}
            if (rleData[i] == 10) {rleStringArray[i] = "10";}
            if (rleData[i] == 11) {rleStringArray[i] = "11";}
            if (rleData[i] == 12) {rleStringArray[i] = "12";}
            if (rleData[i] == 13) {rleStringArray[i] = "13";}
            if (rleData[i] == 14) {rleStringArray[i] = "14";}
            if (rleData[i] == 15) {rleStringArray[i] = "15";}
            if (i % 2 == 1) {
                if (rleData[i] == 10) {rleStringArray[i] = "a";}
                if (rleData[i] == 11) {rleStringArray[i] = "b";}
                if (rleData[i] == 12) {rleStringArray[i] = "c";}
                if (rleData[i] == 13) {rleStringArray[i] = "d";}
                if (rleData[i] == 14) {rleStringArray[i] = "e";}
                if (rleData[i] == 15) {rleStringArray[i] = "f";}
            }
        }

        // To add the delimiter between runs
        for (int j = 0; j < rleStringArray.length; j++) {
            rleString += rleStringArray[j];
            if (j % 2 == 1) {rleString += ":";}
        }

        return rleString.substring(0, rleString.length() - 1);
    }

    // Translates a string in human-readable RLE format (with delimiters) into RLE byte data
    public static byte[] stringToRle(String rleString) {
        // First, count the delimiters
        int counter = 0;
        for (int i = 0; i < rleString.length(); i++) {
            if (rleString.charAt(i) == ':') {counter++;}
        }

        // Second, assign two string arrays to each side of delimiter
        String[] firstHalf = new String[(counter + 1) * 2];
        String[] secondHalf = rleString.split(":");

        for (int i = 0; i < secondHalf.length; i++) {
            if (secondHalf[i].length() == 2) {
                firstHalf[2 * i] = secondHalf[i].substring(0, 1);
                firstHalf[2 * i + 1] = secondHalf[i].substring(1, 2);
            }
            if (secondHalf[i].length() == 3) {
                firstHalf[2 * i] = secondHalf[i].substring(0, 2);
                firstHalf[2 * i + 1] = secondHalf[i].substring(2, 3);
            }
        }

        // Third, convert the letters into bytes
        for (int j = 0; j < firstHalf.length; j++) {
            if (firstHalf[j].equals("a") || firstHalf[j].equals("A")) {firstHalf[j] = "10";}
            if (firstHalf[j].equals("b") || firstHalf[j].equals("B")) {firstHalf[j] = "11";}
            if (firstHalf[j].equals("c") || firstHalf[j].equals("C")) {firstHalf[j] = "12";}
            if (firstHalf[j].equals("d") || firstHalf[j].equals("D")) {firstHalf[j] = "13";}
            if (firstHalf[j].equals("e") || firstHalf[j].equals("E")) {firstHalf[j] = "14";}
            if (firstHalf[j].equals("f") || firstHalf[j].equals("F")) {firstHalf[j] = "15";}
        }

        // Lastly, parse intergers into new byte array
        byte[] rleData = new byte[(counter + 1) * 2];

        for (int k = 0; k < rleData.length; k++) {rleData[k] = (byte) Integer.parseInt(firstHalf[k]);}

        return rleData;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variables
        boolean notZero = false;                 // This is used for the do while loop
        int userMenuOption = 0;
        byte[] flatData = null;
        String userInput;                        // The user's filename
        String rleString;                        // Used for option 3
        String rleHexString;                     // Used in option 4
        String hexStringFlat;                    // used in option 5

        // 1. Display welcome message
        System.out.println("Welcome to the RLE image encoder! \n");

        // 2. Display color test with the message
        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);
        System.out.println();
        System.out.println();

        do{
            // 3. Display the menu - Part A: while loop or if-else chains
            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data");
            System.out.println();

            // 4. Prompt for input
            System.out.print("Select a Menu Option: ");
            userMenuOption = input.nextInt();

            // if user selects "0" to exit the program
            if (userMenuOption == 0) {
                System.out.println("");
                notZero = false;
                break;
            }

            if (userMenuOption == 1) {
                System.out.print("Enter name of file to load: ");
                userInput = input.next();                            // to store the filename the user inputs
                flatData = ConsoleGfx.loadFile(userInput);               // use the loadFile function on whatever the user inputted
                System.out.println();
            }

            if (userMenuOption == 2) {
                System.out.print("Test image data loaded. \n");
                flatData = ConsoleGfx.testImage;
                System.out.println();
            }

            if (userMenuOption == 3) {
                System.out.print("Enter an RLE string to be decoded: ");
                rleString = input.next();                           // user inputs the string to be decoded and its assigned
                flatData = decodeRle(stringToRle(rleString));
                System.out.println();
            }

            if (userMenuOption == 4) {
                System.out.print("Enter the hex string holding RLE data: ");
                rleHexString = input.next();          // user inputs the hex string holding the RLE data
                flatData = decodeRle(stringToData(rleHexString));
                System.out.println();
            }

            if (userMenuOption == 5) {
                System.out.print("Enter the hex string holding flat data: ");
                hexStringFlat = input.next();                  // user inputs hex string holding flat data
                flatData = stringToData(hexStringFlat);
                System.out.println();
            }

            if (userMenuOption == 6) {
                System.out.print("Displaying image... \n");
                ConsoleGfx.displayImage(flatData);
                System.out.println();
            }

            if (userMenuOption == 7) {
                System.out.print("RLE representation: " + toRleString(encodeRle(flatData)));
                System.out.println();
            }

            if (userMenuOption == 8) {
                System.out.print("RLE hex values: " + toHexString(encodeRle(flatData)));
                System.out.println();
                System.out.println();
            }
            if (userMenuOption == 9) {
                System.out.print("Flat hex values: " + toHexString(flatData));
                System.out.println();
                System.out.println();
            }
        } while (notZero == false);
    }
}
