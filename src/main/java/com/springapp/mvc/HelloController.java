package com.springapp.mvc;


import com.springapp.mvc.template.ClientsJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
       ClientsJDBCTemplate clientJDBCTemplate =
                (ClientsJDBCTemplate)context.getBean("clientsJDBCTemplate");
        List<Clients> clients = clientJDBCTemplate.listClients();
            model.addAttribute("clients", clients);
            model.addAttribute("reports",clientJDBCTemplate.getList());

		return "hello";
	}

}