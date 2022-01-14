package com.example.telegram_spring_bot.botapi;

import com.example.telegram_spring_bot.bot.handlers.ButtonsOutputHandler;
import com.example.telegram_spring_bot.bot.handlers.CallbackQueryHandler;
import com.example.telegram_spring_bot.bot.handlers.MessageQueryHandler;
import com.example.telegram_spring_bot.bot.service.ReplyMessageButtonsService;
import com.example.telegram_spring_bot.bot.service.ReplyMessageService;
import com.example.telegram_spring_bot.calculator.Calculator;
import com.example.telegram_spring_bot.configuration.contextfinal.BotStateContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class QueryProcess {
    private ReplyMessageButtonsService replyMessageButtonsService = new ReplyMessageButtonsService();
    private ReplyMessageService replyMessageService = new ReplyMessageService();
    private ButtonsOutputHandler buttonsOutputHandler = new ButtonsOutputHandler();
    private Calculator calculator = new Calculator();
    private BotStateContext botStateContext;
    private CallbackQueryHandler callbackQueryHandler = new CallbackQueryHandler();
    private MessageQueryHandler messageQueryHandler = new MessageQueryHandler();

    public SendMessage getMessageCallbackQuery(Update update) throws TelegramApiException {

        return messageQueryHandler.queryMessageProcess(update.getMessage(),new ReplyMessageButtonsService(),new ButtonsOutputHandler());


    }
    public SendMessage getButtonsCallbackQuery(Update update) throws TelegramApiException {

        return callbackQueryHandler.queryCallbackProcess(update.getCallbackQuery(),replyMessageService);

    }


}
