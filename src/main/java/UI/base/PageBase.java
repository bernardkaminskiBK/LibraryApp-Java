package UI.base;

import UI.Application;

public abstract class PageBase {
    public PageBase(String title, Application application) {
        this.setTitle(title);
        this.setApplication(application);
    }

    private String Title;

    public final String getTitle() {
        return Title;
    }

    public final void setTitle(String value) {
        Title = value;
    }

    private Application Application;

    public final Application getApplication() {
        return Application;
    }

    public final void setApplication(Application value) {
        Application = value;
    }

    public void Display() {
        System.out.println(getTitle());
    }
}

