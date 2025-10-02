package com.k48.managing.stock.controllers.api;

import com.k48.managing.stock.dto.auth.AuthenticationRequest;
import com.k48.managing.stock.dto.auth.AuthenticationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.k48.managing.stock.utils.Constants.AUTHENTICATION_ENDPOINT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// --- Assume your DTOs and constants are imported ---
// import com.example.dto.auth.AuthenticationRequest;
// import com.example.dto.auth.AuthenticationResponse;
// import static com.example.utils.Constants.AUTHENTICATION_ENDPOINT;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@Tag(name = "Authentication", description = "Operations related to user authentication")
public interface AuthenticationApi {

    @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
