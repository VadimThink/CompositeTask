package edu.epam.compositetask.model;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private final List<TextComponent> textComponents = new ArrayList<>();

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<>(textComponents);
    }

    @Override
    public void addChild(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void addChildren(List<TextComponent> textComponents) {
        this.textComponents.addAll(textComponents);
    }

    @Override
    public void remove(TextComponent textComponent){
        textComponents.remove(textComponent);
    }

    @Override
    public String toString() {
        return "TextComposite{" + textComponents + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextComposite)) {
            return false;
        }

        TextComposite that = (TextComposite) o;

        return textComponents.equals(that.textComponents);
    }

    @Override
    public int hashCode() {
        return textComponents.hashCode();
    }
}
