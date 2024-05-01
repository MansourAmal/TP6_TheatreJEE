package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenreDaoImpl;
import dao.IGenreDao;
import dao.IPieceTheatreDao;
import dao.PieceTheatreDaoImpl;
import metier.theatre.Genre;
import metier.theatre.PieceTheatre;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    IPieceTheatreDao metier;
    IGenreDao metiergen;

    @Override
    public void init() throws ServletException {
        metier = new PieceTheatreDaoImpl();
        metiergen = new GenreDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("piecesTheatre.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            PieceTheatreModele model = new PieceTheatreModele();
            model.setMotCle(motCle);
            List<PieceTheatre> piecesTheatre = metier.piecesTheatreParMC(motCle);
            model.setPiecesTheatre(piecesTheatre);
            request.setAttribute("model", model);
            request.getRequestDispatcher("piecesTheatre.jsp").forward(request, response);
            
        } else if (path.equals("/saisie.do")) {
        	List<Genre> cats = metiergen.getAllGenres();
        	GenreModel model= new GenreModel();
        	model.setGenres(cats);
        	request.setAttribute("genModel", model);
        	
            request.getRequestDispatcher("saisiePieceth.jsp").forward(request, response);
            
            
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nomPieceTheatre = request.getParameter("nomPieceTheatre");
            Long genreId=Long.parseLong(request.getParameter("genre"));
            String auteur = request.getParameter("auteur");
            Genre cat = metiergen.getGenre(genreId);
            PieceTheatre pieceTheatre = metier.save(new PieceTheatre(nomPieceTheatre, auteur,cat));
            request.setAttribute("pieceTheatre", pieceTheatre);
            response.sendRedirect("chercher.do?motCle=");
       
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deletePieceTheatre(id);
            response.sendRedirect("chercher.do?motCle=");
            
            
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            PieceTheatre pieceTheatre = metier.getPieceTheatre(id);
            request.setAttribute("pieceTheatre", pieceTheatre);
            
            List<Genre> cats = metiergen.getAllGenres();
            GenreModel model= new GenreModel();
            model.setGenres(cats);
            request.setAttribute("genModel", model);
            
            request.getRequestDispatcher("editerPiece.jsp").forward(request, response);
        }
        
        else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nomPieceTheatre = request.getParameter("nomPieceTheatre");
            String auteur = request.getParameter("auteur");
            Long genreId=Long.parseLong(request.getParameter("genre"));
            PieceTheatre pieceTheatre = new PieceTheatre();
            pieceTheatre.setCODE(id);
            pieceTheatre.setNOM(nomPieceTheatre);
            pieceTheatre.setAUTEUR(auteur);
            Genre cat = metiergen.getGenre(genreId);
            pieceTheatre.setGenre(cat);
            metier.updatePieceTheatre(pieceTheatre);
            request.setAttribute("pieceTheatre", pieceTheatre);
            response.sendRedirect("chercher.do?motCle=");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

