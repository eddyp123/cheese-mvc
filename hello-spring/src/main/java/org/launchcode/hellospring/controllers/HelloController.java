package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null){
            name = "World";
        }

        return "Hello there " + name;
    }

    public static  String createMessage(String name, String language) {
        if (language.equals("English")){
            return "Hello, " + name + "!";
        } else if (language.equals("Francias")){
            return "Bonjour, " + name + "!";
        }else if (language.equals("English")){
            return "Hello, " + name + "!";
        } else if (language.equals("Francias")){
            return "Bonjour, " + name + "!";
        } else {
            return "Hi welcome to chilis";
    }



    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method = 'post'>" +
                "<input type='test' name='name' />" +
                "<select id='lang-select' name='language'>" +
                "<option value='french'>Francias</option>" +
                "<option value='english' name='hello' selected>English</option>" +
                "<option value='spanish'>Espanol</option>" +
                "<option value='german'>Deutsch</option>" +
                "<option value='chinese'>中文</option>" +
                "<option value='russian'>русский</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }
    //create function that after you submit post request, route reads data
    //processes it, and returns the value


    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");

        return createMessage(name, languages);
    }

    /** Studio Code for class 3 */

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

}
