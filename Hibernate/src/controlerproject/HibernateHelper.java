package controlerproject;

import java.util.HashSet;

import model.Answer;
import model.Question;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Set;

import java.util.List;

import org.hibernate.Query;

import util.SessionFactoryUtil;

public class HibernateHelper {

	private SessionFactory sesion;

	public HibernateHelper() {
		sesion = SessionFactoryUtil.getSessionFactory();
	}

	public void addQuestion(byte id, String text, String category) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Question question = new Question(id, text, category,
				new HashSet<Answer>(0));
		session.save(question);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getQuestion() {
		List<Question> questions;
		Session session = sesion.openSession();

		Query query = session.createQuery("from Question");
		questions = query.list();
		session.close();

		return questions;

	}

	public Question getLastQuestion() {
		Session session = sesion.openSession();

		Query query = session
				.createQuery("from Question order by idQuestion DESC");
		query.setMaxResults(1);
		Question last = (Question) query.uniqueResult();
		session.close();

		return last;

	}

	@SuppressWarnings("rawtypes")
	public Question getQuestion(byte id) {
		Session session = sesion.openSession();

		Question question = (Question) session.get(Question.class, (byte) id);

		if (question == null)
			return new Question();

		HashSet<Answer> answers = new HashSet<Answer>(0);
		for (Answer a : Answer.getAnswers())
			((java.util.Set<Answer>) answers).add(a);

		session.close();

		question.setAnswers((java.util.Set) answers);

		return question;
	}

	public void saveQuestion(Question question) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.save(question);
		tx.commit();
		session.close();

	}

	public void deleteAnswer(byte id) {
		Session session = sesion.openSession();
		Answer answer = (Answer) session.get(Answer.class, (byte) id);
		if (answer != null)
			session.delete(answer);
		session.close();

	}

	public void updateAnswer(Answer answer) {
		Session session = sesion.openSession();
		Answer oldAnswer = (Answer) session.get(Answer.class,
				answer.getIdAnswer());
		if (oldAnswer != null)
			session.delete(answer);
		session.close();

	}

}
