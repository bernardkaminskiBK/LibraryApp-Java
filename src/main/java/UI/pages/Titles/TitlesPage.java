package UI.pages.Titles;

import UI.Application;
import UI.base.MenuPageBase;

public class TitlesPage extends MenuPageBase
{

    private static final String TITLES_MENU_HEADER = "Titles";

    public TitlesPage(Application app)
    {
        super(TITLES_MENU_HEADER, app);
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

