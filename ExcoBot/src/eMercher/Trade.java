package eMercher;

import org.excobot.bot.script.GameScript;
import org.excobot.bot.script.Manifest;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.wrappers.media.Item;

@Manifest(name = "Trade Method", authors = {"JoseDpay"}, version = 1, description = "")
public class Trade extends GameScript{

    final int PARENT_1 = 335;
    final int PARENT_2 = 334;

    /**
     * @return the name of the person your trading with
     */
    public String tradingWithName() {
        if (isTradeScreenOpen(true))
            return Widgets.get(PARENT_1).getChild(16).getText().replace("Trading With: ", "");
        else if (isTradeScreenOpen(false))
            return Widgets.get(PARENT_2).getChild(44).getText().replace("Trading with:<br>", "");
        return null;
    }

    /**
     *@param firstTradeScreen: true if your talking about the first trade screen, false for the second screen
     * @return true depending on which boolen you use
     */
    public boolean isTradeScreenOpen(boolean firstTradeScreen)      {
        if (firstTradeScreen)   {
            if (Widgets.get(PARENT_1)!=null)
                return Widgets.get(PARENT_1).getChild(16)!=null;
        }else{
            if (Widgets.get(PARENT_2)!=null)
                return Widgets.get(PARENT_2).getChild(33)!=null;
        }
        return false;
    }

    /**
     * @param firstTradeScreen: true if your talking about the first trade screen, false for the second screen
     *
     * @return: accepts both trade screens
     */
    public boolean acceptTrade(boolean firstTradeScreen)    {
        if (firstTradeScreen)   {
            if (this.isTradeScreenOpen(true))       {
                if (Widgets.get(PARENT_1).getChild(17)!=null)
                    return Widgets.get(PARENT_1).getChild(17).click(true);
            }
        }else{
            if (this.isTradeScreenOpen(false))      {
                if (Widgets.get(PARENT_2).getChild(20)!=null)
                    return Widgets.get(PARENT_2).getChild(20).click(true);
            }
        }
        return false;
    }

    /**
     * @param firstTradeScreen: true if your talking about the first trade screen, false for the second screen
     *
     * @return: declines both trade screens
     */
    public boolean declineTrade(boolean firstTradeScreen)   {
        if (firstTradeScreen)   {
            if (this.isTradeScreenOpen(true))       {
                if (Widgets.get(PARENT_1).getChild(18)!=null)
                    return Widgets.get(PARENT_1).getChild(18).click(true);
            }
        }else{
            if (this.isTradeScreenOpen(false))      {
                if (Widgets.get(PARENT_2).getChild(21)!=null)
                    return Widgets.get(PARENT_2).getChild(21).click(true);

            }
        }
        return false;
    }

    /**
     * Default Method
     */
    @Override
    public int execute() throws InterruptedException {

        return 1000;
    }

    @Override
    public boolean start() {
        return true;
    }
}