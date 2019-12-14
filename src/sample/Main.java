package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JavaFX - CodeReview4");

        ObservableList<Product> items = FXCollections.observableArrayList(
                new Product("Pfeffer",
                        "1 Stück",
                        3.49,
                        2.79,
                        "pfeffer__600x600.jpg",
                        "Schwarzer Pfeffer verleiht Ihren Speisen\n eine pikante Schärfe, besonders wenn er länger mitgekocht wird."),
                new Product("Schafmilchkäse",
                        "200 Gramm Packung",
                        2.59,
                        1.99,
                        "cheese_salakis__600x600.jpg",
                        "Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur\nbedingt damit aus, wie man eine Werbebeschreibung schreibt."),
                new Product("Vöslauer",
                        "1.5 Liter Flasche",
                        0.75,
                        0.49,
                        "voslauer__600x600.jpg",
                        "Spritziges Vöslauer Mineralwasser."),
                new Product("Zucker",
                        "500 Gramm Packung",
                        1.39,
                        0.89,
                        "zucker__600x600.jpg",
                        "Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen\nVerhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.")
        );
        ListView<Product> list = new ListView<>();
        list.getItems().addAll(items);

        Label lblProductName= new Label("Product Name: ");
        Label lblQuantity= new Label("Quantity: ");
        Label lblOldPrice= new Label("Current Price: ");
        Label lblNewPrice= new Label("New Price: ");
        Label lblDescription = new Label("Description: ");
        Label lblDescText= new Label();

        TextField txtProductName= new TextField("");
        TextField txtQuantity= new TextField("");
        TextField txtOldPrice= new TextField("");
        TextField txtNewPrice= new TextField("");

        GridPane gridPane = new GridPane();
        gridPane.add(lblProductName,0,0,2,1);
        gridPane.add(lblQuantity,0,1,2,1);
        gridPane.add(lblOldPrice,0,2,2,1);
        gridPane.add(lblNewPrice,0,3,2,1);
        gridPane.add(lblDescription,0,8,2,2);
        gridPane.add(lblDescText,0,9,16,6);
        gridPane.setPadding(new Insets(35, 35, 35, 35));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(txtProductName,3,0,2,1);
        gridPane.add(txtQuantity, 3,1,2,1);
        gridPane.add(txtOldPrice,3,2,2,1);
        gridPane.add(txtNewPrice,3,3,2,1);
        gridPane.add(list,25,0,8,8);


        HBox main= new HBox(gridPane);

        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            txtProductName.setText(newValue.getProductName());
            txtQuantity.setText(newValue.getQuantity());
            txtOldPrice.setText(Double.toString(newValue.getOldPrice()));
            txtNewPrice.setText(Double.toString(newValue.getNewPrice()));
            javafx.scene.image.Image image = new Image(newValue.getImagePath());
            ImageView img = new ImageView(image);
            img.setFitHeight(250);
            img.setFitWidth(250);
            gridPane.add(img,1,5,3,3);
            lblDescText.setText(newValue.getDescription());


        });

        Scene scene = new Scene(main, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}