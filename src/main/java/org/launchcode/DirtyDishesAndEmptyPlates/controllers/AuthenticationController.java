package org.launchcode.DirtyDishesAndEmptyPlates.controllers;

import org.launchcode.DirtyDishesAndEmptyPlates.models.GuestUser;
import org.launchcode.DirtyDishesAndEmptyPlates.models.Recipe;
import org.launchcode.DirtyDishesAndEmptyPlates.models.User;
import org.launchcode.DirtyDishesAndEmptyPlates.models.data.RecipeRepository;
import org.launchcode.DirtyDishesAndEmptyPlates.models.data.UserRepository;
import org.launchcode.DirtyDishesAndEmptyPlates.models.dto.LoginFormDTO;
import org.launchcode.DirtyDishesAndEmptyPlates.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    private static final String userSessionKey = "user";
    
    private static final GuestUser guestUser = new GuestUser();

    public boolean loggerOuter(User user) {
        return true;
    }
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    private static void setupCommonAttributes(Model model, User user, String title) {
        Boolean loggedin = (user != null && !user.equals(guestUser));
        model.addAttribute("loggedin", loggedin);
        model.addAttribute("user", user);
        model.addAttribute("title", title);
    }
    
    @RequestMapping("")
    public String displayIndex(HttpServletRequest request, Model model) {
        User user = getUserFromSession(request.getSession());
        model.addAttribute("recipes", recipeRepository.findAll());
        setupCommonAttributes(model, user, "Home");
        return "index";
    }
    
    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }
    
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {
        
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }
        
        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());
        
        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }
        
        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }
        
        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        
        return "redirect:";
        
        
    }
    
    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Login");
        return "login";
    }
    
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                            Errors errors, HttpServletRequest request,
                            Model model) {
        
        if (errors.hasErrors()) {
            model.addAttribute("title", "Login");
            return "login";
        }
        
        User existingUser = userRepository.findByUsername(loginFormDTO.getUsername());
        
        if (existingUser != null) {
            String password = loginFormDTO.getPassword();
            if (existingUser.isMatchingPassword(password)) {
                setUserInSession(request.getSession(), existingUser);
                return "redirect:";
            }
        }
        
        return "login";
    }
    
    
    @PostMapping("/logout")
    public String logoutPost(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
        model.addAttribute("username", username);
        request.getSession().invalidate();
        return "logout";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
        model.addAttribute("username", username);
        request.getSession().invalidate();
        return "logout";
    }
    
    @GetMapping("/recipe/{recipeId}")
    public String recipe(HttpServletRequest request, Model model, @PathVariable int recipeId) {
        Optional optRecipe = recipeRepository.findById(recipeId);
        if (!optRecipe.isEmpty()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        }
        User user = getUserFromSession(request.getSession());
        setupCommonAttributes(model, user, "Recipe");
        return "recipe";
    }
    
    @GetMapping("/recipe")
    public String recipes(HttpServletRequest request, Model model) {
        User user = getUserFromSession(request.getSession());
        model.addAttribute("recipes", recipeRepository.findAll());
        setupCommonAttributes(model, user, "Recipes");
        return "recipe";
    }


}

