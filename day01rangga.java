import java.util.Scanner;

public class day01rangga {
    public static void main(String[] args) {
        //iteration1(5);
        // iteration2(5);
        //iteration3(5);
        //iteration4(5);
        //iteration5(5);
        //iteration6(5);
        //iteration7();
        //iteration9(9);
        //iteration9(5);
        //iteration10(9);
        //iteration10(5);
        //Challenge 2: String dan Math
        // Challenge Revere
        //int hasilReverse = Reverse(4563);
        //System.out.print(hasilReverse);

        //Challenge IsPalindrome
        System.out.print(isPalindrome(101));

        // Challenge Capitalize
        //System.out.println(Capitalize("null"));

        //Challenge IsNoDuplicateChar
        //System.out.println(IsNoDuplicateChar("code"));

        //System.out.println(isBrace("((()"));

    }

    public static void iteration1(int n) {
        //pindah baris
        int counter = 1;
        for (int i = 0; i < n; i++) {
            // cetak bintang
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d ", counter);
                counter++;
            }
            System.out.println();
        }
    }

    public static void iteration2(int n) {
        for (int i = 1; i <= n; i++) {
            int counter = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void iteration3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.printf("%4d ", j);

            }
            System.out.println();
        }
    }

    public static void iteration4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void iteration5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.printf("%2d ", j);
                } else if (i < j) {
                    System.out.printf("%2d ", 10);
                } else {
                    System.out.printf("%2d ", 20);
                }
            }
            System.out.println();
        }
    }

    public static void iteration6(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == j) {
                    System.out.printf("%2d ", j);
                } else if (i < j) {
                    System.out.printf("%2d ", 10);
                } else {
                    System.out.printf("%2d ", 20);
                }
            }
            System.out.println();
        }
    }

    public static void iteration7() {
        Scanner scan = new Scanner(System.in);
        System.out.print("input jumlah baris piramid : ");
        int n = scan.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.printf("%4d ", j);

            }
            for (int j = 2; j <= i; j++) {
                System.out.printf("%4d ", j);
            }
            System.out.println();
        }
    }

    public static void iteration9(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for (int j = n; j >= 1; j--) {
                    System.out.printf("%2d ", j);
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    System.out.printf("%2d ", j);
                }
            }
            System.out.println();
        }
    }

    public static void iteration10(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= n; j++) {
                    if (j % 2 == 0) {
                        System.out.printf("%2d ", j);
                    } else {
                        System.out.print("-");
                    }
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (j % 2 != 0) {
                        System.out.printf("%2d ", j);
                    } else {
                        System.out.print("-");
                    }

                }
            }
            System.out.println();
        }
    }

    public static int Reverse(int n) {
        //Scanner input = new Scanner(System.in);

        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return reversed;
    }

    public static boolean isPalindrome(int n) {
        return Reverse(n) == n;
    }

    public static String Capitalize(String input) {
        if (input == " " || input == "" || input == null) {
            return "";
        }
        input = input.trim();
        StringBuilder result = new StringBuilder();

        String[] perKata = input.split(" ");
        for (String kata : perKata) {
            result.append(Character.toTitleCase(kata.charAt(0)));
            result.append(kata.substring(1));
            result.append(" ");
        }
        return result.toString();
    }

    public static boolean IsNoDuplicateChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBrace(String s) {
        int udahKetutup = 0;

        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);

            if (brace == '(') {
                udahKetutup++;
            } else if (brace == ')') {
                udahKetutup--;
                if (udahKetutup < 0) {
                    return false;
                }
            }
        }
        return udahKetutup == 0;
    }
}



