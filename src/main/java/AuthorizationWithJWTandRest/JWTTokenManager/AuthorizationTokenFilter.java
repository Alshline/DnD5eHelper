package AuthorizationWithJWTandRest.JWTTokenManager;

import AuthorizationWithJWTandRest.Details.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationTokenFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthorizationTokenFilter.class);

    @Autowired
    private JWTUtilities jwtUtilities;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwtToken = parseJWT(httpServletRequest);
            if (jwtToken != null && jwtUtilities.validateJwtToken(jwtToken)) {
                String username = jwtUtilities.getUserNameFromToken(jwtToken);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(userAuthenticationToken);
            }
        } catch (Exception exception) {
            logger.error("Invalid user authentication ", exception);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String parseJWT(HttpServletRequest request) {
        String header = request.getHeader("AuthorizationWithJWTandRest");
        if (StringUtils.hasText(header) && header.startsWith("SberUniv22 ")) {
            return header.substring(7, header.length());
        }
        return null;
    }
}
