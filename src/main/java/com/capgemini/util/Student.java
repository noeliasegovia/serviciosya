package com.capgemini.util;


public class Student {

    public String dni;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals( Object obj) {
        Student target = (Student)obj;
        return target.getDni().equals(this.dni);
    }

    @Override
    public int hashCode() {

        return getDni().hashCode();
    }

    public static void main(String[] args) {
        Student t1 = new Student();
        Student t2 = new Student();
        t1.setDni("1234");
        t2.setDni("1234");

        System.out.println(t1.equals(t2));

        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());


    }

}

