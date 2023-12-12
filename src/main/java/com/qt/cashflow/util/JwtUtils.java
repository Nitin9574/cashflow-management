package com.qt.cashflow.util;


import com.qt.cashflow.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class JwtUtils {


    private static  String secret = "This_is_secret";
    private static long expiryDuration= 60 * 60;



    public String generateJwt(User user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;


        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);


        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

//        claims.put("role", user.getRoles());
        claims.put("username", user.getUsername());
//        claims.put("email", user.getEmail());
        claims.put("password", user.getPassword());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();



    }
}
