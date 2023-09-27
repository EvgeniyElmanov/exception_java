package task_3;

import java.util.Scanner;

public class EmptyStringExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя.");
            }
            
            System.out.println("Вы ввели: " + input);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

