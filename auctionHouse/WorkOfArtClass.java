package auctionHouse;

/**
 * A work of art created by an artist in the system,
 * identified by a unique identifier (artID).
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class WorkOfArtClass implements WorkOfArt {


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * Unique identifier of a work of art.
     */
    private final String artID;

    /**
     * The artist object of this art author.
     */
    private Artist author;

    /**
     * The year this art was created.
     */
    private final int year;

    /**
     * The name of this art.
     */
    private final String name;

    /**
     * The highest value this art has been sold for.
     */
    private int highestBid;


    /*              Constructors Methods               */


    /**
     * Constructor of the WorkOfArtClass that initializes all the variables.
     *
     * @param artID  the unique art ID.
     * @param author the author of this art.
     * @param year   the year the art was created.
     * @param name   the name of the art.
     */
    public WorkOfArtClass(String artID, ArtistClass author, int year, String name) {
        this.artID = artID;
        this.author = author;
        this.year = year;
        this.name = name;
        this.highestBid = 0;
    }


    /*              Protected Methods               */


    /**
     * Decrements the number of arts made by the author of this art.
     */
    protected void removeFromSelling() {
        ((ArtistClass) this.author).decSellingWorks();
    }

    /**
     * Increments the number of arts made by the author of this art.
     */
    protected void addFromSelling() {
        // this if is needed because in some cases this method
        // is called on a constructor of a dummy, so we need to
        // verify if the author is null, because if not inside a
        // dummy we will get a null pointer exception.
        if (this.author != null)
            ((ArtistClass) this.author).incSellingWorks();
    }

    /**
     * Updates the highest bid value of the art if the given
     * value is bigger than the highest bid of the art.
     *
     * @param value the value being verified.
     */
    protected void updateHighestBid(int value) {
        if (value > this.highestBid)
            this.highestBid = value;
    }


    /*              Public Methods               */


    public String getArtID() {
        return this.artID;
    }

    public String getAuthorLogin() {
        return this.author.getLogin();
    }

    public String getAuthorName() {
        return this.author.getName();
    }

    public int getYear() {
        return this.year;
    }

    public String getName() {
        return this.name;
    }

    public int getHighestBid() {
        return this.highestBid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        WorkOfArt other = (WorkOfArt) obj;
        if (this.artID == null) {
            return other.getArtID() == null;
        } else return this.artID.equals(other.getArtID());
    }

    @Override
    public int compareTo(WorkOfArt o) {
        if (this.highestBid == o.getHighestBid())
            return this.name.compareTo(o.getName());
        return o.getHighestBid() - this.highestBid;
    }
}
