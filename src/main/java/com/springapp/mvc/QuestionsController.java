package com.springapp.mvc;

import com.springapp.mvc.template.QuestionsJDBCTemplate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

import java.io.IOException;
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


    @RequestMapping(value = "/get_questions", method = RequestMethod.GET)
    public String get_questions(@ModelAttribute("page_number")Page_number page_number,
                             ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        QuestionsJDBCTemplate questionJDBCTemplate =
                (QuestionsJDBCTemplate) context.getBean("questionsJDBCTemplate");

        int page_no=page_number.getPage_number();

        if (questionJDBCTemplate.listQuestions(page_no).isEmpty()) {

            ///uncomment the below lines if you are using a proxy...
           /* System.setProperty("http.proxyHost", "proxy.uonbi.ac.ke");
            System.setProperty("http.proxyPort", "80");
*/
            Document doc;
            int i = 0;
            Question[] questions = new Question[30];
            try {

                // need http protocol
                doc = Jsoup.connect("http://www.careercup.com/page?n=" + page_no).timeout(60000).get();

                // get page title
                String title = doc.title();
                System.out.println("title : " + title);


                model.addAttribute("message1", title);
                // get all links
                Elements links = doc.getElementsByClass("entry").select("a[href]");
                //Elements links = doc.select("a[href]");

                i = 0;
                for (Element link : links) {


                    if (link.attr("href").contains("/question?id")) {
                        // get the value from href attribute

                        System.out.println("\nlink : " + link.attr("href").replace("/question?id=", ""));
                        System.out.println("text : " + link.text());
                        String id = link.attr("href").replace("/question?id=", "");
                        questions[i] = new Question(id, link.text(), page_no);

                        i++;
                    }

                }

                Elements companies = doc.getElementsByClass("company").select("img");
                //Elements links = doc.select("a[href]");
                i = 0;
                for (Element company : companies) {


                    // get the value from href attribute
                    System.out.println("\nlink : " + company.attr("title").replace("-interview-questions", ""));
                    System.out.println("text : " + company.text());
                    questions[i].setCompany_name(company.attr("title").replace("-interview-questions", ""));
                    i++;


                }

            } catch (IOException e) {
                e.printStackTrace();
            }



            for(Question question : questions)
            {
                questionJDBCTemplate.create(question.getQuestion_id(),question.getQuestion(),question.getCompany_name(),question.getPage_number());
            }

        }

       /* else
        {*/
            model.addAttribute("command",new Page_number());
            model.addAttribute("questions", questionJDBCTemplate.listQuestions(page_no));
       // }

        /*String icomp = report1Filters.getIcomp();
        String renewal = report1Filters.getRenewal();
        model.addAttribute("report1", clientJDBCTemplate.getList(icomp, renewal));
        model.addAttribute("icomp",icomp);
        model.addAttribute("renewal",renewal);
        model.addAttribute("dateFrom",report1Filters.getDateFrom());
        model.addAttribute("dateTo",report1Filters.getDateTo());*/


        return "questions";
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