package com.gorevtakibi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gorevtakibi.model.Task;
import com.gorevtakibi.service.TaskService;


@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
    public void setTaskService(TaskService TaskService) {
        this.taskService = 	TaskService;
    }
	
	@RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
	public String index(Model model) {
		
		List<Task> task = taskService.getTaskList();
		model.addAttribute("taskList",task );

		return "/user/welcome";
	}
	@RequestMapping(value = "user/savetask", method = RequestMethod.GET)
    public String list(Model model) {
	    model.addAttribute("statusList", getStatus());

        model.addAttribute("task", new Task());
        return "user/savetask";
    }
	
	@RequestMapping(value = "user/savetask", method = RequestMethod.POST)
    public String save(@Valid Task saveTask,BindingResult bindingResult) {
	    taskService.save(saveTask);
        return "redirect:/user/welcome" ;
    }
	
	@RequestMapping(value={"user/edittask/{id}"}, method = RequestMethod.GET)
    public String EditForm(Model model, @PathVariable(required = false, name = "id") Integer id) {
		 model.addAttribute("statusList", getStatus());
		 model.addAttribute("edittask", taskService.findOne(id));

         
        return "user/edittask";
    }

	@RequestMapping(value="user/edittask", method = RequestMethod.POST)
    public String Edit(Model model,@Valid Task Task,BindingResult bindingResult) {
	 
     model.addAttribute("edittask", taskService.getTaskList());
     
    	taskService.save(Task);
        
        return "redirect:/user/welcome";
    }

	@RequestMapping(value = "/admin/welcome", method = RequestMethod.GET)
	public String indexAdmin(Model model) {
		
		List<Task> task = taskService.getTaskList();
		model.addAttribute("taskList",task );

		return "/admin/welcome";
	}
	@RequestMapping(value = "admin/savetask", method = RequestMethod.GET)
    public String listForAdmin(Model model) {
	    model.addAttribute("statusList", getStatus());

        model.addAttribute("task", new Task());
        return "admin/savetask";
    }
	
	@RequestMapping(value = "admin/savetask", method = RequestMethod.POST)
    public String saveTask(@Valid Task saveTaskAdmin,BindingResult bindingResult) {
	    taskService.save(saveTaskAdmin);
        return "redirect:/admin/welcome" ;
    }
	
	@RequestMapping(value={"admin/edittask/{id}"}, method = RequestMethod.GET)
    public String EditFormAdmin(Model model, @PathVariable(required = false, name = "id") Integer id) {
		 model.addAttribute("statusList", getStatus());
		 model.addAttribute("edittask", taskService.findOne(id));

         
        return "admin/edittask";
    }

	@RequestMapping(value="admin/edittask", method = RequestMethod.POST)
    public String editPage(Model model,@Valid Task Task,BindingResult bindingResult) {
	 
     model.addAttribute("edittask", taskService.getTaskList());
     
    	taskService.save(Task);
        
        return "redirect:/admin/welcome";
    }
	
	 @RequestMapping(value="admin/delete/{id}", method = RequestMethod.GET)
	    public String deleteTaskAdmin(Model model, @PathVariable(required = true, name = "id") int id) {
	    	taskService.delete(id);
	        model.addAttribute("delete", taskService.getTaskList());
	        return "redirect:/admin/welcome";
	    }
	
	private List<String> getStatus() {
		List<String> list = new ArrayList<String>();
		String s1 = "Tamamlandi";
		String s2 = "Iptal edildi";
		String s3 = "Ertelendi";
		String s4 = "Yapilacak";
	    list.add(s1);
	    list.add(s2);
	    list.add(s3);
	    list.add(s4);
		return list;
	}

}
