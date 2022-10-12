package Dialogs;

public class TaskDialogStructure {
    private String title;
    private String task;
    private boolean additionValue = false;


    public TaskDialogStructure(String title, String task, boolean additionValue) {
        this.title = title;
        this.task = task;
        this.additionValue = additionValue;
    }

    public String getTitle() {
        return title;
    }

    public String getTask() {
        return task;
    }

    public boolean isAdditionValue() {
        return additionValue;
    }
}
