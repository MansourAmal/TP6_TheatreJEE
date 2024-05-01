package dao;

import java.util.List;

import metier.theatre.Genre;

public interface IGenreDao {
	public Genre save(Genre cat);
	public Genre getGenre(Long id);
	public Genre updateGenre(Genre cat);
	public void deleteGenre(Long id);
	public List<Genre> getAllGenres();

}
