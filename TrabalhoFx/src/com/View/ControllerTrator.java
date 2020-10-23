package com.View;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import com.DAO.TratorDAO;

import com.Entity.Trator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ControllerTrator extends Application implements Initializable {
	TratorDAO dao = new TratorDAO();
	
	List<Trator> listaTrators = new ArrayList<Trator>();

	@FXML
	private TextField textFieldModelo;

	@FXML
	private TextField textFieldValor;

	@FXML
	private TextField textFieldMarca;

	@FXML
	private TextField textFieldAno;

	@FXML
	private TextArea textAreaTrators;

	@FXML
	private TextField textField_ID;
	@FXML
	private Label labelTextId;

	@FXML
	private Label labelTextIdInserted;
	@FXML
	private Label qtd;

	@FXML
	private Label labelQtd;
	

	@FXML
	void ExcluirTrator(ActionEvent event) {
    	String busca= textField_ID.getText();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar Produto");
    	alert.setHeaderText("Deletar");
    	alert.setContentText("Tem certeza que deseja deletar?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
            dao.Deletar(busca, listaTrators);
        	limpaCampos();
        	listarTrators();
    	}
    	
	}

	@FXML
	void PesquisarTratorID(ActionEvent event) {
		String buscar= textField_ID.getText();
		Trator trator = null;
    	if (!buscar.equals("")) {
			try {
			trator = new TratorDAO().findByModelo(buscar, listaTrators);
			} catch (Exception e) {
			}
			if (trator != null) { 
				labelTextId.setVisible(true);
				labelTextIdInserted.setVisible(true);
				labelTextIdInserted.setText(trator.getModelo());
				textFieldMarca.setText(trator.getMarca());
				textFieldModelo.setText(trator.getModelo());
				textFieldAno.setText(trator.getAno() + "");
				textFieldValor.setText(trator.getValor() + "");
			}
		}

	}

	@FXML
	void alterarTrators(ActionEvent event) {
		Trator trator = pegaTrators();
    	String busca = textField_ID.getText();
    	textFieldMarca.setText(trator.getMarca());
		textFieldModelo.setText(trator.getModelo());
		textFieldAno.setText(trator.getAno() +"") ;
		textFieldValor.setText(trator.getValor() +"");
    	dao.Alterar(trator,busca, listaTrators );
    	listarTrators();
	}

	private void limpaCampos() {
		textFieldModelo.clear();
		textFieldMarca.clear();
		textFieldAno.clear();
		textFieldValor.clear();
		textFieldMarca.requestFocus();
		labelTextId.setVisible(false);
		labelTextIdInserted.setVisible(false);
		labelTextIdInserted.setText("");

	}

	private Trator pegaTrators() {
		return new Trator(textFieldMarca.getText(), textFieldModelo.getText(), Integer.valueOf(textFieldAno.getText()),
				Float.valueOf(textFieldValor.getText()));
	}

	public void execute() {
		launch();
	}

	@FXML
	void inserirTrators(ActionEvent event) {
		Trator trator= pegaTrators();
    	listaTrators.add(trator);
		limpaCampos();
		listarTrators();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listarTrators();
	}

	private void listarTrators() {

		textAreaTrators.clear();
		listaTrators.forEach(trator -> {
			textAreaTrators.appendText(trator.toString() + "\n");
		});

	}
	   @FXML
	    void Sair(ActionEvent event) {
		  	Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Sair da Aplicação");
	    	alert.setContentText("Saindo da aplicação !!!");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){           
	    		System.exit(0);
	    	}
	    }

	@Override
	public void start(Stage stage) {
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Trator.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
