package tma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tma.model.UserModelDetails;

@Service("userDetailsServiceImpl")
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModelDetails userModelDetails = userRepository.getUserByUsername(username);

		if (userModelDetails == null) {
			throw new UsernameNotFoundException(username);
		} else {
		        Set<String> roles = userModelDetails.getRoles();
		        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		        for (String role : roles) {
		            authorities.add(new SimpleGrantedAuthority(role));
		        }
		    return new User(userModelDetails.getUsername(), userModelDetails.getPassword(), authorities);
		}
	}
}