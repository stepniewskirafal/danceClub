package pl.danceclub.app.domain.school.Dto;

import org.springframework.web.multipart.MultipartFile;

public class SchoolSaveDto {

    private String         name;
    private String         address;
    private String         description;
    private MultipartFile  poster;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }
}
