package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "flight")
@EntityListeners(AuditingEntityListener.class)
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "startingPoint")
    private String startingPoint;

    @Column(name = "finalPoint")
    private String finalPoint;

    @Column(name = "transferPoint")
    private String transferPoint;

    @Column(name = "ticketPrice")
    private int ticketPrice;

    @Column(name = "type")
    private String type;

    @Column(name = "time")
    private int time;

    public Flight() {
    }

    public Flight(String startingPoint, String finalPoint, String transferPoint, int ticketPrice, String type, int time) {
        this.startingPoint = startingPoint;
        this.finalPoint = finalPoint;
        this.transferPoint = transferPoint;
        this.ticketPrice = ticketPrice;
        this.type = type;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(String finalPoint) {
        this.finalPoint = finalPoint;
    }

    public String getTransferPoint() {
        return transferPoint;
    }

    public void setTransferPoint(String transferPoint) {
        this.transferPoint = transferPoint;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
