package com.sage;

public class Main {
    public static void main(String[] args) {
        double answer = 0;

        outerLoop:
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    for(int l = 0; l < 10; l++) {
                        for(int m = 0; m < 10; m++) {
                            for(int n = 0; n < 10; n++) {
                                for(int o = 0; o < 10; o++) {
                                    for(int p = 0; p < 10; p++) {
                                        double sqrt = Math.sqrt(Long.parseLong("1" + i +
                                                "2" + j +
                                                "3" + k +
                                                "4" + l +
                                                "5" + m +
                                                "6" + n +
                                                "7" + o +
                                                "8" + p +
                                                "9"));
                                        System.out.println("Checking if " + "1" + i +
                                                "2" + j +
                                                "3" + k +
                                                "4" + l +
                                                "5" + m +
                                                "6" + n +
                                                "7" + o +
                                                "8" + p +
                                                "9 is a perfect square, sqrt is " + String.format("%.5f", sqrt));

                                        if(sqrt % 1.0 == 0) {
                                            answer = sqrt;
                                            break outerLoop;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(String.format("%.0f", answer));
    }
}
