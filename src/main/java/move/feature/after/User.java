package move.feature.after;

public class User {

    private String userId;

    private Address address;

    @Deprecated
    public String getFullAddress() {
        return address.getFullAddress();
    }
}
