package wsb.bugtracker.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import wsb.bugtracker.models.Person;
import wsb.bugtracker.repositories.PersonRepository;
import wsb.bugtracker.services.PersonService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonController {
    final private PersonService personService;
    final private PersonRepository personRepository;

    @GetMapping
    ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/users/index");
        List<Person> people = personService.findAll();
        modelAndView.addObject("people", people);
        return modelAndView;
    }

    @GetMapping("/add")
    ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/users/add");
        Person person = new Person();
        modelAndView.addObject("person", person);
        return modelAndView;
    }

    @PostMapping("/save")
        ModelAndView save(@ModelAttribute @Valid Person person) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        personService.save(person);
        return modelAndView;
    }
}