package auctionHouse;

public class UserClass implements User {

    static final long serialVersionUID = 0L;

    private final String login;

    private final String name;

    private final int age;

    private final String email;

    private int numbOfBids;

    public UserClass(String login, String name, int age, String email){
        this.login = login;
        this.name = name;
        this.age = age;
        this.email = email;
        this.numbOfBids = 0;
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

    public void incNumbOfBids(){
        numbOfBids++;
    }
    public void decNumbOfBids(){
        numbOfBids--;
    }
    public boolean hasBids(){
        return numbOfBids>0;
    }
}
