package utils;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class WindowDrag
{
    private Parent root;
    private Stage stage;
    private double x;
    private double y;

    public WindowDrag(Parent root, Stage stage)
    {
        this.root = root;
        this.stage = stage;
    }

    public void enable()
    {
        setMousePressedListener();
        setMouseDraggedListener();
    }

    public void setMousePressedListener()
    {
        root.setOnMousePressed(event ->
        {
            x = event.getSceneX();
            y = event.getSceneY();
        });
    }

    public void setMouseDraggedListener()
    {
        root.setOnMouseDragged(event ->
        {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }
}
