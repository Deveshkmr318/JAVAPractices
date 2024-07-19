import java.util.*;
import java.util.stream.Collectors;

class Employee{

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearofJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearofJoining, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearofJoining = yearofJoining;
        this.salary = salary;
    }

    @Override
    public String toString() 
    {
        return "[ Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearofJoining
                +", Salary : "+salary + " ]";
    }

    public Employee() {
        //TODO Auto-generated constructor stub
    }
}
public class Test1 {
    
    public static void main(String[] args) {
        

        List<Employee> emp = new ArrayList<>();

        init(emp);

        Map<String, Long> hm = emp.
                                stream().
                                collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));

        System.out.println(hm);

        List<String> ls = emp.
                            stream().
                            map(e -> e.department).
                            distinct().
                            collect(Collectors.toList());

        for(String dpt : ls){
            System.out.println(dpt);
        }

        Map<String, Double> hm1 = emp.
                                    stream().
                                    collect(Collectors.groupingBy(e -> e.gender, Collectors.averagingInt(e -> e.age)));
        
        System.out.println(hm1);

        Employee employee = emp.
                            stream().
                            collect(Collectors.maxBy(Comparator.comparingDouble(e-> e.salary))).
                            get();

        System.out.println(employee.toString());

        List<Employee> empList = emp.
                            stream().
                            filter(e -> e.yearofJoining > 2015).
                            collect(Collectors.toList());

        for(Employee e : empList){
            System.out.println(e.name);
        }

        Map<String, Long> hmEmp = emp.
                                    stream().
                                    collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
    
        System.out.println(hmEmp);

        Map<String, Double> employees = emp.
                                        stream().
                                        collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e-> e.salary)));

        System.out.println(employees);
    
        Employee employee1 = emp
                            .stream()
                            .filter(e -> e.gender == "Male" && e.department == "Product Development")
                            .collect(Collectors.minBy(Comparator.comparingInt(e -> e.age)))
                            .get();
                            // collect(Collectors.minBy(Comparator.comparingInt(e -> e.age))).
                            // get();
    
        System.out.println(employee1.toString());

        Map<String, Long> employeeHashMap = emp
                                .stream()
                                .filter(e -> e.department == "Sales And Marketing")
                                .collect(Collectors.groupingBy(e -> e.gender , Collectors.counting()));
    
        System.out.println(employeeHashMap);


        Map<String, List<Employee>> employeesMap = emp
                                                    .stream()
                                                    .collect(Collectors.groupingBy(e -> e.department, Collectors.toList()));

        System.out.println(employeesMap);

        Double ans = emp
        .stream()
        .collect(Collectors.averagingDouble(e -> e.salary));

        System.out.println(ans);

        Double total = emp
                        .stream()
                        .collect(Collectors.summingDouble(e -> e.salary));
                            
        System.out.println(total);          
        
        
        String inputString = "Java Concept Of The Day";
        // char[] array = inputString.toCharArray();
         
        Map<Character, Long> charCountMap = 
        inputString.chars().mapToObj(i -> (char)i).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
         
        System.out.println(charCountMap);

        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
         
        Map<String, Long> stationeryCountMap = 
                stationeryList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
         
        System.out.println(stationeryCountMap);
                    
                    }

    private static void init(List<Employee> employeeList) {
        // List<Employee> employeeList = new ArrayList<Employee>();
         
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

    }
}
