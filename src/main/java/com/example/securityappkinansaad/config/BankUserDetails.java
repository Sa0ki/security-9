package com.example.securityappkinansaad.config;

import com.example.securityappkinansaad.models.Customer;
import com.example.securityappkinansaad.repositories.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Service
@AllArgsConstructor
public class BankUserDetails implements UserDetailsService{
    private ICustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName = "";
        String password = "";
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Customer> customer = customerRepository.findCustomerByEmail(username);
        if(customer.size() == 0)
            throw new UsernameNotFoundException("User details not found fot he user " + username);
        else{
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPassword();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(userName, password, authorities);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
