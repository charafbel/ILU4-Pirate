package project.boundary;

import javax.swing.*;
import java.awt.datatransfer.*;

// DRAG & DROP
public class TransfertHandler extends TransferHandler {

    @Override
    protected Transferable createTransferable(JComponent c) {
        return new BombComponent();
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        // On accepte uniquement le flavor BombComponent
        return support.isDataFlavorSupported(BombComponent.BOMBE_FLAVOR);
    }

    @Override
    public boolean importData(TransferSupport support) {
        if (!canImport(support)) {
            return false;
        }

        // METTRE ICI LANCER BOMBE
        System.out.println("déplacé");
        return true;
    }
}