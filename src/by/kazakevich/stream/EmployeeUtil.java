package by.kazakevich.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeUtil {

  public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
    Map<String, List<Employee>> resultMap = new HashMap<>();
    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.get(i);
      List<Employee> employeeSubList = resultMap
          .getOrDefault(employee.getJobTitle(), new ArrayList<>());
      employeeSubList.add(employee);
      resultMap.put(employee.getJobTitle(), employeeSubList);
    }
    return resultMap;
  }

  public static double calculateAverageSalary(List<Employee> employeeList) {
    int sum = 0;
    int count = 0;
    for (Employee employee : employeeList) {
      sum += employee.getSalary();
      count++;
    }
    return (double) sum / count;
  }

  public static List<Employee> filterByName(List<Employee> employeeList, String name) {
    List<Employee> resultList = new ArrayList<>();
    for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }
    return resultList;
  }

  public static List<Employee> filterByNameAndSortBySalaryDesc(List<Employee> employeeList,
      String name) {
    List<Employee> resultList = new ArrayList<>();
    for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }
    resultList.sort(Comparator.comparing(Employee::getSalary).reversed());
    return resultList;
  }

  public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList,
      String name) {
    List<Employee> resultList = new ArrayList<>();
    for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }
    return Collections.max(resultList, Comparator.comparing(Employee::getSalary));
  }
}
