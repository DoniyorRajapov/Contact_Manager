package contact_manager.config;

import contact_manager.entity.ProfileEntity;
import contact_manager.repository.ProfileRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository repository;

    @Override
    public @NonNull UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        ProfileEntity profile=repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(profile);
    }
}