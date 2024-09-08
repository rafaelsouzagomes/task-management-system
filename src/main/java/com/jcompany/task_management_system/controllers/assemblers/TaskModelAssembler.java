package com.jcompany.task_management_system.controllers.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.jcompany.task_management_system.controllers.TaskController;
import com.jcompany.task_management_system.entities.Task;

@Component
public class TaskModelAssembler implements RepresentationModelAssembler<Task, EntityModel<Task>> {

	@Override
    public EntityModel<Task> toModel(Task task) {
        return EntityModel.of(task,
                linkTo(methodOn(TaskController.class).getTasksByUserId(task.getIdTask())).withRel("getTaskByUserId"),
                linkTo(methodOn(TaskController.class).markAsDone(task.getIdTask())).withRel("markAsDone"),
                linkTo(methodOn(TaskController.class).uncheckTask(task.getIdTask())).withRel("uncheckTask"),
                linkTo(methodOn(TaskController.class).deleteTask(task.getIdTask())).withRel("delete"));
    }

    public CollectionModel<Task> toCollectionModel(List<Task> tasks) {
        Link selfLink = linkTo(methodOn(TaskController.class).getAll()).withSelfRel();
        Link createLink = linkTo(methodOn(TaskController.class).add(null)).withRel("create");
        Link markAllAsDoneLink = linkTo(methodOn(TaskController.class).markAllAsDone()).withRel("markAllAsDone");
        Link uncheckAllTasksLink = linkTo(methodOn(TaskController.class).uncheckAllTasks()).withRel("uncheckAllTasks");

        return CollectionModel.of(tasks, selfLink, createLink, markAllAsDoneLink, uncheckAllTasksLink);
    }
}