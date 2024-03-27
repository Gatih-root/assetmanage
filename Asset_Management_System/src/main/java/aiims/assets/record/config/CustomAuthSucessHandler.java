package aiims.assets.record.config;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import aiims.assets.record.models.Employe;
import aiims.assets.record.repositories.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthSucessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        System.out.println("  roles   " + roles);

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/admin/profile");

        } else {
            response.sendRedirect("/user/profile");
        }
        String userid = authentication.getName();
        Employe lastlogin = userRepo.findByUserid( userid)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        lastlogin.setLastlogin(new Date());
        userRepo.save(lastlogin); 
       
      

        // Get the authenticated user's username
        String username = authentication.getName();

        // Update invalid attempts to 0 for the authenticated user
        Employe employee = userRepo.findByUserid(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        employee.setInvaledAttemts(0);
        userRepo.save(employee); 
    }
   

}
