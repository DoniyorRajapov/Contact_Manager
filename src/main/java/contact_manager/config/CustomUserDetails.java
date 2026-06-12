package contact_manager.config;

import contact_manager.entity.ProfileEntity;
import lombok.Getter;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {

    private final ProfileEntity profile;

    public CustomUserDetails(ProfileEntity profile){
        this.profile=profile;
    }

    @Override
    public @NonNull Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @NonNull String getPassword() {
        return profile.getPassword();
    }

    @Override
    public @NonNull String getUsername() {
        return profile.getUsername();
    }
}