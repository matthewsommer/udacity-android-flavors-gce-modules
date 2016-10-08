package com.udacity;

public class JokeGenerator {

    private static String[] jokeArray = {
            "My friend gave me his Epi-Pen as he was dying.\n" +
                    "It seemed very important to him that I have it.",
            "You don't need a parachute to go skydiving.\n" +
                    "You need a parachute to go skydiving twice.",
            "You can never lose a homing pigeon - if your homing pigeon" +
                    " doesn't come back, what you've lost is a pigeon.",
            "Say what you want about deaf people.",
            "My grandfather has the heart of a lion and a lifetime ban at the zoo.",
            "Working in a mirror factory is something I can totally see myself doing.",
            "On the other hand, you have different fingers."
    };

    public static String randomJoke() {
        int Min = 0;
        int Max = jokeArray.length;
        return jokeArray[Min + (int)(Math.random() * ((Max - Min)))];
    }
}