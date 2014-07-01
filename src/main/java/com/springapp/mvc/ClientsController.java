package com.springapp.mvc;

import com.springapp.mvc.template.ClientsJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by bildad on 27/06/14.
 * @Controller
 *
 */
@Controller
@RequestMapping("clients")
public class ClientsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getdata() {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        ClientsJDBCTemplate clientJDBCTemplate =
                (ClientsJDBCTemplate)context.getBean("clientsJDBCTemplate");



        List<Clients> clients = clientJDBCTemplate.listClients();




        //return back to index.jsp
        ModelAndView model = new ModelAndView("clients");
        model.addObject("clients", clients);

        return model;
    }

    }
