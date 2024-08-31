package XenosisSecondWeek;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void personDetails(){
        System.out.println("name :" + name + ","+ "age :" +age);

    }

}
