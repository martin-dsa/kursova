package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "passengerHasSchedule")
@EntityListeners(AuditingEntityListener.class)
public class PassengerHasSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger")
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    @Column(name = "hasLuggage")
    private boolean hasLuggage;

    @Column(name = "shasLuggage")
    private String shasLuggage;

    public PassengerHasSchedule() {
    }

    public PassengerHasSchedule(Passenger passenger, Schedule schedule, boolean hasLuggage) {

        this.passenger = passenger;
        this.schedule = schedule;
        this.hasLuggage = hasLuggage;
        if (this.hasLuggage) this.shasLuggage = "так";
        else this.shasLuggage = "ні";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isHasLuggage() {
        return hasLuggage;
    }

    public void setHasLuggage(boolean hasLuggage) {
        this.hasLuggage = hasLuggage;
        if (this.hasLuggage) this.shasLuggage = "так";
        else this.shasLuggage = "ні";
    }

    public String getShasLuggage() {
        return shasLuggage;
    }
}
