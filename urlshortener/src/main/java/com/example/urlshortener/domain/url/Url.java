package com.example.urlshortener.domain.url;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.util.UUID;
import java.time.LocalDateTime;



@Table(name="url")
@Entity(name="url")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Url {

    @GeneratedValue(strategy = GenerationType.UUID)
    private String short_code;

    @Id
    private String id;

    private String url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

}
