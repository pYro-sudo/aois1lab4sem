package by.losik.Lab1sem4aois;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try{
            System.out.println("""
                Enter the operation:
                    1 - add numbers;
                    2 - subtract numbers;
                    3 - multiply numbers;
                    4 - divide numbers;
                    5 - add fp numbers;
                    any other number - exit;
                """);
            OperationsImpl operations = new OperationsImpl();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1 -> {
                    System.out.println("Enter the first number, then the second one");
                    var firstBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    var secondBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    System.out.println("The first "+firstBinInput.toString() + "\nsecond " + secondBinInput.toString());
                    System.out.println("The result"+operations.addBinaryNumbers(firstBinInput, secondBinInput) +
                            "\nthe decimal " + operations.addBinaryNumbers(firstBinInput, secondBinInput).getDecimal());
                }
                case 2 -> {
                    System.out.println("Enter the first number, then the second one");
                    var firstBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    var secondBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    System.out.println("The first "+firstBinInput.toString() + "\nsecond " + secondBinInput.toString());
                    System.out.println("The result"+operations.subtractBinaryNumbers(firstBinInput, secondBinInput) +
                            "\nthe decimal " + operations.subtractBinaryNumbers(firstBinInput, secondBinInput).getDecimal());
                }
                case 3 -> {
                    System.out.println("Enter the first number, then the second one");
                    var firstBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    var secondBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    System.out.println("The first "+firstBinInput.toString() + "\nsecond " + secondBinInput.toString());
                    System.out.println("The result"+operations.multiplyBinaryNumbers(firstBinInput, secondBinInput) +
                            "\nthe decimal " + operations.multiplyBinaryNumbers(firstBinInput, secondBinInput).getDecimal());
                }
                case 4 -> {
                    System.out.println("Enter the first number, then the second one");
                    var firstBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    var secondBinInput = operations.parseDoubleToBinary(scanner.nextDouble());
                    System.out.println("The first "+firstBinInput.toString() + "\nsecond " + secondBinInput.toString());
                    System.out.println("The result"+operations.divideBinaryNumbers(firstBinInput, secondBinInput) +
                            "\nthe decimal " + operations.divideBinaryNumbers(firstBinInput, secondBinInput).getDecimal());
                }
                case 5 -> {
                    System.out.println("Enter the first number, then the second one");
                    var firstBinInput = new FloatingPoint().convertBinaryFixedToFloating(operations.parseDoubleToBinary(scanner.nextDouble()));
                    var secondBinInput = new FloatingPoint().convertBinaryFixedToFloating(operations.parseDoubleToBinary(scanner.nextDouble()));
                    System.out.println("The first "+new FloatingPoint().convertBinaryFixedToFloating(operations.parseDoubleToBinary(scanner.nextDouble())).toString() +
                            "\nsecond " + new FloatingPoint().convertBinaryFixedToFloating(operations.parseDoubleToBinary(scanner.nextDouble())));
                    System.out.println("The result"+operations.addFloatingPointNumbers(firstBinInput, secondBinInput).toString() +
                            "\nthe decimal " + operations.addFloatingPointNumbers(firstBinInput, secondBinInput).getDecimal());
                }
                default -> System.exit(1);

            }
        }
        catch (Exception e){
            e.printStackTrace();
            main(new String[0]);
        }
    }
}
