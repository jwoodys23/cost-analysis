import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class FormPanel extends JPanel {
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add New Part");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
}
