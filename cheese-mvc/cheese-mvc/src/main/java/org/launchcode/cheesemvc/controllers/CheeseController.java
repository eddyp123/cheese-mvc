package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {
    //construct arraylist and pass in the Cheese object
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // request path for all methods in this class: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        //"cheeses" is the attribute title we point to in index, cheese is the array that is returned when "cheeses" is called
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseFrom(@RequestParam String cheeseName, @RequestParam String cheeseDesc){ //@RequestParam expects to be passed a parameter named cheeseName
        //cheeses.add(cheeseName);//Spring looks for the request parameter in the post request form in /add

        Cheese cheese = new Cheese(cheeseName, cheeseDesc);
        cheeses.add(cheese);

        //redirect to /cheese
        return "redirect:";

    }
// request path cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST) //checkboxes store values in arraylists, so we pass on in here
    public String processRemoveCheeseForm(@RequestParam ArrayList<Integer> cheeseIds){
        for (Integer cheeseId : cheeseIds ) {
            for (Cheese cheese : cheeses){
                if (cheese.getId() == cheeseId ) {
                    cheeses.remove(cheese);
                    break;
                }
            }
        }

        return "redirect:";
    }


}

