// Формат сдачи: ссылка на подписанный git-проект.
// Задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре 
// будут повторяющиеся имена с разными телефонами, их необходимо 
// считать, как одного человека с разными телефонами. Вывод должен 
// быть отсортирован по убыванию числа телефонов.


import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        TreeMap<String, List<String>> phoneBook = new TreeMap<>(Comparator.reverseOrder());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Возможности программы: 1 - добавление контакта; 2 - поиск контакта; 3 - удаление контакта; 4 - показать всю книгу; 5 -  выход из программы. Выберите действие: ");
            String action = scanner.next();

            if (action.equals("1")) { // Добавление контакта
                System.out.println("Укажите имя контакта: ");
                String contName = scanner.next();
                System.out.println("Укажите номер телефона: ");
                String numPhone = scanner.next();

                List<String> phones = phoneBook.getOrDefault(contName, new ArrayList<>());
                phones.add(numPhone);
                phoneBook.put(contName, phones);

                System.out.println("Контакт " + contName + " успешно добавлен!");
            } else if (action.equals("2")) { // Поиск контакта
                System.out.println("Укажите имя контакта: ");
                String searchName = scanner.next();
                List<String> phones = phoneBook.getOrDefault(searchName, new ArrayList<>());

                if (!phones.isEmpty()) {
                    System.out.println("Номера телефонов для контакта " + searchName + ":");
                    for (String phone : phones) {
                        System.out.println(phone);
                    }
                } else {
                    System.out.println("Контакт не найден.");
                }
            } else if (action.equals("3")) { // Удаление контакта
                System.out.println("Укажите имя контакта: ");
                String delName = scanner.next();
                List<String> removedPhones = phoneBook.remove(delName);
                if (removedPhones != null) {
                    System.out.println("Контакт " + delName + " успешно удален.");
                } else {
                    System.out.println("Контакт не найден.");
                }
            } else if (action.equals("4")) { // Вывод всех контактов
                System.out.println("Телефонная книга:");
                for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else if (action.equals("5")) { // Выход из программы
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }
}




