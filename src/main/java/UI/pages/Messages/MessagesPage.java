package UI.pages.Messages;

import UI.Application;
import UI.base.MenuPageBase;
import UI.helpers.InputHelper;

public class MessagesPage extends MenuPageBase
{
    private static final String PAGE_HEADER = "Messages page";

    public MessagesPage(UI.Application app)
    {
        super(PAGE_HEADER, app);

    }

    @Override
    public void Display()
    {
        super.Display();

//        InputHelper.ReadKey("Press any key to return to Main menu...");

        this.getApplication().navigateBack();
    }
}

