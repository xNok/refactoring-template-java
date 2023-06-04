package move.feature.after;

public class Address {

    private String street;

    private String city;

    private String province;

    private String country;

    public String getFullAddress() {
        return street + ", " + city + ", " + province + ", " + country;
    }

}
