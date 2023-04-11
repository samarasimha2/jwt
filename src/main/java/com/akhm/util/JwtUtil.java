package com.akhm.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${app.secret}")
	private String secret;
	public String generateToken(String subject)
	{
		
		return Jwts.builder().setSubject(subject).setIssuer("AKHM").setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15))).signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
	public Claims getClaims(String token)
	{
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}
	public Date getExpDate(String token)
	{
		return getClaims(token).getExpiration();
	}
	public String getUsername(String token)
	{
		return getClaims(token).getSubject();
	}
	public boolean validateToken(String token,String username)
	{
		String tokenUserName=getUsername(token);
		return false;
	}

}
