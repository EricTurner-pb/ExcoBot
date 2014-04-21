package eMercher;

import org.excobot.bot.script.Condition;
import org.excobot.game.api.methods.cache.Game;
import org.excobot.game.api.methods.cache.media.Menu;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.input.Keyboard;
import org.excobot.game.api.methods.input.Mouse;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.cache.media.Component;

public class TradeItem {

    private static int TRADE_INTERFACE = 335;

    int id;
    static Component component;

    public TradeItem(int id, boolean otherInventar) {
        this.id = id;
        TradeItem.component = (otherInventar ? Widgets.getComponent(TRADE_INTERFACE, 50) : Widgets.getComponent(TRADE_INTERFACE, 48));
    }

    public boolean interact(final String interaction) {
        if (component == null || !component.isVisible())
            return false;
        for (Component c : component.getChildren())
            if (c != null && c.getComponentId() == id) {
                Mouse.move(c.getRectangle());
                Time.sleep(new Condition() {
                    @Override
                    public boolean validate() {
                        return !Menu.contains(interaction);
                    }
                }, 500);
                return Menu.interact(interaction);
            }

        return false;
    }

    public boolean removeX(int amount) {
        if (component == null || !component.isVisible())
            return false;
        interact("Remove-X");
        Time.sleep(new Condition() {
            @Override
            public boolean validate() {
                return !canEnterAmount();
            }
        }, 2000);
        return (canEnterAmount() ? Keyboard.sendKeys(""+amount, true) : false);

    }

    public int getAmount() {
        if (component == null || !component.isVisible())
            return 0;
        int total = 0;
        for (Component c : component.getChildren())
            if (c.getComponentId() == id)
                total += c.getItemStackSize();
        return total;
    }

    public boolean canEnterAmount() {
        return Game.getColorAt(257, 428) == -16777088;
    }

}