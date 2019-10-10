package com.example.java_thread;

public class MyClass {


    public static void main(String[] args) {

        readFromDataBase();
        writeDataToFile();

    }

    private static void readFromDataBase(){
        try {
            println("开始读数据库");
            Thread.sleep(1000);
            println("读取数据库完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void writeDataToFile(){
        try {
            println("开始写文件");
            Thread.sleep(1000);
            println("写文件完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void println(String msg){
        System.out.println(msg);
    }

}
