package com.example.telegram_spring_bot.bot;

import com.example.telegram_spring_bot.bot.handlers.ButtonsOutputHandler;
import com.example.telegram_spring_bot.bot.handlers.CallbackQueryHandler;
import com.example.telegram_spring_bot.bot.service.ReplyMessageButtonsService;
import com.example.telegram_spring_bot.botapi.QueryProcess;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class ConsumptionBot extends TelegramLongPollingBot {
    private String userName;
    private String botToken;
    private QueryProcess queryProcess;


    public ConsumptionBot(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasCallbackQuery()) {
            handleCallback(update);
        } else if (update.hasMessage()) {
            handleMessage(update);
        }


    }

    private void handleMessage(Update update) throws TelegramApiException {
        execute(queryProcess.getMessageCallbackQuery(update));

    }

    private void handleCallback (Update update) throws TelegramApiException {
           execute( queryProcess.getButtonsCallbackQuery(update));
        }


    public void setQueryProcess(QueryProcess queryProcess) {
        this.queryProcess = queryProcess;
    }
}


