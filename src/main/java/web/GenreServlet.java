package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.GenreDaoImpl;
import dao.IGenreDao;
import metier.theatre.Genre;

@WebServlet(name = "genreServ", urlPatterns = { "/genres", "/saisiegenre", "/savegenre", "/supprimerGenre", "/editergenre", "/updateGenre" })
public class GenreServlet extends HttpServlet {

    private IGenreDao metier;

    @Override
    public void init() throws ServletException {
        metier = new GenreDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("PATH " + path);
        if (path.equals("/genres")) {
            GenreModel model = new GenreModel();
            List<Genre> genres = metier.getAllGenres();
            model.setGenres(genres);
            request.setAttribute("model", model);
            request.getRequestDispatcher("genres.jsp").forward(request, response);
        } else if (path.equals("/saisiegenre")) {
            request.getRequestDispatcher("saisieGenre.jsp").forward(request, response);
        } else if (path.equals("/savegenre") && request.getMethod().equals("POST")) {
            Date dateGenre = new Date();
            String nom = request.getParameter("nom");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                dateGenre = simpleDateFormat.parse(request.getParameter("dateGenre"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Genre genre = metier.save(new Genre(nom, dateGenre));
            request.setAttribute("genre", genre);
            response.sendRedirect("genres");
        } else if (path.equals("/supprimerGenre")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteGenre(id);
            response.sendRedirect("genres");
        } else if (path.equals("/editergenre")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Genre genre = metier.getGenre(id);
            request.setAttribute("genre", genre);
            request.getRequestDispatcher("editergenre.jsp").forward(request, response);
        } else if (path.equals("/updateGenre")) {
            Date dateGenre = new Date();
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            Genre genre = new Genre();
            genre.setIdG(id);
            genre.setNomG(nom);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                dateGenre = simpleDateFormat.parse(request.getParameter("dateCreation"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            genre.setDateCreation(dateGenre);
            metier.updateGenre(genre);
            response.sendRedirect("genres");
        } else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
