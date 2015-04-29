package action;

import DAO.CoursesDAO;
import DAO.TaughtCoursesDAO;
import DAO.TeachersDAO;
import entity.Courses;
import entity.TaughtCourses;
import entity.Teachers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fowafolo on 15/4/29.
 */
@WebServlet(name = "ShowCourses" ,urlPatterns = "/ShowCourses")
public class ShowCourses extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String courseName = request.getParameter("courseName");
        String operator = request.getParameter("operator");
        String teacherName = request.getParameter("teacherName");
        System.out.println("action=");
        System.out.println(action);
        System.out.print("courseName=");
        System.out.println(courseName);
        if (action==null){
            action="list";
        }
        if (action.equals("list")){
            listAllInformation(request,response);
        }
        if (action.equals("find")){
            System.out.println("findBegin");
            findCourse(courseName, operator, teacherName, request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String courseName = request.getParameter("courseName");
        String operator = request.getParameter("operator");
        String teacherName = request.getParameter("teacherName");
        System.out.println("action=");
        System.out.println(action);
        System.out.print("courseName=");
        System.out.println(courseName);
        if (action==null){
            action="list";
        }
        if (action.equals("list")){
            listAllInformation(request,response);
        }
        if (action.equals("find")){
            System.out.println("findBegin");
            findCourse(courseName, operator,teacherName, request, response);
        }
    }

    private void listAllInformation(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        CoursesDAO coursesDAO = new CoursesDAO();
        TaughtCoursesDAO taughtCoursesDAO = new TaughtCoursesDAO();
        TeachersDAO teachersDAO = new TeachersDAO();
        ArrayList<Courses>courses = coursesDAO.getAllCourses();
        ArrayList<TaughtCourses>taughtCourses = taughtCoursesDAO.getAllTaughtCourses();
        ArrayList<Teachers>teachers = teachersDAO.getAllTeachers();
        request.setAttribute("courses",courses);
        request.setAttribute("taughtCourses",taughtCourses);
        request.setAttribute("teachers",teachers);
        System.out.println(taughtCourses.size());
        request.getRequestDispatcher("CourseList.jsp").forward(request, response);

    }

    private void findCourse(String courseName,String operator,String teacherName, HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        CoursesDAO coursesDAO = new CoursesDAO();
        TaughtCoursesDAO taughtCoursesDAO = new TaughtCoursesDAO();
        TeachersDAO teachersDAO = new TeachersDAO();


        ArrayList<TaughtCourses>taughtCourses = taughtCoursesDAO.getAllTaughtCourses();
        ArrayList<Courses>courses = new ArrayList<Courses>();
        ArrayList<Teachers>teachers = new ArrayList<Teachers>();
        System.out.println("oerato:");
        System.out.println(operator);
        if (operator.equals("and")){
            courses = coursesDAO.findByCourse(courseName);
           teachers = teachersDAO.findByTeacher(teacherName);
            request.setAttribute("courses",courses);
            request.setAttribute("taughtCourses",taughtCourses);
            request.setAttribute("teachers",teachers);
            System.out.print("courseSIZE:");
            System.out.println(courses.size());
            request.getRequestDispatcher("CourseList.jsp").forward(request, response);
        } else {
            courses = coursesDAO.findByCourse(courseName);
            teachers = teachersDAO.findByTeacher(teacherName);
            if (courses.size()!=0){
                request.setAttribute("courses",courses);
                request.setAttribute("taughtCourses",taughtCourses);
                request.setAttribute("teachers",teachers);
                System.out.print("courseSIZE:");
                System.out.println(courses.size());
                request.getRequestDispatcher("CourseList.jsp").forward(request, response);
            }else if (teachers.size()!=0){
                request.setAttribute("courses",courses);
                request.setAttribute("taughtCourses",taughtCourses);
                request.setAttribute("teachers",teachers);
                System.out.print("courseSIZE:");
                System.out.println(courses.size());
                request.getRequestDispatcher("CourseList.jsp").forward(request, response);
            }
        }

//        request.setAttribute("courses",courses);
//        request.setAttribute("taughtCourses",taughtCourses);
//        request.setAttribute("teachers",teachers);
//        System.out.print("courseSIZE:");
//        System.out.println(courses.size());
//        request.getRequestDispatcher("CourseList.jsp").forward(request, response);
    }

}
