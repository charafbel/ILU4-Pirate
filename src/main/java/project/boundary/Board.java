/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author alban
 */
public class Board extends JLayeredPane {
    
    private static final Integer LAYER_BACKGROUND = 1;
    private static final Integer LAYER_CELLS = 2;
    private static final Integer LAYER_PLAYERS = 3;
    private static final Integer LAYER_NOTIFICATIONS = 4;
    
    private JPanel cellsPanel;
    private JPanel playersPanel;
    
    private ArrayList<JComponent> visualCellsList;
    
    private JPanel[] gridCellsWrapper;
    
    private static final int[] SPIRAL_MAP = {
        7, 8, 9, 10, 16, 22, 28, 27, 26, 25, 24, 18, 12, 6, 0, 1, 2, 3, 4, 5, 11, 17, 23, 29, 35, 34, 33, 32, 31, 30
    };
    
    public Board() {
        this(800, 600);
    }
    
    public Board(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.visualCellsList = new ArrayList<>();
        initializeLayers();
    }
    
    private void initializeLayers() {
        java.net.URL imgURL = getClass().getResource("/images/ile.png");
        JLabel backgroundLabel = new JLabel(new ImageIcon(imgURL));
        backgroundLabel.setBounds(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
        this.add(backgroundLabel, LAYER_BACKGROUND);
        
        cellsPanel = new JPanel();
        cellsPanel.setOpaque(false);
        cellsPanel.setLayout(new GridLayout(6, 6)); 
        cellsPanel.setBounds(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
        gridCellsWrapper = new JPanel[36];
        for (int i = 0; i < 36; i++) {
            gridCellsWrapper[i] = new JPanel(new BorderLayout());
            gridCellsWrapper[i].setOpaque(false);
            cellsPanel.add(gridCellsWrapper[i]);
        }
        this.add(cellsPanel, LAYER_CELLS);
        
        playersPanel = new JPanel(null);
        playersPanel.setOpaque(false);
        playersPanel.setBounds(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
        this.add(playersPanel, LAYER_PLAYERS);
    }
    
    public void initBoard(List<JComponent> visualCells) {
        for (JPanel wrapper : gridCellsWrapper) {
            wrapper.removeAll();
        }
        visualCellsList.clear();
        
        for (int i = 0; i < visualCells.size(); i++) {
            JComponent cell = visualCells.get(i);
            int gridPosition = SPIRAL_MAP[i];
            
            gridCellsWrapper[gridPosition].add(cell, BorderLayout.CENTER);
            visualCellsList.add(cell);
        }
        
        this.revalidate();
        this.repaint();
    }
    
    public void movePlayer(JComponent playerPawn, int cellIndex, boolean isPlayer1) {
        JComponent targetCell = visualCellsList.get(cellIndex);
        
        JPanel wrapper = (JPanel) targetCell.getParent();
        
        int x = wrapper.getX() + (wrapper.getWidth() / 2) - (playerPawn.getWidth() / 2);
        int y = wrapper.getY() + (wrapper.getHeight() / 2) - (playerPawn.getHeight() / 2);
        
        int offset = (playerPawn.getWidth() / 4);

        if (isPlayer1) {
            x = x - offset;
        } else {
            x = x + offset;
        }
        
        playerPawn.setLocation(x, y);
        
        if (playerPawn.getParent() != playersPanel) {
            playersPanel.add(playerPawn);
        }
        this.repaint();
    }
    
    public void showNotification(JComponent notificationComponent, int x, int y) {
        notificationComponent.setLocation(x, y);
        this.add(notificationComponent, LAYER_NOTIFICATIONS);
        this.moveToFront(notificationComponent);
        this.repaint();
    }
    
    public void removeNotification(JComponent notificationComponent) {
        this.remove(notificationComponent);
        this.repaint();
    }
}