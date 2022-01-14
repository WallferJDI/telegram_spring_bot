package com.example.telegram_spring_bot.configuration;

import com.example.telegram_spring_bot.bot.ConsumptionBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Component
@Getter
@Setter
public class BotConfig {


    @Value("${bot.userName}")
    private String userName;
    @Value("${bot.token}")
    private String botToken;




}
