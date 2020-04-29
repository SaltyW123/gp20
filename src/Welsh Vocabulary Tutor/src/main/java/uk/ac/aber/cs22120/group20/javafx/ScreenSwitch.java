package uk.ac.aber.cs22120.group20.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Class that contains a sub-enumeration containing all scenes and FXML references
 * Also controls the stage, for the purpose of switching to new scenes
 *
 * @author Luke Wybar (LAW39)
 * @version 0.1
 * @see SceneEnum
 */
public class ScreenSwitch extends SharedCodeController {
    private static Scene scene;

    /**
     * This constructor is used by Application to pass control of the stage.
     * It will also display the launch scene on the stage to the user.
     * Change the Scene loaded here to change the launch screen.
     * @see Application
     * @param stage This a JavaFX stage setup by application, this will be ready to have a scene assigned.
     */
    public ScreenSwitch(Stage stage){
        scene = new Scene(fxmlLoader(SceneEnum.dictionaryScene));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method should only be used by Application.
     * This provides legacy support for the old way of screen switching by continuing to allow Application to access scene.
     * It should be removed before release.
     *
     * @Deprecated This is depreciated pending removal of all legacy screen switches
     * @see Application
     * @return This returns the currently displayed scene for purposes of screen switching
     */
    public static void setLegacyScene(String fxmlFile){
        System.err.println("Switching Scene with legacy method, you should change to ScreenSwitch");
        String fileInclExtension = fxmlFile + ".fxml";
        Parent root = null;

        try{
            root = FXMLLoader.load(new URL("file:src/main/resources/uk/ac/aber/cs22120/group20/" + fileInclExtension));

        }catch (IOException e){ // If an error occurs, print out error message on STDIO and crash gracefully
            System.err.print("Loading the FXML file ");
            System.err.print(fileInclExtension);
            System.err.println(" failed!");
            System.err.println("Using depreciated method, shame!");
            e.printStackTrace(System.err);
            System.exit(-1);
        }
        scene.setRoot(root);

    }

    /**
     * Method that is responsible for the switching between
     * JavaFX, with it taking the new scene’s name as an enum as a parameter.
     * @see SceneEnum
     * @param newScene This is a SceneEnum of the scene which is requested to switch to
     */
    public static void swap(SceneEnum newScene){
        Parent root = fxmlLoader(newScene);
        scene.setRoot(root);
    }

    /**
     * This private method responsible for loading in FXML
     * Returns a JavaFX Parent containing the loaded in FXML
     *
     * @param newScene This is a SceneEnum of the scene which is to be loaded in.
     * @return Parent containing the interpreted FXML.
     */
    private static Parent fxmlLoader(SceneEnum newScene){
        Parent root = null;
        try{
            String fxmlName = newScene.getFXML();
            root = FXMLLoader.load(new URL("file:src/main/resources/uk/ac/aber/cs22120/group20/" + fxmlName));

        }catch (IOException e){ // If an error occurs, print out error message on STDIO and crash gracefully
            System.err.print("Loading the FXML file ");
            System.err.print(newScene.getFXML());
            System.err.println("Failed!");
            System.err.println(e.toString());
            System.exit(-1);
        }
        return root;
    }

    public enum SceneEnum{
        /**
         * Enum containing each of the scenes required for use in the program along with the FXML file names.
         * This is a sub-enum of ScreenSwitch
         *
         * To add a new scene just add an enum containing the name to be used following which in parenthesis the FXML file with extension.
         * Following the spirit of those already setup.
         * This file must be located in the resources folder in the package uk.ac.aber.cs22120.group20.
         *
         * @author Luke Wybar (LAW39)
         * @version 0.1
         * @see ScreenSwitch
         */
        addWordScene("addword.fxml"),
        dictionaryScene("dictionary.fxml"),
        flashcardScene("flashcard.fxml"),
        practiceListScene("practicelist.fxml"),
        matchMeaningScene("matchthemeaning.fxml"),
        translationScene("translation.fxml"),
        ;


        private String fxmlName;

        /**
         * Constructor for giving the FXML file name to the enum.
         *
         * @param fxmlName This is the FXML file name including extension.
         */
        SceneEnum(String fxmlName) {
            this.fxmlName = fxmlName;
        }
        /**
         * This method returns the filename of the selected enum.
         *
         * @return Filename of the selected enumeration including extension.
         */
        String getFXML(){
            return this.fxmlName;
        }


    }

}
