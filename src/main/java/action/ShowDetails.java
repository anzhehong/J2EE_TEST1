package action;

import DAO.CoursesDAO;
import DAO.TeachersDAO;
import entity.Courses;
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
@WebServlet(name = "ShowDetails",urlPatterns = "/ShowDetails")
public class ShowDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String courseName = request.getParameter("courseName");
        String teacherName = request.getParameter("teacherName");
        if (action == null){
            action = "nameDetail";
        }
        if (action.equals("nameDetail"))
        {
            listCourseDetail(courseName,request,response);
        }
        if (action.equals("teacherDetail")){
            listTeacherDetail(teacherName,request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String courseName = request.getParameter("courseName");
        String teacherName = request.getParameter("teacherName");
        if (action == null){
            action = "nameDetail";
        }
        if (action.equals("nameDetail"))
        {
            listCourseDetail(courseName,request,response);
        }
        if (action.equals("teacherDetail")){
            listTeacherDetail(teacherName,request,response);
        }
    }

    private void listCourseDetail(String courseName,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        CoursesDAO coursesDAO = new CoursesDAO();
        ArrayList<Courses>list = coursesDAO.searchName(courseName);
        request.setAttribute("courses",list);
        System.out.println("courseDetil");
        System.out.println(list.size());
        request.getRequestDispatcher("Course.jsp").forward(request,response);
    }
    private void listTeacherDetail(String teacherName,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        TeachersDAO teachersDAO = new TeachersDAO();
        ArrayList<Teachers>list = teachersDAO.searchName(teacherName);
        request.setAttribute("teachers",list);
        request.getRequestDispatcher("Teacher.jsp").forward(request,response);
    }
}
