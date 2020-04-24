/**
 * @(#) PrimaryController.java 0,1 2020/04/07
 *
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * A class that generates a dictionary entry which is made up of:
 * 1. a Welsh word
 * 2. it's English translation
 * 3. it's word type
 * 4. whether or not it's a practice word (by default: not a practice word)
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see Application
 */
public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Application.setRoot("secondary");
    }
}
