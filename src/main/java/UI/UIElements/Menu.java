package UI.UIElements;

import UI.helpers.InputHelper;
import UI.helpers.OutputHelper;
import UI.tangible.Action0Param;

import java.util.*;

public class Menu
{
    private ArrayList<Option> Options;
    private ArrayList<Option> getOptions()
    {
        return Options;
    }
    private void setOptions(ArrayList<Option> value)
    {
        Options = value;
    }

    public Menu()
    {
        setOptions(new ArrayList<Option>());
    }

    public final void display()
    {
        for (var option : getOptions())
        {
            OutputHelper.WriteLine(String.format("%1$s - %2$s", option.getOrdinal(), option.getName()));
        }

        int choice = InputHelper.ReadInt("Choose an option: ", 1, getOptions().size());

        getOptions().get(choice - 1).getCallBack().invoke();
    }



    public final Menu Add(int ordinal, String option, Action0Param callback)
    {
        return Add(new Option(ordinal, option, callback));
    }

    public final Menu Add(Option option)
    {
        getOptions().add(option);
        return this;
    }

//    public final boolean Contains(String option)
//    {
//        return getOptions().FirstOrDefault(op = Objects.equals(> op.Name, option)) == null;
//    }
}




