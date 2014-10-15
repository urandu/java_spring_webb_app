package com.springapp.mvc;

import com.springapp.mvc.template.QuestionsJDBCTemplate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class QuestionsController {
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        QuestionsJDBCTemplate questionsJDBCTemplate =
                (QuestionsJDBCTemplate)context.getBean("questionsJDBCTemplate");



        if (questionsJDBCTemplate.listQuestions(1).isEmpty())
        {
            model.addAttribute("message", "Hello world!");
        }


        model.addAttribute("command",new Page_number());

        return "questions";
    }


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String get_questions(@ModelAttribute("page_number")Page_number page_number,
                             ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        QuestionsJDBCTemplate questionJDBCTemplate =
                (QuestionsJDBCTemplate) context.getBean("questionsJDBCTemplate");

        int page_no=page_number.getPage_number();

        /*String icomp = report1Filters.getIcomp();
        String renewal = report1Filters.getRenewal();
        model.addAttribute("report1", clientJDBCTemplate.getList(icomp, renewal));
        model.addAttribute("icomp",icomp);
        model.addAttribute("renewal",renewal);
        model.addAttribute("dateFrom",report1Filters.getDateFrom());
        model.addAttribute("dateTo",report1Filters.getDateTo());*/


        return "report1_result";
    }




    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String addStudent(@ModelAttribute("page_number")Page_number page_number,
                             ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        QuestionsJDBCTemplate questionJDBCTemplate =
                (QuestionsJDBCTemplate) context.getBean("questionsJDBCTemplate");

        int page_no=page_number.getPage_number();

        /*String icomp = report1Filters.getIcomp();
        String renewal = report1Filters.getRenewal();
        model.addAttribute("report1", clientJDBCTemplate.getList(icomp, renewal));
        model.addAttribute("icomp",icomp);
        model.addAttribute("renewal",renewal);
        model.addAttribute("dateFrom",report1Filters.getDateFrom());
        model.addAttribute("dateTo",report1Filters.getDateTo());*/


        return "report1_result";
    }



}