package pl.danceclub.app.domain.school.Dto;

public class SchoolDto {

    private Long    id;
    private String  name;
    private String  address;
    private String  addressGmaps;
    private String  description;
    private String  poster;

    public SchoolDto(Long id, String name, String address, String addressGmaps, String description, String poster) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.addressGmaps = addressGmaps;
        this.description = description;
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressGmaps() {
        return addressGmaps;
    }

    public void setAddressGmaps(String addressGmaps) {
        this.addressGmaps = addressGmaps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
