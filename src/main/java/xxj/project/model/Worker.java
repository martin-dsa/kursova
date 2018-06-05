package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "worker")
@EntityListeners(AuditingEntityListener.class)
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middleName")
    private String middleName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brigade")
    private Brigade brigade;

    @Column(name = "experience")
    private int experience;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "hasChildren")
    private boolean hasChildren;

    @Column(name = "shasChildren")
    private String shasChildren;

    @Column(name = "numberOfChildren")
    private Integer numberOfChildren;

    @Column(name = "salary")
    private int salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department")
    private Department department;

    public Worker() {
    }

    public Worker( String name, String surname, String middleName, Brigade brigade, int experience, String gender, int age, boolean hasChildren, Integer numberOfChildren, int salary, Department department) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.brigade = brigade;
        this.experience = experience;
        this.gender = gender;
        this.age = age;
        this.hasChildren = hasChildren;
        if (this.hasChildren) shasChildren = "так";
        else shasChildren = "ні";
        this.numberOfChildren = numberOfChildren;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
        if (this.hasChildren) shasChildren = "так";
        else shasChildren = "ні";
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getShasChildren() {
        return shasChildren;
    }
}
