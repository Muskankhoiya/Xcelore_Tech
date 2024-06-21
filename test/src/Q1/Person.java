package Q1;

public class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary){
        this.name = name;
        this.age= age;
        this.salary = salary;


    }

    public Person() {

    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name"+name + '\''+
                        ", age" + age +
                        " salary " + salary +
                '}';


    }
}
