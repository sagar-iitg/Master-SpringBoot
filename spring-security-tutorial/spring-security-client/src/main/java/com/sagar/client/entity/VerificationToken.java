package com.sagar.client.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {



        //expiration time is 10 minute
        private static final int EXPIRATION_TIME=10;

        @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String token;
        private Date expirationTime;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="user_id", nullable=false,foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
        private User user;

    public VerificationToken( User user,String token) {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime=calculateExpirationDate(EXPIRATION_TIME);
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
        this.expirationTime=calculateExpirationDate(EXPIRATION_TIME);

    }

    private Date calculateExpirationDate(int expirationTime) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());

    }
}
