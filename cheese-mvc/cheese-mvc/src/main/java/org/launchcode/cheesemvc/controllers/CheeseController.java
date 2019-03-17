package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {
    //cheeses ArrayList is only in memory when the program is running. Not a substitute for a database.
    static ArrayList<String> cheeses = new ArrayList<>();

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
    public String processAddCheeseFrom(@RequestParam String cheeseName){ //@RequestParam expects to be passed a parameter named cheeseName
        cheeses.add(cheeseName);                 //Spring looks for the request parameter in the post request form in /add
        //redirect to /cheese
        return "redirect:";

    }
}

