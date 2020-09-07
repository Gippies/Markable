package com.gippies.markable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthorityService userAuthorityService;

    @GetMapping("/login")
    public String login() {
        return "user_login";
    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        UserDTO user = userService.getByUsername(authentication.getName());
        model.addAttribute("user", user);
        return "user_profile";
    }

    @PostMapping("/logout")
    public String logout() {
        return "user_login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "user_register";
    }

    @PostMapping("/register")
    public String successfulRegister(@ModelAttribute UserDTO userDTO) {
        String encodedPassword  = passwordEncoder.encode(userDTO.getPassword());

        UserDTO user = new UserDTO();
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        user.setUsername(userDTO.getUsername());

        UserAuthority authority = new UserAuthority();
        authority.setAuthority("BOARD");
        authority.setUser(user);
        userService.save(user);
        userAuthorityService.save(authority);
        return "index";
    }
}
