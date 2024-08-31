package XenosisSecondWeek;

class Addition{
    private int num1;
    private int num2;

    //constructor overloading
    public Addition(){
        this.num1 = 0;
        this.num2 = 0;
    }
    public Addition(int num1){
        this.num1 = num1;
        this.num2 = 0;
    }
    public Addition(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    //method overloading
    public double add(){
        return num1+num2;
    }

    public double add(int a, int b){
        return  a+b;
    }

    public double add(int a,int b,int c){
        return a+b+c;
    }

}



public class ConstructorDemonstration {
    public static void main(String[] args) {

        Addition addition = new Addition();
        Addition addition1 = new Addition(1);
        Addition addition2 = new Addition(2,5);

        double n =  addition.add();
        System.out.println(n);

        double n1 = addition.add(1,2);
        System.out.println(n1);

        double n2 = addition.add(1,2,3);
        System.out.println(n2);
        

    }
}
