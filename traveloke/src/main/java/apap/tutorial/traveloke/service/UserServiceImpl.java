package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public UserModel getUserByUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
	
	@Override
    public String authRole(){
        String role = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (GrantedAuthority ga : authorities){
            if(ga.getAuthority().equals("ADMIN")){
                role = "ADMIN";
            } else if (ga.getAuthority().equals("USER")){
                role = "USER";
            } else {
                role = "RECEPTIONIST";
            }
        }

        return role;
    }

    @Override
    public String stringUsername(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();

    }

    @Override
    public boolean passwordMatch(String oldPassword, UserModel user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPassword, user.getPassword())){
            return true;
        }else{
            return false;
        }
    }


}
