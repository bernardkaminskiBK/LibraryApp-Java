package UI.pages.Rentals;

import UI.Application;
import UI.base.MenuPageBase;

public class RentalsPage extends MenuPageBase
{
    private static final String PAGE_HEADER = "Rentals page";

    public RentalsPage(Application app)
    {
        super(PAGE_HEADER, app);
        InitializeMenu();
    }

    @Override
    public void Display()
    {
        super.Display();

        this.getMenu().display();
    }

    private void InitializeMenu()
    {
        this.getMenu().Add(1, "Back", () -> this.getApplication().navigateBack());
    }
}

