public class PromoCode {
    protected String code;
    protected int Discount;

    public PromoCode(String code, int discount) {
        this.code = code;
        Discount = discount;
    }

    @Override
    public String toString() {
        return "code=" + code +
                " Discount= " + Discount +"%";
    }
}
