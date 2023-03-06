package pl.danceclub.app.domain.unit.dto;

public class UnitDto {

    private Long     id;
    private String   name;
    private boolean  promoted;
    private String     school;
    private String     female_teacher;
    private String     male_teacher;

    public UnitDto(Long id, String name, boolean promoted, String school, String female_teacher, String male_teacher) {
        this.id = id;
        this.name = name;
        this.promoted = promoted;
        this.school = school;
        this.female_teacher = female_teacher;
        this.male_teacher = male_teacher;
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

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getFemale_teacher() {
        return female_teacher;
    }

    public void setFemale_teacher(String female_teacher) {
        this.female_teacher = female_teacher;
    }

    public String getMale_teacher() {
        return male_teacher;
    }

    public void setMale_teacher(String male_teacher) {
        this.male_teacher = male_teacher;
    }
}
