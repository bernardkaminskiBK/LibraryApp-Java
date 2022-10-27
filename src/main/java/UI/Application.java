package UI;

import UI.base.PageBase;
import UI.helpers.OutputHelper;
import UI.pages.MainPage;
import UI.pages.Titles.TitlesPage;
import UI.tangible.OutObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Application {


    // name of the page
    private String Title;

    protected final String getTitle() {
        return Title;
    }

    protected final void setTitle(String value) {
        Title = value;
    }

    private HashMap<java.lang.Class, PageBase> Pages;

    private HashMap<java.lang.Class, PageBase> getPages() {
        return Pages;
    }

    private void setPages(HashMap<java.lang.Class, PageBase> value) {
        Pages = value;
    }

    private Stack<PageBase> History;

    private Stack<PageBase> getHistory() {
        return History;
    }

    private void setHistory(Stack<PageBase> value) {
        History = value;
    }

    public final PageBase getCurrentPage() {
        return !getHistory().empty() ? getHistory().peek() : null;
    }

    public Application(String title) {
        this.setTitle(title);
        setPages(new HashMap<Class, PageBase>());
        setHistory(new Stack<PageBase>());

        BuildPages();
    }

    // navigation to home
    public final void NavigateHome() {
        while (getHistory().size() > 1) {
            getHistory().pop();
        }

//        Console.Clear();
        if (getCurrentPage() != null) {
            getCurrentPage().Display();
        }
    }

    public final void AddPage(PageBase page) {
        java.lang.Class pageType = page.getClass();

        if (getPages().containsKey(pageType)) {
            getPages().put(pageType, page);
        } else {
            getPages().put(pageType, page);
        }
    }

    public final <T extends PageBase> T navigateTo(Class<T> pageClazz) {
        if (getCurrentPage() != null && getCurrentPage().getClass() == pageClazz) {
            return (T) getCurrentPage();
        }


        PageBase nextPage = null;

        if (!(getPages().containsKey(pageClazz) && (nextPage = getPages().get(pageClazz)).equals(nextPage))) {
            throw new RuntimeException();
        }

        getHistory().push(nextPage);
//        Console.Clear();
        if (getCurrentPage() != null) {
            getCurrentPage().Display();
        }

        return (T) getCurrentPage();
    }

    public final PageBase navigateBack() {
        getHistory().pop();

//        Console.Clear();
        getCurrentPage().Display();
        return getCurrentPage();
    }

    public final int run() {
        try {
//            Console.Title = Title;
            this.setPage(MainPage.class);

            if (getCurrentPage() != null) {
                getCurrentPage().Display();
            }
            return 0;
        } catch (RuntimeException ex) {
            OutputHelper.WriteLine(ex.getMessage());

            return -1;
        }
    }

    public final <T extends PageBase> void setPage(Class<T> pageClazz) {

        if (getCurrentPage() != null && getCurrentPage().getClass() == pageClazz) {
            getCurrentPage();
            return;
        }
        // leave the current page

        // select the new page
        PageBase nextPage = null;

        OutObject<PageBase> tempOut_nextPage = new OutObject<PageBase>();
        if (!Pages.containsKey(pageClazz)) {
//            nextPage = tempOut_nextPage.outArgValue;
//            throw new KeyNotFoundException(String.format("The given page %1$s was not present in the program", pageType.getSimpleName()));
        } else {
            nextPage = Pages.get(pageClazz);
        }

        // enter the new page
        History.push(nextPage);

        getCurrentPage();
    }

    private void BuildPages() {
        this.AddPage(new MainPage(this));

        //Titles
        this.AddPage(new TitlesPage(this));
//
//        // Members
//        this.AddPage(new MembersPage(this));
//
//        // Rentals
//        this.AddPage(new RentalsPage(this));
//
//        // Messages
//        this.AddPage(new MessagesPage(this));
    }

    public final void Exit() {
        System.exit(0);
    }

}



