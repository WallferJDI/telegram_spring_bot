package com.example.telegram_spring_bot.bot.handlers;

import com.example.telegram_spring_bot.bot.service.ReplyMessageButtonsService;
import com.example.telegram_spring_bot.bot.service.ReplyMessageService;
import com.example.telegram_spring_bot.calculator.Calculator;
import com.example.telegram_spring_bot.configuration.contextfinal.BotStateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

public class MessageQueryHandler {

    public SendMessage queryMessageProcess(Message message, ReplyMessageButtonsService replyMessageButtonsService, ButtonsOutputHandler buttonsOutputHandler) throws TelegramApiException {

       switch (BotStateContext.CURRENT_BOT_STATEMENT){
           //case BotStateContext.MENU:
           //    return queryEntities(message,replyMessageButtonsService,buttonsOutputHandler);
           case BotStateContext.LITRES_KILOMETERS_FORK:
               return queryDigit(message);
           default:
               return queryEntities(message,replyMessageButtonsService,buttonsOutputHandler);
       }




    }

    public SendMessage queryEntities(Message message,ReplyMessageButtonsService replyMessageButtonsService,ButtonsOutputHandler buttonsOutputHandler) throws TelegramApiException {
        Optional<MessageEntity> commandEntity =
                message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
        if (commandEntity.isPresent()) {
            String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
            switch (command) {
                case "/calculate":

                    return replyMessageButtonsService.sendInlineKeyBoardMessage(message,buttonsOutputHandler.getButtonsChooseLitresKilometers(),"What we will calculate bro?");

            }
        }
        return null;
    }

    public SendMessage queryDigit(Message message) throws TelegramApiException {

        ReplyMessageButtonsService replyMessageButtonsService = new ReplyMessageButtonsService();
        ButtonsOutputHandler buttonsOutputHandler = new ButtonsOutputHandler();

        //ReplyMessageService replyMessageService = new ReplyMessageService();
        BotStateContext.CURRENT_BOT_STATEMENT = BotStateContext.CITY_TRACE_FORK;
        return replyMessageButtonsService.sendInlineKeyBoardMessage(message,buttonsOutputHandler.getButtonsChooseTraceCity(),"where you drive "+message.getText()); //replyMessageService.sendMessage(message, message.getText()+" Your digit");

    }
}
