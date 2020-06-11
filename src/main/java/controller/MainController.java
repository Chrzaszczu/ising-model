package controller;

import controller.lattice.LatticeDrawer;
import controller.lattice.LatticeObtainer;
import controller.lattice.LatticeParametersObtainer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import model.LatticeParameters;
import model.Spin;
import model.enums.GenerationType;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

@Getter
public class MainController implements Initializable
{
    @FXML private BorderPane borderPane;
    @FXML private BorderPane latticeBorderPane;
    @FXML private TextField widthTextField;
    @FXML private TextField heightTextField;
    @FXML private TextField exchangeCouplingTextField;
    @FXML private TextField temperatureTextField;
    @FXML private TextField monteCarloCyclesTextField;

    private LatticeParameters latticeParameters;

    public void initialize(URL location, ResourceBundle resources)
    {
        drawLattice(new LinkedList<>());
    }

    @FXML
    public void close(MouseEvent event)
    {
        Platform.exit();
    }

    @FXML
    private void minimize(MouseEvent event)
    {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void lattice(MouseEvent event)
    {
        throw new IllegalArgumentException("Implement me!");
    }

    @FXML
    private void graph(MouseEvent event)
    {
        throw new IllegalArgumentException("Implement me!");
    }

    public void onApplyClicked(MouseEvent mouseEvent)
    {
        LatticeParametersObtainer obtainer = new LatticeParametersObtainer(this);
        latticeParameters = obtainer.obtainLatticeParameters();
        drawLattice(LatticeObtainer.obtainLattice(GenerationType.RANDOM, latticeParameters.getSize()));
    }

    public void onStartClicked(MouseEvent mouseEvent)
    {
        throw new IllegalArgumentException("Implement me!");
    }

    public void onStopClicked(MouseEvent mouseEvent)
    {
        throw new IllegalArgumentException("Implement me!");
    }

    public void onResetClicked(MouseEvent mouseEvent)
    {
        throw new IllegalArgumentException("Implement me!");
    }

    private void drawLattice(List<Spin> spins)
    {
        LatticeDrawer drawer = new LatticeDrawer(latticeBorderPane, spins);
        drawer.draw();
    }
}
