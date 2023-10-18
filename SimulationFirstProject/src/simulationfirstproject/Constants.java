package simulationfirstproject;

public class Constants {

    static int getIat(int num) {
        if (num > 0 && num <= 24) {
            return 1;
        } else if (num >= 25 && num <= 64) {
            return 2;
        } else if (num >= 65 && num <= 84) {
            return 3;
        } else if (num >= 85 && num <= 99) {
            return 4;
        }
        return 0;
    }

    static int clk = 0;
    static int q = 0;

    static boolean isFree(int stEnd) {
        if (q == 0) {
            return stEnd <= clk;
        } else {
            return stEnd <= (clk + q);
        }
    }

    static int[] iats = {0, 26, 98, 90, 26, 42, 74, 80, 68, 22, 48, 34, 45, 24, 34, 63, 38, 80, 42, 56, 89, 18, 51, 71, 16, 92, 87};
    static int[] sts = {95, 21, 51, 92, 89, 38, 13, 61, 50, 49, 39, 53, 88, 01, 81, 53, 81, 64, 01, 67, 01, 47, 75, 57, 87, 47, 67};

    static String convertToString(int x) {
        return String.valueOf(x);
    }

}
