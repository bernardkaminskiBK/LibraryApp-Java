package UI.pages;

import UI.Application;
import UI.base.MenuPageBase;
import UI.helpers.OutputHelper;
import UI.pages.Members.MembersPage;
import UI.pages.Messages.MessagesPage;
import UI.pages.Rentals.RentalsPage;
import UI.pages.Titles.TitlesPage;

public class MainPage extends MenuPageBase
{
    private static final String MAIN_PAGE_CONST = ">>>> Welcome to our Library <<<<";
    public MainPage(Application app)
    {
        super(MAIN_PAGE_CONST, app);
        InitializeMenuOptions();
    }

    private void InitializeMenuOptions()
    {
        this.getMenu().Add(1, "Titles", () -> this.getApplication().navigateTo(TitlesPage.class));
        this.getMenu().Add(2, "Members", () -> this.getApplication().navigateTo(MembersPage.class));
        this.getMenu().Add(3, "Rentals", () -> this.getApplication().navigateTo(RentalsPage.class));
        this.getMenu().Add(4, "Messages", () -> this.getApplication().navigateTo(MessagesPage.class));
        this.getMenu().Add(5, "Exit", () -> this.getApplication().Exit());
    }

    @Override
    public void Display()
    {
        OutputHelper.WriteLine(">>>> Welcome to our Library <<<<");
        super.Display();
        OutputHelper.WriteLine("\n");

        this.getMenu().display();
    }
}
