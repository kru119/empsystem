package net.togogo.bean;

public class Skill {
    private Integer id;
    private String name;
    private String school;
    private String grade;
    private String goodat;

    public Skill(Integer id, String name, String school, String grade, String goodat) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.goodat = goodat;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", goodat='" + goodat + '\'' +
                '}';
    }

    public Skill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }
}
