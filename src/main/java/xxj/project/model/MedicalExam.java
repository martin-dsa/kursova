package xxj.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "medicalExam")
@EntityListeners(AuditingEntityListener.class)
public class MedicalExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private int year;

    @Column(name = "hasPassed")
    private boolean hasPassed;

    @Column(name = "shasPassed")
    private String shasPassed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker")
    private Worker worker;

    public MedicalExam() {
    }

    public MedicalExam(int year, boolean hasPassed, Worker worker) {
        this.year = year;
        this.hasPassed = hasPassed;
        if (this.hasPassed)
            this.shasPassed = "так";
        else
            this.shasPassed = "ні";

        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isHasPassed() {
        return hasPassed;
    }

    public void setHasPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;
        if (this.hasPassed)
            this.shasPassed = "так";
        else
            this.shasPassed = "ні";
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getShasPassed() {
        return shasPassed;
    }
}
