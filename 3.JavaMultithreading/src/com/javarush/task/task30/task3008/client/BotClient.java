package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public static void main(String[] args) throws InterruptedException {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        final int  NUMBER_OF_CLIENT = 100;
        return "date_bot_" + ((int)(NUMBER_OF_CLIENT*Math.random()));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (!message.contains(": ")) {
                return;
            }

            String userName = message.substring(0, message.indexOf(": "));
            String textMessage = message.substring(message.indexOf(": ") + 2);
            /*
            if(userName == null || textMessage == null) {
                return;
            }*/

            String pattern;

            switch (textMessage) {
                case "дата":
                    pattern = "d.MM.YYYY";
                    break;
                case "день":
                    pattern = "d";
                    break;
                case "месяц":
                    pattern = "MMMM";
                    break;
                case "год":
                    pattern = "YYYY";
                    break;
                case "время":
                    pattern = "H:mm:ss";
                    break;
                case "час":
                    pattern = "H";
                    break;
                case "минуты":
                    pattern =  "m";
                    break;
                case "секунды":
                    pattern =  "s";
                    break;
                default:
                    return;
            }

            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            Calendar calendar = new GregorianCalendar();
            Date cuttentDate = calendar.getTime();
            sendTextMessage("Информация для " + userName + ": " + formatter.format(cuttentDate));
        }
    }
}
