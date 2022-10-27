package UI.base;

import UI.Application;
import UI.UIElements.Menu;

public abstract class MenuPageBase extends PageBase
{
    public MenuPageBase(String title, UI.Application app)
    {
        super(title, app);
        this.setMenu(new Menu());
    }

    private UI.UIElements.Menu Menu;
    protected final Menu getMenu()
    {
        return Menu;
    }
    protected final void setMenu(Menu value)
    {
        Menu = value;
    }

    @Override
    public void Display()
    {
//        Console.Clear();
        super.Display();
    }
}

