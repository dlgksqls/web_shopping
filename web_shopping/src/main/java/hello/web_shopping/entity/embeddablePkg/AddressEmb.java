package hello.web_shopping.entity.embeddablePkg;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEmb {

    private String city;
    private String street;
    private String zipcode;

    public AddressEmb() {
    }

    public AddressEmb(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return city + " " + street + " " + zipcode;
    }
}
