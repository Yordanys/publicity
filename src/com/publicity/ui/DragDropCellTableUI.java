package com.publicity.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableModel;

public class DragDropCellTableUI extends BasicTableUI {

    private boolean draggingRow = false;
    private int startDragPoint;
    private int dyOffset;

    protected MouseInputListener createMouseInputListener() {
        return new DragDropRowMouseInputHandler();
    }

    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);

        if (draggingRow) {
            g.setColor(table.getParent().getBackground());
            //Rectangle cellRect = table.getCellRect(table.getSelectedRow(), 0, false);
            Rectangle cellRect = table.getCellRect(table.getSelectedRow(), table.getSelectedColumn(), false);
            //g.copyArea(cellRect.x, cellRect.y, table.getWidth(), table.getRowHeight(), cellRect.x, dyOffset);
            int columnWidth = table.getColumn(table.getColumnName(table.getSelectedColumn())).getWidth();
            g.copyArea(cellRect.x, cellRect.y, columnWidth, table.getRowHeight(), 0, dyOffset);

            if (dyOffset < 0) {
                //g.fillRect(cellRect.x, cellRect.y + (table.getRowHeight() + dyOffset), table.getWidth(), (dyOffset * -1));
                g.fillRect(cellRect.x, cellRect.y + (table.getRowHeight() + dyOffset), columnWidth, (dyOffset * -1));
            } else {
                //g.fillRect(cellRect.x, cellRect.y, table.getWidth(), dyOffset);
                g.fillRect(cellRect.x, cellRect.y, columnWidth, dyOffset);
            }
        }
    }

    class DragDropRowMouseInputHandler extends MouseInputHandler {

        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            startDragPoint = (int) e.getPoint().getY();
        }

        public void mouseDragged(MouseEvent e) {
            int fromRow = table.getSelectedRow();

            if (fromRow >= 0) {
                draggingRow = true;

                int rowHeight = table.getRowHeight();
                int middleOfSelectedRow = (rowHeight * fromRow) + (rowHeight / 2);

                int toRow = -1;
                int yMousePoint = (int) e.getPoint().getY();

                if (yMousePoint < (middleOfSelectedRow - rowHeight)) {
                    // Move row up
                    toRow = fromRow - 1;
                    System.out.println("encima");
                } else if (yMousePoint > (middleOfSelectedRow + rowHeight)) {
                    // Move row down
                    toRow = fromRow + 1;
                    System.out.println("debajo");
                }

                if (toRow >= 0 && toRow < table.getRowCount()) {
                    TableModel model = table.getModel();

                    /*for (int i = 0; i < model.getColumnCount(); i++) {
                        Object fromValue = model.getValueAt(fromRow, i);
                        Object toValue = model.getValueAt(toRow, i);

                        model.setValueAt(toValue, fromRow, i);
                        model.setValueAt(fromValue, toRow, i);
                    }*/
                    //
                        int i = table.getSelectedColumn();
                        Object fromValue = model.getValueAt(fromRow, i);
                        Object toValue = model.getValueAt(toRow, i);

                        model.setValueAt(toValue, fromRow, i);
                        model.setValueAt(fromValue, toRow, i);
                    //
                    table.setRowSelectionInterval(toRow, toRow);
                    startDragPoint = yMousePoint;
                }

                dyOffset = (startDragPoint - yMousePoint) * -1;
                table.repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);

            draggingRow = false;
            table.repaint();
        }
    }
}
