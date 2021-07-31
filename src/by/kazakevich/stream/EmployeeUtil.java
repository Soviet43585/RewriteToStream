package by.kazakevich.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeUtil {

  public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
    return employeeList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
  }

  public static Object calculateAverageSalary(List<Employee> employeeList) {
    return employeeList.stream().mapToDouble(Employee::getSalary).average();
  }

  public static List<Employee> filterByName(List<Employee> employeeList, String name) {
    return employeeList.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
  }

  public static List<Employee> filterByNameAndSortBySalaryDesc(List<Employee> employeeList,
                                                               String name) {
    return employeeList.stream().filter(o -> o.getName().equals(name)).sorted((Comparator.comparing(Employee::getSalary))).collect(Collectors.toList());
  }

  public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList,
                                                          String name) {
    return employeeList.stream().filter(o -> o.getName().equals(name)).max(Comparator.comparing((Employee::getSalary))).get();
  }
}
