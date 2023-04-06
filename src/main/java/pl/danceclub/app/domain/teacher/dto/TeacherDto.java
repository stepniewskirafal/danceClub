package pl.danceclub.app.domain.teacher.dto;

public class TeacherDto {
    private Long    id;
    private String  name;
    private String  surname;
    private String  short_description;
    private String  description;
    private String  youtube_trailer_id;
    private String  poster;
    private boolean promoted;
    private String  genre_name;
    private double avgRating;
    private long ratingCount;

    public TeacherDto(Long id, String name, String surname, String short_description, String description, String youtube_trailer_id, String poster, boolean promoted, String genre_name, double avgRating, long ratingCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.short_description = short_description;
        this.description = description;
        this.youtube_trailer_id = youtube_trailer_id;
        this.poster = poster;
        this.promoted = promoted;
        this.genre_name = genre_name;
        this.avgRating = avgRating;
        this.ratingCount = ratingCount;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutube_trailer_id() {
        return youtube_trailer_id;
    }

    public void setYoutube_trailer_id(String youtube_trailer_id) {
        this.youtube_trailer_id = youtube_trailer_id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public long getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(long ratingCount) {
        this.ratingCount = ratingCount;
    }
}
