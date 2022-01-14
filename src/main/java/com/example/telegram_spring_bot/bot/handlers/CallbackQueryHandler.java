package com.example.telegram_spring_bot.bot.handlers;

import com.example.telegram_spring_bot.bot.service.ReplyMessageButtonsService;
import com.example.telegram_spring_bot.bot.service.ReplyMessageService;
import com.example.telegram_spring_bot.configuration.contextfinal.BotCommandsContext;
import com.example.telegram_spring_bot.configuration.contextfinal.BotStateContext;
import com.example.telegram_spring_bot.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

@Component
public class CallbackQueryHandler {

    public SendMessage queryCallbackProcess(CallbackQuery userQuery, ReplyMessageService replyMessageService){
        Message message = userQuery.getMessage();
        String[] param = userQuery.getData().split(":");
        String action = param[0];
        switch (action){
            case BotCommandsContext.CHOOSE_LITRES:
            BotStateContext.CURRENT_BOT_STATEMENT= BotStateContext.LITRES_KILOMETERS_FORK;
                return replyMessageService.sendMessage(message,"Write how much kilometers you wrote");


            case BotCommandsContext.CHOOSE_KILOMETERS:
                BotStateContext.CURRENT_BOT_STATEMENT= BotStateContext.LITRES_KILOMETERS_FORK;
                return replyMessageService.sendMessage(message,"Write how much oil you burn");

            case BotCommandsContext.CHOOSE_CITY:
                BotStateContext.CURRENT_BOT_STATEMENT =  BotStateContext.CITY_TRACE_FORK;

                return replyMessageService.sendMessage(message,"Choosed city");
            case BotCommandsContext.CHOOSE_TRACE:
                BotStateContext.CURRENT_BOT_STATEMENT =  BotStateContext.CITY_TRACE_FORK;
                return replyMessageService.sendMessage(message,"Choosed trace");

        }

        return null;
    }


}


