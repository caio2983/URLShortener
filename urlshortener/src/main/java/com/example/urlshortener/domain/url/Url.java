package com.example.urlshortener.domain.url;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Table(name="url")
@Entity(name="url")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Url {



    private String short_code;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Url(CreateUrl data) {
        this.url = data.url();
    }

    private String url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.short_code = generateShortCode();
    }

    private String generateShortCode() {
        return java.util.UUID.randomUUID().toString().substring(0, 6);
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

}
