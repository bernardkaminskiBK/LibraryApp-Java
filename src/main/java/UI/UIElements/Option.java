package UI.UIElements;

import UI.tangible.Action0Param;

public class Option {

    private String Name;

    public final String getName() {
        return Name;
    }

    public final void setName(String value) {
        Name = value;
    }

    private Action0Param callBack;

    public Action0Param getCallBack() {
        return callBack;
    }

    private void setCallBack(Action0Param value) {
        callBack = value;
    }

    private int Ordinal;

    public final int getOrdinal() {
        return Ordinal;
    }

    public final void setOrdinal(int value) {
        Ordinal = value;
    }

    public Option(int ordinal, String name, Action0Param callback) {
        setOrdinal(ordinal);
        setName(name);
        setCallBack(callback);
    }

}


