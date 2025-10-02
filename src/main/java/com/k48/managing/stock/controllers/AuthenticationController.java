package com.k48.managing.stock.controllers;
import com.k48.managing.stock.controllers.api.AuthenticationApi;
import com.k48.managing.stock.dto.auth.AuthenticationRequest;
import com.k48.managing.stock.dto.auth.AuthenticationResponse;
import com.k48.managing.stock.model.auth.ExtendedUser;
import com.k48.managing.stock.service.auth.ApplicationUserDetailsService;
import com.k48.managing.stock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.k48.managing.stock.utils.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

   // @Override
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            // Attempt authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getLogin(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            // Print the exact exception in the console
            e.printStackTrace();

            // Return the message in the response temporarily for debugging
            return ResponseEntity.status(403).body(
                    AuthenticationResponse.builder()
                            .accessToken("FAILED: " + e.getMessage())
                            .build()
            );
        }

        // Load user details after successful authentication
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        ExtendedUser extendedUser = (ExtendedUser) userDetails;

        // Optional: Check manually if password matches DB (for debugging)
        boolean matches = passwordEncoder.matches(request.getPassword(), extendedUser.getPassword());
        System.out.println("Password matches DB? " + matches);

        // Generate JWT token
        final String jwt = jwtUtil.generateToken(extendedUser);

        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .accessToken(jwt)
                        .build()
        );
    }
}






/*
package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.AuthenticationApi;
import com.k48.managing.stock.dto.auth.AuthenticationRequest;
import com.k48.managing.stock.dto.auth.AuthenticationResponse;
import com.k48.managing.stock.model.auth.ExtendedUser;
import com.k48.managing.stock.service.auth.ApplicationUserDetailsService;
import com.k48.managing.stock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }

}
*/