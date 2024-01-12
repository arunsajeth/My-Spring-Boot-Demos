package edu.training.JwtSecurity.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTHelper {

	public static final long JWT_TOKEN_VALIDATION = 5*60*60;
	
	private String secret = "qhfjhnefjwkfkwfcwEDNWFENWRNFGVvfbvnfjfcMFSVRFMREjwsfnwefnij32eDFNRGVESEFM293eu23euhwfehfwhfbwfbu4e3r9i23urifb4";
	
	
	//GETTING USERNAME FROM TOKEN
	
	public String getUsernameFromToken(String token)
	{
		return getClaimFromToken(token,Claims::getSubject);
	}
	
	// GETTING EXPIRY DATE FROM TOKEN
	
	public Date getExpirationDateFromToken(String token)
	{
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	// GETTING INDIVIDUAL DATA FROM THE TOKEN 
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver)
	{
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	// GETTING DATA FROM THE TOKEN USING SECRET KEY
	
	public Claims getAllClaimsFromToken(String token)
	{
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	// TOKEN EXPIRY VALIDATION
	
	private Boolean isTokenExpired(String token)
	{
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	// CREATING TOKEN FOR USER / CUSTOMER
	
	public String generateToken(UserDetails userDetails) 
	{
		 Map<String, Object> claims = new HashMap<>();
		 return doGenerateToken(claims, userDetails.getUsername());
	}
	
	private String doGenerateToken(Map<String, Object> claims, String subject) 
	{
			 return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new 
					 Date(System.currentTimeMillis()))
					 .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDATION * 1000))
					 .signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	
	// VALIDATION OF TOKEN
	
	public Boolean validateToken(String token, UserDetails userDetails) 
	{
			 final String username = getUsernameFromToken(token);
			 return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
 

	
}
