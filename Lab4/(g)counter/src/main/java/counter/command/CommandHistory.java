package main.java.counter.command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {

    private List<Command> undoList;
    private List<Command> redoList;

    public CommandHistory() {
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void addCommand(Command command){
        undoList.add(command);
    }

    public void undo(){
        // remove last elem from undo list
        // do unExecute
        // add to redo list
        if(undoList.isEmpty()) return;
        Command c = undoList.remove(undoList.size() - 1);
        c.unExecute();
        redoList.add(c);
    }
    public void redo(){
        // remove last elem from redo list
        // do execute
        // add to undo list
        if(redoList.isEmpty()) return;
        Command c = redoList.remove(redoList.size() - 1);
        c.execute();
        undoList.add(c);
    }
}
