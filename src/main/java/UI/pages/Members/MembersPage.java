package UI.pages.Members;

import UI.Application;
import UI.base.MenuPageBase;

public class MembersPage extends MenuPageBase
{
    private static final String PAGE_HEADER = "Members page";

    public MembersPage(Application app)
    {
        super(PAGE_HEADER, app);
        InitializeOptions();
    }


    private void InitializeOptions()
    {
        this.getMenu().Add(1, "Back", () -> this.getApplication().navigateBack());
    }

    @Override
    public void Display()
    {
        super.Display();

        this.getMenu().display();
    }
}

