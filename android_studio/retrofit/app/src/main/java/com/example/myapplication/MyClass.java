package com.example.myapplication;

public class MyClass {

    String login;
    String node_id;

    public MyClass(String login, String node_id) {
        this.login = login;
        this.node_id = node_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}
