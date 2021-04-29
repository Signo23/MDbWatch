package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import MDbWatch.Object.Cast;
import MDbWatch.Object.FilmProduction;
import MDbWatch.Object.FilmRole;
import MDbWatch.Object.Music;
import MDbWatch.Object.MusicRole;
import MDbWatch.Object.OggettoValutazione;
import MDbWatch.Object.Reference;
import MDbWatch.Object.StreamingService;

public class FXMLAdminController implements Initializable{
	
	@FXML TableView<Cast> tableCast;
	@FXML TableView<OggettoValutazione> tableOggetti;
	@FXML TableView<StreamingService> tableStreaming;

	@FXML TableColumn<Cast, String> idCastGen, castName, surname, birth, birthPlace;
	@FXML TableColumn<OggettoValutazione, String> idOggetto, titolo, trama;
	@FXML TableColumn<OggettoValutazione, Integer> anno;
	@FXML TableColumn<StreamingService, String> streamingName, webSite;
	
	@FXML MenuButton filmRole, musicRole;
	
	@FXML TextField newStreamingName, newWebSite, newCastName, newCastSurname, newCastbPlace, newCastbDay, newCastbMonth, newCastbYear,
	 newReferenceTo, newReferenceFrom, newReferenceType, newFilmRoleFilmId, newFilmRoleCastId, newMusicRoleIdCast, newMusicRoleIdMusic;
	
	
	List<Cast> cast;
	List<OggettoValutazione> ov;
	List<StreamingService> str;
	List<Reference> ref;
	List<FilmRole> fr;
	List<MusicRole> mr;
	List<FilmProduction> fp;
	List<Music> music;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.castName.setCellValueFactory(new PropertyValueFactory<Cast, String>("name"));
		this.surname.setCellValueFactory(new PropertyValueFactory<Cast, String>("surname"));
		this.birth.setCellValueFactory(new PropertyValueFactory<Cast, String>("birth"));
		this.idCastGen.setCellValueFactory(new PropertyValueFactory<Cast, String>("idCastGenerated"));
		this.birthPlace.setCellValueFactory(new PropertyValueFactory<Cast, String>("birthPlace"));
		
		this.idOggetto.setCellValueFactory(new PropertyValueFactory<OggettoValutazione, String>("idOggetto"));
		this.titolo.setCellValueFactory(new PropertyValueFactory<OggettoValutazione, String>("titolo"));
		this.trama.setCellValueFactory(new PropertyValueFactory<OggettoValutazione, String>("trama"));
		this.anno.setCellValueFactory(new PropertyValueFactory<OggettoValutazione, Integer>("anno"));
		
		this.streamingName.setCellValueFactory(new PropertyValueFactory<StreamingService, String>("name"));
		this.webSite.setCellValueFactory(new PropertyValueFactory<StreamingService, String>("webSite"));
		
		this.loadLists();
		
