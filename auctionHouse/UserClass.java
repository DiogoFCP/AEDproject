package auctionHouse;

/**
 * A collector who can bid on arts that are in auctions.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class UserClass implements User {


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * Unique identifier of the user.
     */
    private final String login;

    /**
     * The name of the user.
     */
    private final String name;

    /**
     * The age of the user.
     */
    private final int age;

    /**
     * The email of the user.
     */
    private final String email;

    /**
     * The number of bids created by the user.
     */
    private int numbOfBids;


    /*              Constructors Methods               */


    /**
     * Constructor of the UserClass that initializes all the variables.
     *
     * @param login the login of the user (unique ID).
     * @param name  the name of the user.
     * @param age   the age of the user.
     * @param email the email of the user.
     */
    public UserClass(String login, String name, int age, String email) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.email = email;
        this.numbOfBids = 0;
    }


    /*              Protected Methods               */


    /**
     * Increments the number of bids done by the user.
     */
    protected void incNumbOfBids() {
        numbOfBids++;
    }

    /**
     * Decrements the number of bids done by the user.
     */
    protected void decNumbOfBids() {
        numbOfBids--;
    }


    /*              Public Methods               */


    public boolean hasBids() {
        return numbOfBids > 0;
    }

    public String getLogin() {
        return this.login;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        User other = (User) obj;
        if (this.login == null) {
            return other.getLogin() == null;
        } else return this.login.equals(other.getLogin());
    }
}
