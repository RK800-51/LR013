import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    static List<String> strList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list elements split by space: ");
        String elements = sc.nextLine();
        strList = List.of(elements.split(" "));

        System.out.println(avg(strList));
    }

    public static Object avg(List<String> list) {
        int sum = 0;
        try {
            int[] integerList = list.stream().mapToInt(Integer::parseInt).toArray();
            sum = Arrays.stream(integerList).sum();
            for (int i = 0; i < integerList.length; i++) {
                if (integerList[i] < 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input, no strings, negatives or floats allowed");
            return null;
        }
        return sum / list.size();
    }


}
