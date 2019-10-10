package com.example.java_designpattern.yiLaiDaoZhi;

public class DependecyTest {


    public static void main(String[] args) {

        Person person = new Person();
        person.receive(new Email());

    }


}

interface IReceive{
    public String getInfo();
}

class Email implements IReceive{

    @Override
    public String getInfo(){
        return "电子邮件信息，hello world";
    }

}

class WeiXin implements IReceive{
    @Override
    public String getInfo() {
        return "微信信息，hello world";
    }
}

class Person {

    public void receive(Email email){
        System.out.println(email.getInfo());
    }

}
