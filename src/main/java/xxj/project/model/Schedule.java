package xxj.project.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight")
    private Flight flight;

    @Column(name = "dayOfDeparture")
    private LocalDate dayOfDeparture;

    @Column(name = "dayOfArrive")
    private LocalDate dayOfArrive;

    @Column(name = "timeOfDeparture")
    private LocalTime timeOfDeparture;

    @Column(name = "timeOfArrive")
    private LocalTime timeOfArrive;

    @Column(name = "numberOfUnusedSeats")
    private int numberOfUnusedSeats;

    @Column(name = "numberOfSoldTickets")
    private int numberOfSoldTickets;

    @Column(name = "planeType")
    private String planeType;

    public Schedule() {
    }

    public Schedule( Flight flight, LocalDate dayOfDeparture, LocalDate dayOfArrive, LocalTime timeOfDeparture, LocalTime timeOfArrive, int numberOfUnusedSeats, int numberOfSoldTickets, String planeType) {
        this.flight = flight;
        this.dayOfDeparture = dayOfDeparture;
        this.dayOfArrive = dayOfArrive;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrive = timeOfArrive;
        this.numberOfUnusedSeats = numberOfUnusedSeats;
        this.numberOfSoldTickets = numberOfSoldTickets;
        this.planeType = planeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getDayOfDeparture() {
        return dayOfDeparture;
    }

    public void setDayOfDeparture(LocalDate dayOfDeparture) {
        this.dayOfDeparture = dayOfDeparture;
    }

    public LocalDate getDayOfArrive() {
        return dayOfArrive;
    }

    public void setDayOfArrive(LocalDate dayOfArrive) {
        this.dayOfArrive = dayOfArrive;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public LocalTime getTimeOfArrive() {
        return timeOfArrive;
    }

    public void setTimeOfArrive(LocalTime timeOfArrive) {
        this.timeOfArrive = timeOfArrive;
    }

    public int getNumberOfUnusedSeats() {
        return numberOfUnusedSeats;
    }

    public void setNumberOfUnusedSeats(int numberOfUnusedSeats) {
        this.numberOfUnusedSeats = numberOfUnusedSeats;
    }

    public int getNumberOfSoldTickets() {
        return numberOfSoldTickets;
    }

    public void setNumberOfSoldTickets(int numberOfSoldTickets) {
        this.numberOfSoldTickets = numberOfSoldTickets;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }
}
