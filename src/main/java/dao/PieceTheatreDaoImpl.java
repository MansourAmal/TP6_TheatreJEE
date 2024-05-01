package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.theatre.PieceTheatre;
import util.JPAutil;

public class PieceTheatreDaoImpl implements IPieceTheatreDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_Theatre");

	@Override
	public PieceTheatre save(PieceTheatre pieceTheatre) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pieceTheatre);
		tx.commit();
		return pieceTheatre;

	}

	@Override
	public List<PieceTheatre> piecesTheatreParMC(String mc) {
		List<PieceTheatre> pieces = entityManager.createQuery("select pt from PieceTheatre pt where pt.NOM like :mc or pt.AUTEUR like :mc", PieceTheatre.class)
				.setParameter("mc", "%"+mc+"%")
				.getResultList();
		return pieces;
	}

	@Override
	public PieceTheatre getPieceTheatre(Long id) {
		return entityManager.find(PieceTheatre.class, id);
	}

	@Override
	public PieceTheatre updatePieceTheatre(PieceTheatre pieceTheatre) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(pieceTheatre);
		tx.commit();
		return pieceTheatre;
	}

	@Override
	public void deletePieceTheatre(Long id) {
		PieceTheatre pieceTheatre = entityManager.find(PieceTheatre.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(pieceTheatre);
		entityManager.getTransaction().commit();

	}

}