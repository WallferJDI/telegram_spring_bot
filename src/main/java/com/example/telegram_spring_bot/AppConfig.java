package com.example.telegram_spring_bot;

import com.example.telegram_spring_bot.bot.ConsumptionBot;
import com.example.telegram_spring_bot.bot.handlers.CallbackQueryHandler;
import com.example.telegram_spring_bot.botapi.QueryProcess;
import com.example.telegram_spring_bot.calculator.Calculator;
import com.example.telegram_spring_bot.configuration.BotConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.example.telegram_spring_bot.*")
public class AppConfig {


    private BotConfig botConfig;
    public AppConfig(BotConfig botConfig) {this.botConfig = botConfig;}


    @Bean
    public ConsumptionBot ConsumptionTelegramBot(){
        ConsumptionBot consumptionBot= new ConsumptionBot(new DefaultBotOptions());
        consumptionBot.setUserName(botConfig.getUserName());
        consumptionBot.setBotToken(botConfig.getBotToken());
        consumptionBot.setQueryProcess(new QueryProcess());
        //consumptionBot.setCallbackQueryHandler(new CallbackQueryHandler());
        return consumptionBot;
    }

    @Bean
    public CallbackQueryHandler CallbackQueryTelegramHandler(){
        CallbackQueryHandler callbackQueryHandler = new CallbackQueryHandler();
        return callbackQueryHandler;
    }

    @Bean
    public Calculator CalculatorBot(){
        Calculator calculator = new Calculator();
        return calculator;
    }
}
