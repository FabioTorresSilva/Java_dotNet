package pt.org.upskill.repository;

import pt.org.upskill.domain.TaskCategory;
import java.util.ArrayList;
import java.util.List;

public class TaskCategoryRepository {
    private final List<TaskCategory> taskCategories;
    public TaskCategoryRepository() {
        taskCategories = new ArrayList<>();
    }

    /**
     * This method returns an exsiting Task Category by its description.
     *
     * @param taskCategoryDescription The description of the task category to be created.
     * @return The task category.
     * @throws IllegalArgumentException if the task category does not exist, which should never happen.
     */
    public TaskCategory getTaskCategoryByDescription(String taskCategoryDescription) {
        TaskCategory newTaskCategory = new TaskCategory(taskCategoryDescription);
        TaskCategory taskCategory = null;
        if (taskCategories.contains(newTaskCategory)) {
            taskCategory = taskCategories.get(taskCategories.indexOf(newTaskCategory));
        }
        if (taskCategory == null) {
            throw new IllegalArgumentException(
                    "Task Category requested for [" + taskCategoryDescription + "] does not exist.");
        }
        return taskCategory;
    }

    public TaskCategory add(TaskCategory taskCategory) {
        if (validateTaskCategory(taskCategory)) {
            TaskCategory newTaskCategory = taskCategory.clone();
            boolean operationSuccess = taskCategories.add(newTaskCategory);

            if (operationSuccess) {
                return newTaskCategory;
            }
        }
        return null;
    }

    private boolean validateTaskCategory(TaskCategory taskCategory) {
        boolean isValid = !taskCategories.contains(taskCategory);
        return isValid;
    }

    /**
     * This method returns a defensive (immutable) copy of the list of task categories.
     *
     * @return The list of task categories.
     */
    public List<TaskCategory> getTaskCategories() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(taskCategories);
    }
}