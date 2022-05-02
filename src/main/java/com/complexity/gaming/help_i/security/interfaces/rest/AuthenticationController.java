package com.complexity.gaming.help_i.security.interfaces.rest;

import com.complexity.gaming.help_i.security.application.communication.AuthenticationRequest;
import com.complexity.gaming.help_i.security.application.communication.AuthenticationResponse;
import com.complexity.gaming.help_i.security.domain.service.DefaultUserDetailsService;
import com.complexity.gaming.help_i.shared.util.JwtCenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCenter tokenCenter;
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @Operation(summary = "Authenticate user", description = "Authenticate user")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/sign-in")
    public ResponseEntity<?> generateAuthenticationToken(
            @RequestBody AuthenticationRequest request)
            throws Exception {
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());
        System.out.println("Password: " + request.getPassword());
        String token = tokenCenter.generateToken(userDetails);
        return ResponseEntity.ok(new
                AuthenticationResponse(userDetails.getUsername(), token));
    }

    private void authenticate(String username, String password)
            throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}