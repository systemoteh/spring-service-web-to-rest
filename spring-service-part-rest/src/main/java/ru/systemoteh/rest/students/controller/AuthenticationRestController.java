package ru.systemoteh.rest.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.systemoteh.rest.students.config.JwtTokenProvider;
import ru.systemoteh.rest.students.dto.AuthenticationRequestDto;
import ru.systemoteh.rest.students.dto.AuthenticationResponseDto;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (userDetails == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            AuthenticationResponseDto responseDto = fillResponse(userDetails);

            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private AuthenticationResponseDto fillResponse(UserDetails userDetails) {
        String token = jwtTokenProvider.createToken(userDetails);

        Set<String> roles = new HashSet<>();
        for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
            roles.add(grantedAuthority.getAuthority());
        }

        return new AuthenticationResponseDto(userDetails.getUsername(), userDetails.getPassword(), token, roles);
    }
}
