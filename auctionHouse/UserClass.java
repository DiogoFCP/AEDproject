package auctionHouse;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class UserClass implements User {

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * TODO
     */
    private final String login;

    /**
     * TODO
     */
    private final String name;

    /**
     * TODO
     */
    private final int age;

    /**
     * TODO
     */
    private final String email;

    /**
     * TODO
     */
    private int numbOfBids;

    /**
     * TODO
     * @param login
     * @param name
     * @param age
     * @param email
     */
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
