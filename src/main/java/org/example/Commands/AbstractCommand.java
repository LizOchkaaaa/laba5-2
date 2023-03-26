package org.example.Commands;

import org.example.interfaces.Execute;

public abstract class AbstractCommand implements Execute {
    private String name;
    private String discription;

    private Integer extraArgs;

    public AbstractCommand(String name, String discription , Integer extraArgs ) {
        this.name = name;
        this.discription = discription;
        this.extraArgs = extraArgs;
    }

    public Integer getExtraArgs() {
        return extraArgs;
    }

    @Override
    public String toString() {
        return name + " - " + discription;
    }

    public boolean isNeededExtraArgs(){
        return extraArgs > 2;
    }

    public String getName() {
        return name;
    }

}
