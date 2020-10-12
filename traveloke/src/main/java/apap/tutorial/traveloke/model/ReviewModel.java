package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "nama_reviewer", nullable = false)
    private String nama_reviewer;

    @NotNull
    @Size(max = 50)
    @Column(name = "isi_review", nullable = false)
    private String isi_review;

    @Size(max = 50)
    @Column(name = "saran")
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "noKamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_reviewer() {
        return nama_reviewer;
    }

    public void setNama_reviewer(String nama_reviewer) {
        this.nama_reviewer = nama_reviewer;
    }

    public String getIsi_review() {
        return isi_review;
    }

    public void setIsi_review(String isi_review) {
        this.isi_review = isi_review;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    public KamarModel getKamar() {
        return kamar;
    }

    public void setKamar(KamarModel kamar) {
        this.kamar = kamar;
    }
}