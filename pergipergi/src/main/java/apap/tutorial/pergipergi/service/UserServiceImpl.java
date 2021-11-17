package apap.tutorial.pergipergi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import apap.tutorial.pergipergi.repository.UserDb;
import apap.tutorial.pergipergi.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserDb userDb;
  
  @Override
  public UserModel addUser(UserModel user){
    String pass = encrypt(user.getPassword());
    user.setPassword(pass);
    return userDb.save(user);
  }
  
  @Override
  public String encrypt(String password){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String passwordHash = passwordEncoder.encode(password);
    return passwordHash;
  }

  @Override
    public List<UserModel> getListUser(){
        return userDb.findAll();
    }

    @Override
    public void deleteUser(UserModel user){
      userDb.delete(user);
    }
    
   @Override
   public UserModel getUserByUsername(String username){
     return userDb.findByUsername(username);
   }

   @Override
    public boolean isMatch(String newPassword, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(newPassword, oldPassword);
    }

    @Override
    public void setPassword(UserModel myUser, String newPassword) {
        myUser.setPassword(newPassword);
    }
}

