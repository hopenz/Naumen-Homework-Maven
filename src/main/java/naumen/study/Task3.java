package naumen.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task3 {

    private final ArrayList<Employee> employees = (ArrayList<Employee>) Stream.of(
                    new Employee("Иванов Иван Иванович", 25, "IT", 100000.0),
                    new Employee("Петров Петр Петрович", 30, "HR", 50000.0),
                    new Employee("Сидоров Сидор Сидорович", 40, "IT", 150000.0),
                    new Employee("Кузнецов Кузнец Кузнецович", 35, "HR", 80000.0),
                    new Employee("Васильев Василий Васильевич", 28, "IT", 120000.0),
                    new Employee("Смирнов Смирн Смирнович", 32, "HR", 70000.0))
            .collect(Collectors.toList());

    public void ageMore30() {
        ArrayList<Employee> listOfFilter = (ArrayList<Employee>) employees.stream()
                .filter(e -> e.getAge() > 30).collect(Collectors.toList());

        System.out.println("Весь список сотрудников: " + employees);
        System.out.println("Сотрудники старше 30: " + listOfFilter);
    }
}
