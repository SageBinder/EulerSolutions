package euler31.main;

public class Euler31 {

    public static void main(String[] args) {
        int loops = 0;
        int sum = 1;
        for(int i = 0; i <= 200; i++) { // 1p loop
            for(int j = 0; j <= 200 - i; j += 2) { // 2p loop
                for(int k = 0; k <= 200 - i - j; k += 5) { //5p loop
                    for(int l = 0; l <= 200 - i - j - k; l += 10) { // 10p loop
                        for(int m = 0; m <= 200 - i - j - k - l; m += 20) { // 20p loop
                            for(int n = 0; n <= 200 - i - j - k - l - m; n += 50) { // 5p loop
                                for(int o = 0; o <= 200 - i - j - k - l - m - n; o += 100) { // £1 loop
                                    loops++;
                                    if(i + j + k + l + m + n + o == 200) {
                                        sum++;
                                        System.out.println(i + " + " + j  + " + " + k + " + " + l + " + " + m + " + " + n + ", coins sum: " + (i + j + k + l + m + n) + ", sum: " + sum);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum + ", loops: " + loops);
    }
}
