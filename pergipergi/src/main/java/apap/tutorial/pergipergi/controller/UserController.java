package apap.tutorial.pergipergi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.service.RoleService;
import apap.tutorial.pergipergi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{
  
  @Autowired
  private UserService userService;
  
  @Autowired 
  private RoleService roleService;
  
  @GetMapping("/add")
  public String addUserFormPage(Model model){
    UserModel user = new UserModel();
    List<RoleModel> listRole = roleService.findAll();
    model.addAttribute("user",user);
    model.addAttribute("listRole",listRole);
    return "form-add-user";
  }
  
  @PostMapping("/add")
  public String addUserSubmit(@ModelAttribute UserModel user, Model model){
    userService.addUser(user);
    model.addAttribute("user",user);
    return "redirect:/";
    
  }

  @GetMapping("/view")
    public String listUser(Model model){
        List<UserModel> listUser= userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "view-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUserSubmit(@PathVariable String username,
   Model model
    ){
      UserModel user = userService.getUserByUsername(username);
      userService.deleteUser(user);
      model.addAttribute("user", user.getUsername());
      return "redirect:/";
    }

    @GetMapping("/updatePassword/{username}")
    public String changePasswordFormPage(
            @PathVariable String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "password";
    }

    @PostMapping("/updatePassword")
    public String updatePasswordSubmitPage(@ModelAttribute UserModel userModel, String newPassword, String confPassword, Model model){
        UserModel myUser = userService.getUserByUsername(userModel.getUsername());
        System.out.println(userModel.getPassword());
        System.out.println(myUser.getPassword());
        if (userService.isMatch(userModel.getPassword(), myUser.getPassword() )){
        System.out.println("masuk");
            if (newPassword.equals(confPassword)){
                userService.setPassword(myUser, newPassword);
                userService.addUser(myUser);
                model.addAttribute("message", "password berhasil diubah");
                System.out.println("masuk1");
            }else {
                model.addAttribute("message", "password tidak sama");
                System.out.println("masuk2");
            }
        }else {
            model.addAttribute("message", "password salah");
            System.out.println("masuk3");
        }
        
        return "password";
    }

}


