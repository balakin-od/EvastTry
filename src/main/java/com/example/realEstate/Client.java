package com.example.realEstate;

public class Client {
    private int id;
    private int idty;
    private String name;
    private int salary;

    public Client(int id, int idty, String name, int salary)
    {
        this.id = id;
        this.idty = idty;
        this.name = name;
        this.salary = salary;



    }
    public Integer getId() {
        return id;
    }

    public Integer getIdty() {
        return idty;
    }

    public String getName() {
        return name;
    }


}
