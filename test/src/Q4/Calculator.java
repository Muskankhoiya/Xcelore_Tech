package Q4;
@FunctionalInterface
interface Cal{
    public int add(int a, int b);
}
public class Calculator {
    public static void main(String[] args){

        Cal cal = (a,b)-> a+b;
        System.out.println(cal.add(10,20));




    }

}
