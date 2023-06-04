package move.feature.before;

public class User {
    private String userId;

    private String street;

    private String city;

    private String province;

    private String country;

    public String getFullAddress() {
        return street + ", " + city + ", " + province + ", " + country;
    }
}
