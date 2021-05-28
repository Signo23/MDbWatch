//package mdbwatch.controller;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.MenuButton;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import mdbwatch.model.Cast;
//import mdbwatch.model.CineMusic;
//import mdbwatch.model.CineRole;
//import mdbwatch.model.Music;
//import mdbwatch.model.MusicRole;
//import mdbwatch.model.Production;
//import mdbwatch.model.Reference;
//import mdbwatch.model.StreamingService;
//import mdbwatch.model.ValutationObj;
//
//public class AdminController implements Initializable{
//    
//    @FXML TableView<Cast> tableCast, tableCast2, tableCastRole;
//    @FXML TableView<ValutationObj> tableOggetti, tableObjectMusic, tableOjectRole;
//    @FXML TableView<StreamingService> tableStreaming;
//    @FXML TableView<Production> tableProduction, tableProduction2;
//    @FXML TableView<Music> tableMusic, tableMusicRole;
//
//    @FXML TableColumn<Cast, String> idCastGen, castName, surname, birth, birthPlace, idCast2, nameCast2, surnameCast2,
//        idCastRole, nameCastRole, surnameCastRole;
//    @FXML TableColumn<ValutationObj, String> idOggetto, titolo, trama, idObjectMusic, titleObjectMusic, idObjectRole, titleObjectRole;
//    @FXML TableColumn<ValutationObj, Integer> anno;
//    @FXML TableColumn<StreamingService, String> streamingName, webSite;
//    @FXML TableColumn<Production, String> idFilmProduction, nameFilmProduction, nationFilmProduction, idFilmProduction2, nameFilmProduction2;
//    @FXML TableColumn<Music, String> idMusic, titleMusic, durationMusic, idMusicRole, titleMusicRole;
//    
//    @FXML MenuButton filmRole, musicRole;
//    
//    @FXML TextField newStreamingName, newWebSite, newCastName, newCastSurname, newCastbPlace, newCastbDay, newCastbMonth, newCastbYear,
//     newReferenceTo, newReferenceFrom, newReferenceType, newFilmRoleFilmId, newFilmRoleCastId, newMusicRoleIdCast, newMusicRoleIdMusic,
//     newFilmProductionName, newFilmProductionNation, newTitleObject, newYearObject, addDirector, addProduction, newMusicTitle,
//     newMusicDuration, addMusicObject;
//    
//    
//    @FXML TextArea newBio;
//    
//    
//    List<Cast> cast;
//    List<ValutationObj> ov;
//    List<StreamingService> str;
//    List<Reference> ref;
//    List<CineRole> fr;
//    List<MusicRole> mr;
//    List<Production> fp;
//    List<Music> music;
//    List<CineMusic> mIo;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        
//        
//        
//        this.streamingName.setCellValueFactory(new PropertyValueFactory<StreamingService, String>("name"));
//        this.webSite.setCellValueFactory(new PropertyValueFactory<StreamingService, String>("webSite"));
//        
//        this.cast = new ArrayList<>();
//        this.ov = new ArrayList<>();
//        this.str = new ArrayList<>();
//        this.ref = new ArrayList<>();
//        this.fr = new ArrayList<>();
//        this.mr = new ArrayList<>();
//        this.fp = new ArrayList<>();
//        this.music = new ArrayList<>();
//        this.mIo = new ArrayList<>();
//        
//        this.tableCast.getItems().addAll(this.cast);
//        this.tableOggetti.getItems().addAll(this.ov);
//        this.tableStreaming.getItems().addAll(this.str);
//        this.tableProduction.getItems().addAll(this.fp);
//    }
//    
//    public void openCastTab() {
//        this.castName.setCellValueFactory(new PropertyValueFactory<Cast, String>("name"));
//        this.surname.setCellValueFactory(new PropertyValueFactory<Cast, String>("surname"));
//        this.birth.setCellValueFactory(new PropertyValueFactory<Cast, String>("birth"));
//        this.idCastGen.setCellValueFactory(new PropertyValueFactory<Cast, String>("idCastGenerated"));
//        this.birthPlace.setCellValueFactory(new PropertyValueFactory<Cast, String>("birthPlace"));
//        
//        this.tableCast.getItems().clear();
//        this.tableCast.getItems().addAll(this.cast);
//    }
//    
//    public void openProductionTab() {
//        this.idFilmProduction.setCellValueFactory(new PropertyValueFactory<Production, String>("idProduction"));
//        this.nameFilmProduction.setCellValueFactory(new PropertyValueFactory<Production, String>("name"));
//        this.nationFilmProduction.setCellValueFactory(new PropertyValueFactory<Production, String>("nation"));
//        
//        this.tableProduction.getItems().clear();
//        this.tableProduction.getItems().addAll(this.fp);
//    }
//    
//    public void openObjectTab() {
//        this.idOggetto.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("idOggetto"));
//        this.titolo.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("titolo"));
//        this.trama.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("trama"));
//        this.anno.setCellValueFactory(new PropertyValueFactory<ValutationObj, Integer>("anno"));
//        
//        this.tableOggetti.getItems().clear();
//        this.tableOggetti.getItems().addAll(this.ov);
//        
//        
//        this.idFilmProduction2.setCellValueFactory(new PropertyValueFactory<Production, String>("idProduction"));
//        this.nameFilmProduction2.setCellValueFactory(new PropertyValueFactory<Production, String>("name"));
//        
//        this.tableProduction2.getItems().clear();
//        this.tableProduction2.getItems().addAll(this.fp);
//        
//        
//        this.nameCast2.setCellValueFactory(new PropertyValueFactory<Cast, String>("name"));
//        this.surnameCast2.setCellValueFactory(new PropertyValueFactory<Cast, String>("surname"));
//        this.idCast2.setCellValueFactory(new PropertyValueFactory<Cast, String>("idCastGenerated"));
//        
//        this.tableCast2.getItems().clear();
//        this.tableCast2.getItems().addAll(this.cast);
//    }
//    
//    public void openMusicTab() {
//        this.idMusic.setCellValueFactory(new PropertyValueFactory<Music, String>("idMusic"));
//        this.titleMusic.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
//        this.durationMusic.setCellValueFactory(new PropertyValueFactory<Music, String>("duration"));
//        
//        this.tableMusic.getItems().clear();
//        this.tableMusic.getItems().addAll(this.music);
//        
//        this.idObjectMusic.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("idOggetto"));
//        this.titleObjectMusic.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("titolo"));
//        
//        this.tableObjectMusic.getItems().clear();
//        this.tableObjectMusic.getItems().addAll(this.ov);
//    }
//    
//    public void openRoleTab() {
//        this.idCastRole.setCellValueFactory(new PropertyValueFactory<Cast, String>("idCastGenerated"));
//        this.nameCastRole.setCellValueFactory(new PropertyValueFactory<Cast, String>("name"));
//        this.surnameCastRole.setCellValueFactory(new PropertyValueFactory<Cast, String>("surname"));
//        this.tableCastRole.getItems().clear();
//        this.tableCastRole.getItems().addAll(this.cast);
//        
//        this.idMusicRole.setCellValueFactory(new PropertyValueFactory<Music, String>("idMusic"));
//        this.titleMusicRole.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
//        this.tableMusicRole.getItems().clear();
//        this.tableMusicRole.getItems().addAll(this.music);
//        
//        this.idObjectRole.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("idOggetto"));
//        this.idObjectRole.setCellValueFactory(new PropertyValueFactory<ValutationObj, String>("titolo"));
//        this.tableOjectRole.getItems().clear();
//        this.tableOjectRole.getItems().addAll(this.ov);
//    }
//    
//    public void openAwardTab() {
//        
//    }
//    
//    public void openStreamingTab() {
//        
//    }
//    
//    public void clickOnAddStreamingService() {
//        if(!(this.newStreamingName.getText().isBlank() || this.newWebSite.getText().isBlank())) {
//            this.str.add(new StreamingService(this.newStreamingName.getText(), this.newWebSite.getText()));
//            this.newStreamingName.clear();
//            this.newWebSite.clear();
//            this.tableStreaming.getItems().clear();
//            this.tableStreaming.getItems().addAll(this.str);
//        }
//    }
//    
//    public void clickOnAddCast() {
//        if(!(this.newCastbDay.getText().isBlank() || this.newCastbMonth.getText().isBlank() || this.newCastbPlace.getText().isBlank() || this.newCastbYear.getText().isBlank() 
//                || this.newCastName.getText().isBlank() || this.newCastSurname.getText().isBlank())) {
//            int day = Integer.parseInt(this.newCastbDay.getText());
//            int month = Integer.parseInt(this.newCastbMonth.getText());
//            int yaer = Integer.parseInt(this.newCastbYear.getText());
//            if(yaer >= 1900) {
//                if((month >= 1 && month <= 12)) {
//                    if (month == 4 || month == 6 || month == 9 || month == 11) {
//                        if(day <= 30) {
//                            this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
//                        }
//                        
//                    } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
//                        if(day <= 31) {
//                            this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
//                        }
//                    
//                    } else if (month ==2) {
//                        if (day <= 29) {
//                            this.addCast(this.newCastName.getText(), this.newCastSurname.getText(), day, month, yaer, this.newCastbPlace.getText());
//                        }
//                        
//                    }
//                }
//            }
//        }
//    }
//    
//    private void addCast(String newName, String newSurname, int newbDay, int newbMonth, int newbYear, String newbPlace) {
//        this.cast.add(new Cast("C---", newName, newSurname, newbDay, newbMonth, newbYear, newbPlace));
//        this.newCastbDay.clear();
//        this.newCastbMonth.clear();
//        this.newCastbPlace.clear();
//        this.newCastbYear.clear();
//        this.newCastName.clear();
//        this.newCastSurname.clear();
//        this.tableCast.getItems().clear();
//        this.tableCast.getItems().addAll(this.cast);
//    }
//    
//    public void clickOnAddReference() {
//        if(!(this.newReferenceFrom.getText().isBlank() || this.newReferenceTo.getText().isBlank() || this.newReferenceType.getText().isBlank())) {
//            if(this.isIdInObject(this.newReferenceFrom.getText()) && this.isIdInObject(this.newReferenceTo.getText())) {
//                this.ref.add(new Reference(this.newReferenceFrom.getText(), this.newReferenceTo.getText(), this.newReferenceType.getText()));
//                System.out.print(this.ref.toString());
//                this.newReferenceFrom.clear();
//                this.newReferenceTo.clear();
//                this.newReferenceType.clear();
//            }
//        }
//    }
//
//    private boolean isIdInObject(String id) {
//        for( final ValutationObj e : this.ov) {
//            if (e.getIdOggetto().equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public void clickonAddFilmRole() {
//        if(!(this.newFilmRoleCastId.getText().isBlank() || this.newFilmRoleFilmId.getText().isBlank() || this.filmRole.getText().isBlank())) {
//            if(this.isIdInObject(this.newFilmRoleFilmId.getText()) && this.isIdInCast(this.newFilmRoleCastId.getText())) {
//                this.fr.add(new CineRole(this.newFilmRoleFilmId.getText(), this.newFilmRoleCastId.getText(), this.filmRole.getText()));
//                this.newFilmRoleCastId.clear();
//                this.newFilmRoleFilmId.clear();
//                this.filmRole.setText("");
//            }
//        }
//    }
//    
//    private boolean isIdInCast(String text) {
//        for(final Cast c : this.cast) {
//            if (c.getIdCastGenerated().equals(text)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void clickOnFilmRoleMenuItem(ActionEvent e) {
//        this.filmRole.setText(((MenuItem)e.getSource()).getText());
//    }
//    
//    public void clickOnAddMusicRole() {
//        if(!(this.newMusicRoleIdCast.getText().isBlank() || this.newMusicRoleIdMusic.getText().isEmpty() || this.musicRole.getText().isBlank())) {
//            if(this.isIdInCast(this.newMusicRoleIdCast.getText()) && this.isIdInMusic(this.newMusicRoleIdMusic.getText())) {
//                this.mr.add(new MusicRole(this.newMusicRoleIdMusic.getText(), this.newMusicRoleIdCast.getText(), this.musicRole.getText()));
//                this.newMusicRoleIdCast.clear();
//                this.newMusicRoleIdMusic.clear();
//                this.musicRole.setText("");
//            }
//        }
//    }
//    
//    private boolean isIdInMusic(String musicId) {
//        for(final Music m : this.music) {
//            if(m.getIdMusic().equals(musicId)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void clickOnMusicRoleMenuItem(ActionEvent e) {
//        this.musicRole.setText(((MenuItem)e.getSource()).getText());
//    }
//    
//    public void clickOnAddFilmProduction() {
//        if(!(this.newFilmProductionName.getText().isBlank() && this.newFilmProductionNation.getText().isBlank())) {
//            this.fp.add(new Production ("0000", this.newFilmProductionName.getText(), this.newFilmProductionNation.getText()));
//            this.newFilmProductionName.clear();
//            this.newFilmProductionNation.clear();
//            
//            this.tableProduction.getItems().clear();
//            this.tableProduction.getItems().addAll(this.fp);
//        }
//    }
//
//    public void clickOnAddObject() {
//        if(!(this.newTitleObject.getText().isBlank() || this.newYearObject.getText().isBlank() || this.addDirector.getText().isBlank()
//                || this.addProduction.getText().isBlank() || this.newBio.getText().isBlank())) {
//            if(this.isIdInCast(this.addDirector.getText()) && this.isIdInProduction(this.addProduction.getText())
//                    && Integer.parseInt(this.newYearObject.getText()) >= 1900) {
//                this.ov.add(new ValutationObj("000", this.newTitleObject.getText(), this.newBio.getText(),
//                        Integer.parseInt(this.newYearObject.getText()), this.addDirector.getText(), this.addProduction.getText()));
//                this.tableOggetti.getItems().clear();
//                this.tableOggetti.getItems().addAll(this.ov);
//            }
//        }
//    }
//
//    private boolean isIdInProduction(String text) {
//        for(final Production f : this.fp) {
//            if(f.getIdProduction().equals(text)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public void clickOnAddMusic() {
//        if(!(this.newMusicTitle.getText().isBlank() || this.newMusicDuration.getText().isBlank() || this.addMusicObject.getText().isBlank())) {
//            if(this.isIdInObject(this.addMusicObject.getText())) {
//                this.music.add(new Music("0000", this.newMusicTitle.getText(), this.newMusicDuration.getText()));
//                this.mIo.add(new CineMusic(this.addMusicObject.getText(), this.music.get(this.music.size() - 1).getIdMusic()));
//                this.newMusicDuration.clear();
//                this.newMusicTitle.clear();
//                this.addMusicObject.clear();
//                
//                this.tableMusic.getItems().clear();
//                this.tableMusic.getItems().addAll(this.music);
//            }
//        }
//    }
//}