class Calculator{
    public int add(int num1, int num2){
        int result = num1 + num2;
        return result;
    }

    public double add(double num1, int num2, int num3){
        double result = num1 + num2 + num3;
        return result;
    }
}

public class java{
    public static void main(String[] args) {

        Calculator obj = new Calculator();
        int result1 = obj.add(10, 9);
        System.out.println(result1);

        Calculator obj1 = new Calculator();
        double result2 = obj1.add(10, 9, 12);
        System.out.println(result2);
        
    }
}