package controlerproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HibernateHelper;
import view.Window;

public class Controlador {
	Window view;
	HibernateHelper model;

	Controlador() {

		view = new Window();
		model = new HibernateHelper();

		launchMainWindow();

		loadCategories();

		actionSave();

	}

	private void launchMainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void actionSave() {
		view.getBtnSaveQuestion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sQuestion;
				String sCategory;
				byte id;

				sQuestion = view.gettQuestion().getText();
				sCategory = (String) view.getCategory().getSelectedItem();
				id = (byte) model.getLastQuestion().getIdQuestion();
				id++;

				System.out.println("save question:" + id + " " + sQuestion
						+ " " + sCategory);
				model.addQuestion(id, sQuestion, sCategory);

			}
		});
	}

	@SuppressWarnings("unchecked")
	private void loadCategories() {
		view.getCategory().addItem("Matematicas");
		view.getCategory().addItem("Historia");
	}

}
