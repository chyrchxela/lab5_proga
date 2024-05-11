/**
 * The {@code Address} class represents the address of an organization.
 * It includes a street as a unique identifier for the address.
 */
package organization;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

    /**
     * The street associated with the address.
     */
    private String street;

    /**
     * Constructs an {@code Address} object with the specified zip code.
     *
     * @param street The zip code of the address.
     */
    public Address(String street) {
        this.street = street;
    }

    /**
     * Gets the street of the address.
     *
     * @return The street as a {@code String}.
     */
    public String getStret() {
        return street;
    }

    /**
     * Sets the street of the address.
     *
     * @param street The new street to be set.
     */
    public void setStreet(String street) {
        this.street = street;
    }
}