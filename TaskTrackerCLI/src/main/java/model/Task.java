package model;

import java.time.LocalDateTime;

public class Task {
    private int idTask;
    private String description;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Task(int idTask, String description) {
        this.idTask = idTask;
        this.description = description;
        this.status = "todo";
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updateAt = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.updateAt = LocalDateTime.now();
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "ID: " + idTask + "\n" +
                " | Description: " + description + "\n" +
                " | Status: " + status + "\n" +
                " | Create At: " + createAt + "\n" +
                " | Update At: " + updateAt + "\n";
    }
}
