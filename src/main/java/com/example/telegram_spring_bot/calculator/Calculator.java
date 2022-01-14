package com.example.telegram_spring_bot.calculator;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
@Component
public class Calculator {
    private float var;

    public float getVar() {
        return var;
    }

    public void setVar(float var) {
        this.var = var;
    }
    public String Calculate(){




        return var+"";

    }
}
