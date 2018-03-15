package de.charaktar.ge.graphic.ui;

import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.util.ArrayList;
import java.util.List;

public class UIParent extends UIElement {

    private List<UIElement> elements;
    private int contentWidth;
    private int contentHeight;
    private int padding;
    private int itemMargin;

    public UIParent() {

        this(10, 15);
    }

    public UIParent(int padding, int itemMargin) {

        this.elements = new ArrayList<>();
        this.contentWidth = 0;
        this.contentHeight = 0;
        this.padding = padding;
        this.itemMargin = itemMargin;
    }

    public void add(UIElement toAddElement) {

        this.elements.add(toAddElement);
        if (toAddElement.getSize().getWidth() > this.contentWidth) {
            this.contentWidth = (int) toAddElement.getSize().getWidth();
        }
        this.contentHeight = 0;
        for (UIElement element : this.elements) {
            contentHeight += element.getSize().getHeight();
            if (this.elements.indexOf(element) < this.elements.size() - 1) {
                contentHeight += this.itemMargin;
            }
        }
    }

    public void setBackground(Background background) {

        this.background = background;
    }

    public void setBorder(Border border) {

        this.border = border;
    }

    @Override
    public void draw(GraphicContext graphicContext) {

        int posX = (int) ((graphicContext.getViewport().getWidth() / 2) - (this.contentWidth / 2));
        int posY = (int) ((graphicContext.getViewport().getHeight() / 2) - (this.contentHeight / 2));
        Dimension backgroundSize = new Dimension(this.contentWidth + (2 * padding), this.contentHeight + (2 * padding));
        Vector position = new Vector(posX, posY);
        graphicContext.fillRect(position, backgroundSize, this.background.getColor());
        graphicContext.strokeRect(position, backgroundSize, this.border.getColor(), this.border.getWidth());
        posX += padding;
        posY += padding;
        for (UIElement element : this.elements) {
            element.setPosition(new Vector(posX, posY));
            element.draw(graphicContext);
            posY += element.getSize().getHeight();
            if (this.elements.indexOf(element) < this.elements.size() - 1) {
                posY += itemMargin;
            }
        }

    }

}
