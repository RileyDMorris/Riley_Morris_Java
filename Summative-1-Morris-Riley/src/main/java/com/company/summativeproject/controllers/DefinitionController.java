package com.company.summativeproject.controllers;

import com.company.summativeproject.models.Answer;
import com.company.summativeproject.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {
    private List<Definition> definitions = new ArrayList<>();

    public DefinitionController() {
        definitions.add(new Definition(1, "Bubbles", "Water balloons"));
        definitions.add(new Definition(2, "Unicorn", "A magical beautiful horse breed"));
        definitions.add(new Definition(3, "Librarian", "Where do I find my book"));
        definitions.add(new Definition(4, "Granite", "A beautiful stone"));
        definitions.add(new Definition(5, "Dramatic", "Too much acting, try better"));
        definitions.add(new Definition(6, "Renting", "How much do you pay for your house monthly"));
        definitions.add(new Definition(6, "Cannabis", "Weed is legal now"));
        definitions.add(new Definition(8, "Demolition", "Destruction is not good"));
        definitions.add(new Definition(9, "Dwindle", "Lying all the time"));
        definitions.add(new Definition(10, "Classified", "Secret and can not be shown"));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    private Definition getRandomDefinition() {
        Random random = new Random();
        int randomIndex = random.nextInt(definitions.size());

        Definition definition = definitions.get(randomIndex);

        return definition;
    }
}
