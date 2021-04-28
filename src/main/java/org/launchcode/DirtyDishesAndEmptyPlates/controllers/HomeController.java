package org.launchcode.DirtyDishesAndEmptyPlates.controllers;

import org.launchcode.DirtyDishesAndEmptyPlates.models.data.RecipeRepository;
import org.launchcode.DirtyDishesAndEmptyPlates.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;


/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("recipe")
    public String displayRecipe(Model model) {
        return "recipes";
    }

    @RequestMapping("recipe/{recipeId}")
    public String displayRecipe(Model model, @PathVariable int recipeId) {

        Optional optRecipe = recipeRepository.findById(recipeId);
        if (!optRecipe.isEmpty()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            return "redirect:recipe";
        }
    }

}
