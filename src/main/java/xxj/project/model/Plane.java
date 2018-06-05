package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plane")
@EntityListeners(AuditingEntityListener.class)
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfRepairs")
    private int numberOfRepairs;

    @Column(name = "age")
    private int age;

    @Column(name = "numberOfFlights")
    private int numberOfFlights;

    @Column(name = "status")
    private String status;

    @Column(name = "numberOfSeats")
    private int numberOfSeats;

    @Column(name = "timeOfArrive")
    private LocalDate timeOfArrive;

    public Plane() {
    }

    public Plane( String name, int numberOfRepairs, int age, int numberOfFlights, String status, int numberOfSeats, LocalDate timeOfArrive) {
        this.name = name;
        this.numberOfRepairs = numberOfRepairs;
        this.age = age;
        this.numberOfFlights = numberOfFlights;
        this.status = status;
        this.numberOfSeats = numberOfSeats;
        this.timeOfArrive = timeOfArrive;
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

    public int getNumberOfRepairs() {
        return numberOfRepairs;
    }

    public void setNumberOfRepairs(int numberOfRepairs) {
        this.numberOfRepairs = numberOfRepairs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDate getTimeOfArrive() {
        return timeOfArrive;
    }

    public void setTimeOfArrive(LocalDate timeOfArrive) {
        this.timeOfArrive = timeOfArrive;
    }
}
