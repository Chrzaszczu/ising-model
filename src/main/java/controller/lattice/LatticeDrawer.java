package controller.lattice;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Index;
import model.Spin;
import model.enums.State;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LatticeDrawer
{
    private static final int MAX_WIDTH = 400;

    private Map<Spin, Rectangle> rectangles;
    private BorderPane borderPane;
    private List<Spin> spins;
    private Pane pane;

    public LatticeDrawer(BorderPane borderPane, List<Spin> spins)
    {
        this.borderPane = borderPane;
        this.spins = spins;
    }

    public void draw()
    {
        preparePane();

        if(spins.isEmpty())
        {
            drawDefault();
        }

        drawLattice();
    }

    public Map<Spin, Rectangle> getRectangles()
    {
        return rectangles;
    }

    private void preparePane()
    {
        pane = new Pane();
        pane.setMaxWidth(MAX_WIDTH);
        pane.setMaxHeight(MAX_WIDTH);
    }

    private void drawLattice()
    {
        rectangles = new LinkedHashMap<>();
        final double spinWidth = (MAX_WIDTH / Math.sqrt(spins.size()));

        spins.forEach(spin -> prepareSpin(spin, spinWidth));
        borderPane.setCenter(pane);
    }

    private void prepareSpin(Spin spin, double spinWidth)
    {
        Rectangle rectangle = prepareRectangle(spin, spinWidth);
        pane.getChildren().add(rectangle);
        rectangles.put(spin, rectangle);
    }

    private Rectangle prepareRectangle(Spin spin, double spinWidth)
    {
        Index spinIndex = spin.getIndex();
        Rectangle rectangle = new Rectangle(
                spinIndex.getI() * spinWidth,
                spinIndex.getJ() * spinWidth,
                Math.ceil(spinWidth),
                Math.ceil(spinWidth));
        setRectangleColor(rectangle, spin);
        return rectangle;
    }

    private void setRectangleColor(Rectangle rectangle, Spin spin)
    {
        if(spin.getState() == State.UP)
        {
            rectangle.setFill(Color.BLUE);
        }
        else
        {
            rectangle.setFill(Color.RED);
        }
    }

    private void drawDefault()
    {
        Rectangle rectangle = new Rectangle(0, 0, MAX_WIDTH, MAX_WIDTH);
        rectangle.setFill(Color.BLUE);

        pane.getChildren().add(rectangle);
        borderPane.setCenter(pane);
    }
}
