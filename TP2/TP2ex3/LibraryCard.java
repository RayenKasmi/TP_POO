public class LibraryCard
{
    private String creationDate;
    private String expirationDate;
    private String type;
    private static int nb=0;
    private int CardNumber;
    LibraryCard(String creationDate, String expirationDate, String type)
    {
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.type = type;
        CardNumber=nb++;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getType() {
        return type;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    @Override
    public String toString() {
        return "LibraryCard:" +
                "creationDate='" + creationDate +
                ", expirationDate='" + expirationDate +
                ", type='" + type +
                ", CardNumber=" + CardNumber ;
    }
}