		this.tableCast.getItems().addAll(this.cast);
		this.tableOggetti.getItems().addAll(this.ov);
		this.tableStreaming.getItems().addAll(this.str);
	}
	
	private void loadLists() {
		this.cast = new ArrayList<>();
		this.ov = new ArrayList<>();
		this.str = new ArrayList<>();
		this.ref = new ArrayList<>();
		this.fr = new ArrayList<>();
		this.mr = new ArrayList<>();
		this.fp = new ArrayList<>();
		this.music = new ArrayList<>();
	}
	
	public void clickOnAddStreamingService() {
		if(!(this.newStreamingName.getText().isBlank() || this.newWebSite.getText().isBlank())) {
			this.str.add(new StreamingService(this.newStreamingName.getText(), this.newWebSite.getText()));
			this.newStreamingName.clear();
			this.newWebSite.clear();
			this.tableStreaming.getItems().clear();
			this.tableStreaming.getItems().addAll(this.str);
		}
	}
	
	public void clickOnAddCast() {
		if(!(this.newCastbDay.getText().isBlank() || this.newCastbMonth.getText().isBlank() || this.newCastbPlace.getText().isBlank() || this.newCastbYear.getText().isBlank() 
				|| this.newCastName.getText().isBlank() || this.newCastSurname.getText().isBlank())) {
			int day = Integer.parseInt(this.newCastbDay.getText());
			int month = Integer.parseInt(this.newCastbMonth.getText());
			int yaer = Integer.parseInt(this.newCastbYear.getText());
			if(yaer >= 1900) {
				if((month >= 1 && month <= 12)) {
					if (month == 4 || month == 6 || month == 9 || month == 11) {
						if(day <= 30) {
							this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
						}
						
					} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
						if(day <= 31) {
							this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
						}
					
					} else if (month ==2) {
						if (day <= 29) {
							this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
						}
						
					}
				}
			}
		}
	}
	
	private void addCast(String newName, String newSurname, int newbDay, int newbMonth, int newbYear, String newbPlace) {
		this.cast.add(new Cast("C---", newName, newSurname, newbDay, newbMonth, newbYear, newbPlace));
		this.newCastbDay.clear();
		this.newCastbMonth.clear();
		this.newCastbPlace.clear();
		this.newCastbYear.clear();
		this.newCastName.clear();
		this.newCastSurname.clear();
		this.tableCast.getItems().clear();
		this.tableCast.getItems().addAll(this.cast);
	}
	
	public void clickOnAddReference() {
		if(!(this.newReferenceFrom.getText().isBlank() || this.newReferenceTo.getText().isBlank() || this.newReferenceType.getText().isBlank())) {
			if(this.isIdInObject(this.newReferenceFrom.getText()) && this.isIdInObject(this.newReferenceTo.getText())) {
				this.ref.add(new Reference(this.newReferenceFrom.getText(), this.newReferenceTo.getText(), this.newReferenceType.getText()));
				System.out.print(this.ref.toString());
				this.newReferenceFrom.clear();
				this.newReferenceTo.clear();
				this.newReferenceType.clear();
			}
		}
	}

	private boolean isIdInObject(String id) {
		for( final OggettoValutazione e : this.ov) {
			if (e.getIdOggetto().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void clickonAddFilmRole() {
		if(!(this.newFilmRoleCastId.getText().isBlank() || this.newFilmRoleFilmId.getText().isBlank() || this.filmRole.getText().isBlank())) {
			if(this.isIdInObject(this.newFilmRoleFilmId.getText()) && this.isIdInCast(this.newFilmRoleCastId.getText())) {
				this.fr.add(new FilmRole(this.newFilmRoleFilmId.getText(), this.newFilmRoleCastId.getText(), this.filmRole.getText()));
				this.newFilmRoleCastId.clear();
				this.newFilmRoleFilmId.clear();
				this.filmRole.setText("");
			}
		}
	}
	
	private boolean isIdInCast(String text) {
		for(final Cast c : this.cast) {
			if (c.getIdCastGenerated().equals(text)) {
				return true;
			}
		}
		return false;
	}

	public void clickOnFilmRoleMenuItem(ActionEvent e) {
		this.filmRole.setText(((MenuItem)e.getSource()).getText());
	}
	
	public void clickOnAddMusicRole() {
		if(!(this.newMusicRoleIdCast.getText().isBlank() || this.newMusicRoleIdMusic.getText().isEmpty() || this.musicRole.getText().isBlank())) {
			if(this.isIdInCast(this.newMusicRoleIdCast.getText()) && this.isIdInMusic(this.newMusicRoleIdMusic.getText())) {
				this.mr.add(new MusicRole(this.newMusicRoleIdMusic.getText(), this.newMusicRoleIdCast.getText(), this.musicRole.getText()));
				this.newMusicRoleIdCast.clear();
				this.newMusicRoleIdMusic.clear();
				this.musicRole.setText("");
			}
		}
	}
	
	private boolean isIdInMusic(String musicId) {
		for(final Music m : this.music) {
			if(m.getIdMusic().equals(musicId)) {
				return true;
			}
		}
		return false;
	}

	public void clickOnMusicRoleMenuItem(ActionEvent e) {
		this.musicRole.setText(((MenuItem)e.getSource()).getText());
	}

}