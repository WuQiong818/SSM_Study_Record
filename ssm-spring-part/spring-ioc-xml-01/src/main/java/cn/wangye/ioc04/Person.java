package cn.wangye.ioc04;

public class Person {
    private String name ;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public void birth(){
        this.name = "wang";
        this.age = 0;
        Person person = new Person(this.name,this.age);
        System.out.println(person);
    }

    public void death(){
        this.name="kong";
        this.age = 80;
        Person person = new Person(this.name,this.age);
        System.out.println(person);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
