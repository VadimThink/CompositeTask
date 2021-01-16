package edu.epam.compositetask.model;

import java.util.List;

public interface TextComponent {

    public void addChild(TextComponent textComponent);

    public void addChildren(List<TextComponent> textComponents);

    public void remove(TextComponent textComponent);

    List<TextComponent> getChildren();
}
