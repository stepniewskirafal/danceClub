package pl.danceclub.app.domain.unit.dto;

public class UnitDto {

    private Long    id;
    private String  name;
    private Long    school_id;
    private String  school_name;
    private String  female_teacher;
    private Long    female_teacher_id;
    private String  male_teacher;
    private Long    male_teacher_id;
    private String  short_description;
    private String  description;
    private String  genre_name;
    private Long    genre_id;
    private String  poster;
    private boolean promoted;

    public UnitDto(Long id, String name, Long school_id, String school_name, String female_teacher, Long female_teacher_id, String male_teacher, Long male_teacher_id, String short_description, String description, String genre_name, Long genre_id, String poster, boolean promoted) {
        this.id = id;
        this.name = name;
        this.school_id = school_id;
        this.school_name = school_name;
        this.female_teacher = female_teacher;
        this.female_teacher_id = female_teacher_id;
        this.male_teacher = male_teacher;
        this.male_teacher_id = male_teacher_id;
        this.short_description = short_description;
        this.description = description;
        this.genre_name = genre_name;
        this.genre_id = genre_id;
        this.poster = poster;
        this.promoted = promoted;
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

    public Long getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Long school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getFemale_teacher() {
        return female_teacher;
    }

    public void setFemale_teacher(String female_teacher) {
        this.female_teacher = female_teacher;
    }

    public Long getFemale_teacher_id() {
        return female_teacher_id;
    }

    public void setFemale_teacher_id(Long female_teacher_id) {
        this.female_teacher_id = female_teacher_id;
    }

    public String getMale_teacher() {
        return male_teacher;
    }

    public void setMale_teacher(String male_teacher) {
        this.male_teacher = male_teacher;
    }

    public Long getMale_teacher_id() {
        return male_teacher_id;
    }

    public void setMale_teacher_id(Long male_teacher_id) {
        this.male_teacher_id = male_teacher_id;
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

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
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
}
