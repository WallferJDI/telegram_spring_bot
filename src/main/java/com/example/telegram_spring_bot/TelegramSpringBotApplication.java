package com.example.telegram_spring_bot;

import com.example.telegram_spring_bot.configuration.BotConfig;
import com.example.telegram_spring_bot.bot.ConsumptionBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramSpringBotApplication {


    public static void main(String[] args) throws TelegramApiException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ConsumptionBot bot = context.getBean("ConsumptionTelegramBot",ConsumptionBot.class);
        SpringApplication.run(TelegramSpringBotApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi((DefaultBotSession.class));
        telegramBotsApi.registerBot(bot);

    }

}
