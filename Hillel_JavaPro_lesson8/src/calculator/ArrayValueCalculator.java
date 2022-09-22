package calculator;

import myexceptions.ArrayDataException;
import myexceptions.ArraySizeException;

public class ArrayValueCalculator {

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", null},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"2", "2", "3", "4"}
        };
        try {
            doCal(arr);
        } catch (ArraySizeException ase) {
            System.out.println("ArraySizeException: " + ase.getMessage());
        } catch (ArrayDataException ade) {
            System.out.println("ArrayDataException: " + ade.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void doCal(String[][] arr) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new ArraySizeException("Масив має некоректний розмір");
        }
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new ArraySizeException("Масив має некоректний розмір");
                }
                if (arr[i].length > 0) {
                    System.out.println("строка " + (i + 1) + " кількість ел-ів " + arr[i].length);
                    for (int j = 0; j < arr[i].length; j++) {
                        try {
                            sum += Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException e) {
                            throw new ArrayDataException("Не змогли перетворити строку на число, елемент [" +
                                    (i + 1) + "][" + (j+1) + "] = " + arr[i][j]);
                        }
                    }
                }
            }
        }
        System.out.println("Сума елементів масиву = " + sum);
    }
}
