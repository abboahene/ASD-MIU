package paint;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<Command> undoList;
    private List<Command> redoList;

    public HistoryList() {
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void undo() {
        // remove last elem
        // put in redo list
        // clear screen
        // apply all in undo list
        if(undoList.isEmpty()) return;
       Command c = undoList.remove(undoList.size() - 1);
       redoList.add(c);
       c.getG().clearRect(0, 50, 600, 600);
       for(Command command: undoList){
           command.execute();
       }

    }
    public void redo() {
        // remove last elem in redo
        // execute and add to undo list
        if(redoList.isEmpty()) return;
        Command c = redoList.remove(redoList.size() - 1);
        undoList.add(c);
        c.execute();
    }

    public void addCommand(Command command) {
        this.undoList.add(command);
    }
}
