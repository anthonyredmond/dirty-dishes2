package org.launchcode.DirtyDishesAndEmptyPlates.controllers;

import org.launchcode.DirtyDishesAndEmptyPlates.models.Recipe;
import org.launchcode.DirtyDishesAndEmptyPlates.models.data.JobRepository;
import org.launchcode.DirtyDishesAndEmptyPlates.models.Job;
import org.launchcode.DirtyDishesAndEmptyPlates.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

@Autowired
private RecipeRepository recipeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    /*
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        jobRepository.save(newJob);
        return "redirect:";
    }
    */

    /*
    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional optJob = jobRepository.findById(jobId);
        if (!optJob.isEmpty()) {
            Job job = (Job) optJob.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:/";
        }
    }
    */

    @GetMapping("recipe/{recipeId}")
    public String displayRecipe(Model model, @PathVariable int recipeId) {

        Optional optRecipe = recipeRepository.findById(recipeId);
        if (!optRecipe.isEmpty()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            return "redirect:/";
        }
    }

}
