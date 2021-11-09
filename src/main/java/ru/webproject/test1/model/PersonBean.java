package ru.webproject.test1.model;

public class PersonBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getResult() {
        if (age >= 18) {
            return "Old person";
        }
        return "Young person";
    }
}
