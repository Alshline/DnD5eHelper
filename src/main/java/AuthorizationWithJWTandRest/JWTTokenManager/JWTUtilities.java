package AuthorizationWithJWTandRest.JWTTokenManager;

import java.util.Date;

import AuthorizationWithJWTandRest.Details.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JWTUtilities {

    private static final Logger logger = LoggerFactory.getLogger(JWTUtilities.class);

    @Value("${application.jwt.secret}")
    private String jwtSecretWord;

    @Value("${application.jwt.expiration}")
    private int jwtExpirationTimeInMilliseconds;

    public String generateJwtToken (Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationTimeInMilliseconds))
                .signWith(SignatureAlgorithm.HS512, jwtSecretWord)
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(jwtSecretWord).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateJwtToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecretWord).parseClaimsJws(token);
            return true;
        } catch (SignatureException signatureException){
            logger.error("Invalid signature ", signatureException.getMessage());
        } catch (MalformedJwtException malformedJwtException){
            logger.error("Invalid token ", malformedJwtException.getMessage() );
        } catch (ExpiredJwtException expiredJwtException){
            logger.error("Token expired", expiredJwtException.getMessage() );
        } catch(UnsupportedJwtException unsupportedJwtException){
            logger.error("Token unsupported ", unsupportedJwtException.getMessage() );
        } catch (IllegalArgumentException illegalArgumentException){
            logger.error("Token empty ", illegalArgumentException.getMessage() );
        }
        return false;
    }
}
