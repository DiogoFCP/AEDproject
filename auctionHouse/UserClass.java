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

    public String getName(){ return this.name; }

    public int getAge(){
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        User other = (User) obj;
        if (this.login == null) {
            return other.getLogin() == null;
        } else return this.login.equals(other.getLogin());
    }
}
