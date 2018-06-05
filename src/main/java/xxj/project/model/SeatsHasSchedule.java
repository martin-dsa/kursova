package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "seatsHasSchedule")
@EntityListeners(AuditingEntityListener.class)
public class SeatsHasSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat")
    private Seats seat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    @Column(name = "booked")
    private boolean booked;

    @Column(name = "sbooked")
    private String sbooked;

    public SeatsHasSchedule() {
    }

    public SeatsHasSchedule( Seats seat, Schedule schedule, boolean isBooked) {

        this.seat = seat;
        this.schedule = schedule;
        this.booked = isBooked;
        if(this.booked) sbooked = "так";
        else sbooked = "ні";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
        if(this.booked) sbooked = "так";
        else sbooked = "ні";
    }

    public String getSbooked() {
        return sbooked;
    }
}
