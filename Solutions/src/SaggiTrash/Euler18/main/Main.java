package SaggiTrash.Euler18.main;

import java.util.ArrayList;

public class Main {
    public static String pyramidString = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";
    public static ArrayList<ArrayList<Integer>> pyramidList = new ArrayList<>();

    public static void main(String[] args) {
        parsePyramidString();

        for(int i = pyramidList.size() - 2; i >= 0; i--) {
            ArrayList<Integer> belowList = pyramidList.get(i + 1);
            ArrayList<Integer> currList = pyramidList.get(i);
            for(int j = 0; j < currList.size(); j++) {
                if(belowList.get(j) + currList.get(j) > belowList.get(j + 1) + currList.get(j)) {
                    currList.set(j, belowList.get(j) + currList.get(j));
                } else {
                    currList.set(j, belowList.get(j + 1) + currList.get(j));
                }
            }
        }
        System.out.println(pyramidList.get(0).get(0));
    }

    public static void parsePyramidString() {
        int pyramindStringCurrPos = 0;
        int rows = pyramidString.length() - pyramidString.replace("\n", "").length() + 1;

        String spaceSeparatedPyramid = pyramidString.replaceAll("\n", " ");

        for(int numInRow = 1; numInRow <= rows; numInRow++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int i = 0; i < numInRow; i++) {
                StringBuilder valueSB = new StringBuilder();
                while(spaceSeparatedPyramid.charAt(pyramindStringCurrPos) != ' ') {
                    valueSB.append(spaceSeparatedPyramid.charAt(pyramindStringCurrPos));
                    pyramindStringCurrPos++;
                }
                pyramindStringCurrPos++;
                rowList.add(Integer.parseInt(valueSB.toString()));
            }
            pyramidList.add(rowList);
        }
        System.out.println(pyramidList);
    }

}
