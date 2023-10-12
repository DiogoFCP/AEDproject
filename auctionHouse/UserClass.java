package auctionHouse;

public class UserClass implements User {

    private String login;

    private String name;

    private int age;

    private String email;

    public UserClass(String login, String name, int age, String email){
        this.login = login;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getLogin(){
        return this.login;
    }

    @Override
    public boolean equals(User other){
        return this.login.equals(other.getLogin());
    }
}
