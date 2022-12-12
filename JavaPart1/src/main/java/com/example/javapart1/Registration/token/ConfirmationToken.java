package com.example.javapart1.Registration.token;

import com.example.javapart1.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Document(collection = "ConfToken")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationToken {

    @Id
    private String id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;

    private LocalDateTime confirmedAt;

    @DocumentReference
    private UserModel user;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, UserModel user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.user = user;
    }
}
