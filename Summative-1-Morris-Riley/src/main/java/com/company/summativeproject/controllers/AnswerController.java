package com.company.summativeproject.controllers;

import com.company.summativeproject.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController {

    private List<Answer> answers = new ArrayList<>();

    public AnswerController() {
        answers.add(new Answer(1, "", "It is certain"));
        answers.add(new Answer(2, "", "It is decidedly so"));
        answers.add(new Answer(3, "", "Without a doubt"));
        answers.add(new Answer(4, "", "Yes definitely"));
        answers.add(new Answer(5, "", "Reply hazy, try again"));
        answers.add(new Answer(6, "", "so ask again later"));
        answers.add(new Answer(6, "", "Better not tell you now"));
        answers.add(new Answer(8, "", "My reply is no"));
        answers.add(new Answer(9, "", "My sources say no"));
        answers.add(new Answer(10, "", "Outlook not so good"));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    private Answer getRandomAnswer(@RequestBody String question) {
        Random random = new Random();
        int randomIndex = random.nextInt(answers.size());

        Answer answer = answers.get(randomIndex);
        answer.setQuestion(question);

        return answer;
    }
}
