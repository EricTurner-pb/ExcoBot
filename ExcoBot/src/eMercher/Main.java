package eMercher;

import org.excobot.bot.script.GameScript;
import eMercher.data.*;
import eMercher.TradeItem;
import eMercher.Trade;
import org.excobot.game.api.event.events.MessageEvent;
import org.excobot.game.api.event.listeners.MessageListener;
import org.excobot.game.api.methods.input.Keyboard;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.animable.actor.Actor;

/**
 * Created by EricTurner on 4/19/2014.
 */
public class Main extends GameScript {
    private Stage current;

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public int execute() throws InterruptedException {
        switch (current = findStage()) {

            case CHATBUY:
               /* TradeItem t = new TradeItem(329, false);
                t.*/
                //new Trade().
                Keyboard.sendKeys("Buying " + Data.ITEMNAME, true);
                Time.sleep(25 * 1000);
                break;
            case CHATSELL:
                Keyboard.sendKeys("Selling " + Data.ITEMNAME, true);
                break;
            case TRADESELL:

                break;
            case TRADEBUY:

                break;
        }
        return 0;
    }

    private Stage findStage() {
        if (Inventory.contains(Data.ID)) {
            if (MessageEvent.MESSAGE_TRADE_REQ == 0) {
                return Stage.CHATSELL;
            } else if (MessageEvent.MESSAGE_TRADE_REQ > 0) {
                return Stage.TRADESELL;
            }
        }
        else if (!Inventory.contains(Data.ID) && Inventory.getCount(995, true) >= Data.BUYPRICE) {
            if (MessageEvent.MESSAGE_TRADE_REQ == 0) {
                return Stage.CHATBUY;
            } else if (MessageEvent.MESSAGE_TRADE_REQ > 0) {
                return Stage.TRADEBUY;
            }
        }
        return Stage.WAIT;
    }

    public static enum Stage {
        CHATSELL, CHATBUY, TRADESELL, TRADEBUY, WAIT;
        public String getName() {
            return name().toLowerCase();
        }
    }

}
