package cn.wangye.ioc05;

import org.springframework.beans.factory.FactoryBean;

//public interface FactoryBean<T>实现这一FactoryBean类的时候，我们需要进行泛型的指定，泛型的知识点需要进行补充;
//我们如果不再实现接口的时候指定泛型，那么我们之后override的方法的返回值就是Object，这样不好
public class PersonFactory implements FactoryBean<Person> {

    private String name;
    private String gender;


    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName(this.name);
        person.setGender(this.gender);
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
