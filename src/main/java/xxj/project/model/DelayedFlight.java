package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "delayedFlight")
@EntityListeners(AuditingEntityListener.class)
public class DelayedFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reason")
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    @Column(name = "numberOfReturns")
    private int numberOfReturns;

    public DelayedFlight() {

    }

    public DelayedFlight(String reason, Schedule schedule, int numberOfReturns) {
        this.reason = reason;
        this.schedule = schedule;
        this.numberOfReturns = numberOfReturns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getNumberOfReturns() {
        return numberOfReturns;
    }

    public void setNumberOfReturns(int numberOfReturns) {
        this.numberOfReturns = numberOfReturns;
    }
}
