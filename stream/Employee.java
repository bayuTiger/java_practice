package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 以下の文を Stream API を使ったかたちへと書き換える
// 社員のリストを年齢の昇順に並び替えたリストを作り、それらを標準出力する。
// 		class Employee {
// 			public final String name;
// 			public final int age;
// 			public Employee(String name, int age) {
// 				this.name = name;
// 				this.age = age;
// 			}
// 			@Override
// 			public String toString() {
// 				return "Employee(name=" + this.name + ",age=" + this.age + ")";
// 			}
// 		}
// 		List<Employee> employees = new ArrayList<>(Arrays.asList(
// 			new Employee("Tanaka", 57),
// 			new Employee("Sato", 31),
// 			new Employee("Yamada", 50),
// 			new Employee("Endo", 23),
// 			new Employee("Suzuki", 39)
// 		));
// 		employees.sort(Comparator.comparingInt(e -> e.age));
// 		for (Employee employee : employees) {
// 			System.out.println(employee);
// 		}
// 	}	

public class Employee {

  public final String name;
  public final int age;
  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }
  @Override
  public String toString() {
    return "Employee(name=" + this.name + ",age=" + this.age + ")";
  }


  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>(Arrays.asList(
        new Employee("Tanaka", 57),
        new Employee("Sato", 31),
        new Employee("Yamada", 50),
        new Employee("Endo", 23),
        new Employee("Suzuki", 39)));

        List<Employee> sortedEmployees =
        employees.stream()
        .sorted(Comparator.comparingInt(e -> e.age))
        .collect(Collectors.toList());

        sortedEmployees.stream()
        .forEach(System.out::println);
  }
}
