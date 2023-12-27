public class Reviews {
    protected String reviewerName;
    protected String review;
    protected double rating;

    public Reviews(String reviewerName, String review, double rating) {
        this.reviewerName = reviewerName;
        this.review = review;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "reviewerName='" + reviewerName +
                "| review='" + review +
                "| rating=" + rating +"/5★\n";
    }
}
