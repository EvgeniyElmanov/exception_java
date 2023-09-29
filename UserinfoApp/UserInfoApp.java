package UserinfoApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class UserInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private String phoneNumber;
    private char gender;

    public UserInfo(String firstName, String lastName, String middleName, String dateOfBirth, String phoneNumber, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender;
    }
}

public class UserInfoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилию Имя Отчество через пробел:");
        String fullName = scanner.nextLine();

        String[] fullNameParts = fullName.split(" ");
        if (fullNameParts.length != 3) {
            System.out.println("Ошибка: Введите Фамилию Имя Отчество через пробел.");
            return;
        }

        String lastName = fullNameParts[0];
        String firstName = fullNameParts[1];
        String middleName = fullNameParts[2];

        String[] fields = new String[3];
        String[] fieldNames = {
            "Дата рождения (в формате dd.mm.yyyy)", "Номер телефона (без пробелов и символов)", "Пол (f/m)"
        };

        for (int i = 0; i < fieldNames.length; i++) {
            System.out.println("Введите " + fieldNames[i] + ":");
            fields[i] = scanner.nextLine();
        }

        if (hasEmptyFields(fields)) {
            System.out.println("Ошибка: Введите все необходимые данные.");
            return;
        }

        String dateOfBirth = fields[0];
        String phoneNumber = fields[1];
        String genderInput = fields[2];

        char gender = genderInput.charAt(0);

        // Проверка формата даты рождения
        Pattern datePattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        Matcher dateMatcher = datePattern.matcher(dateOfBirth);

        // Проверка формата номера телефона
        Pattern phonePattern = Pattern.compile("\\d+");
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

        if (!dateMatcher.matches() || !phoneMatcher.matches() || (gender != 'f' && gender != 'm')) {
            System.out.println("Ошибка: Неправильный формат данных.");
            return;
        }

        UserInfo userInfo = new UserInfo(firstName, lastName, middleName, dateOfBirth, phoneNumber, gender);

        // Создание файла с именем на основе Фамилии
        String fileName = lastName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userInfo.toString());
            writer.newLine();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean hasEmptyFields(String[] fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}



