
public class day02rangga {
    public static void main(String[] args) {
        /* ====== Challenge array ==============*/
        //int [] myNums = {1, 4, 8, 9};
        //displayArray(addOnePlus(myNums));

        //String[] myString = {"true","false","false"};
        //System.out.println(isPalindromString(myString));

        /*int [] myNums = {3,4,5,2,10};
        displayArray(orderEvenBeforeOdd(myNums));*/

        /*=============== challenge matrix ==============*/
        //displayMatrix(matrixDiagonal1(5,5));
        //displayMatrix(matrixDiagonal2(10,10));
        //displayMatrix(matrixDiagonal3(7));
        displayMatrix(matrixDiagonal4(8));

    }
    public static void displayArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void displayMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] addOnePlus(int[] arr){
        /*var newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                newArr[i] = arr[i] + 1;
            }else {
                newArr[i] = arr[i];
            }

        }
        return newArr;*/

        /*arr[arr.length-1] += 1;
        return arr;*/
        // {1, 4, 8, 9}
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) { //jika angka terakhir kurang dari 9
                arr[i]++;     // maka tinggal ditambah satu
                return arr;  // langsung dikembalikan
            }
            arr[i] = 0; // jika angka lebih dari sembilan maka digit terakhir jadi 0
        }

        // ini hanya ke run jika semua digit {9, 9, 9, 9}
        int[] result = new int[arr.length + 1]; // dan ditambahkan satu element dikanan
        result[0] = 1; //
        return result;
    }

    public static boolean isPalindromString(String[] arr) {
        // alasan kenapa kita bagi array.length/2 ?
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static int[] orderEvenBeforeOdd(int[] arr){
        /*List listEven = new ArrayList<>();
        List listodd = new ArrayList<>();
        for (int j : arr) {
            if (j % 2 == 0) {
                listEven.add(j);
            }else {
                listodd.add(j);
            }
        }
        int index = 0;
        for (Object i : listEven) {
            arr[index] = (int) i;
            index++;
        }

        for (Object i : listodd) {
            arr[index] = (int) i;
            index++;
        }
        return arr;*/
        int left = 0;
        int right = arr.length - 1;

        //using pointer
        while (left < right) {
            // Move left until an odd number is found
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // Move right until an even number is found
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }

            // Swap the odd number on the left with the even number on the right
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        /* ================ Bubble Sort Algorithm ========================= */
        // Now sort the even numbers (from 0 to left-1) using Bubble Sort
        for (int i = 0; i < left - 1; i++) {
            for (int j = 0; j < left - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the element is greater than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Sort the odd numbers (from left to arr.length-1) using Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = left; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the element is greater than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //====================================================================//
        return arr;
    }

    public static int[][] matrixDiagonal1(int n, int m){
        int[][] matrix = new int[n][m];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    matrix[row][col] = row+1;
                } else if (row > col) {
                    matrix[row][col] = 20;
                } else {
                    matrix[row][col] = 10;
                }

            }
        }
        return matrix;
    }

    public static int[][] matrixDiagonal2(int n, int m){
        int[][] matrix = new int[n][m];
        int counter = n;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    matrix[row][col] = counter;
                    counter--;
                } else if (row > col) {
                    matrix[row][col] = 10;
                } else {
                    matrix[row][col] = 20;
                }

            }
        }
        return matrix;
    }

    public static int[][] matrixDiagonal3(int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == 0){
                    matrix[row][col] = col;
                    //counter++;
                } else if (col == 0) {
                    matrix[row][col] = row;
                } else if (row == matrix.length-1){
                    matrix[row][col] = row+col;
                } else if (col == matrix.length-1){
                    matrix[row][col] = row+col;
                }

            }
        }
        return matrix;
    }

    public static int[][] matrixDiagonal4(int n){
        int[][] matrix = new int[n][n];
        //int sum = 0;
        for (int row = 0; row < matrix.length-1; row++) {

            for (int col = 0; col < matrix[row].length-1; col++) {
                matrix[row][col] = row + col;
                matrix[row][n-1] += matrix[row][col];;
                matrix[n-1][col] += matrix[row][col];;
            }
        }
        for (int i = 0; i < n-1; i++) {
            matrix[n-1][n-1] += matrix[n-1][i];;

        }
        return matrix;
    }
}
