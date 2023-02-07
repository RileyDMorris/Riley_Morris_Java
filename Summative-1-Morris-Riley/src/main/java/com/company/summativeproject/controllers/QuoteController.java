package com.company.summativeproject.controllers;

import com.company.summativeproject.models.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteController {

    private static final Quote[] quotes = {
            new Quote(1, "Albert Einstein", "Imagination is more important than knowledge."),
            new Quote(2, "Confucius", "The will to win, the desire to succeed, the urge to reach your full potential... these are the keys that will unlock the door to personal excellence."),
            new Quote(3, "Nelson Mandela", "Education is the most powerful weapon which you can use to change the world."),
            new Quote(4, "Mark Twain", "Age is an issue of mind over matter. If you don't mind, it doesn't matter."),
            new Quote(5, "Steve Jobs", "Design is not just what it looks like and feels like. Design is how it works."),
            new Quote(6, "Oprah Winfrey", "The biggest adventure you can ever take is to live the life of your dreams."),
            new Quote(7, "Eleanor Roosevelt", "The future belongs to those who believe in the beauty of their dreams."),
            new Quote(8, "Jim Rohn", "Success is not to be pursued; it is to be attracted by the person we become."),
            new Quote(9, "Dr. Seuss", "You have brains in your head. You have feet in your shoes. You can steer yourself in any direction you choose."),
            new Quote(10, "Walt Disney", "The way to get started is to quit talking and begin doing.")
    };

    @GetMapping("/quote")
    public Quote getQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        return quotes[randomIndex];
    }
}