package eMercher.data;

import javafx.stage.Stage;
import org.excobot.game.api.event.events.MessageEvent;
import org.excobot.game.api.methods.tab.Inventory;

/**
 * Created by EricTurner on 4/19/2014.
 */
public class Data {
    public static int ID = 0;
    public static int SELLPRICE = 0;
    public static int BUYPRICE = 0;
    public static int NUMBERTOSELL = 0;
    public static int NUMBERTOBUY = 0;
    public static String ITEMNAME = Inventory.getItem(ID).getName().toLowerCase();
}
