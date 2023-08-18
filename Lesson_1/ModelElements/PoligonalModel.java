package Lesson_1.ModelElements;

import java.util.ArrayList;
import java.util.List;

/**
 * PoligonalModel
 */
public class PoligonalModel {

    List<Texture> Textures = null;
    List<Poligon> Poligons = null;

    public PoligonalModel(List<Texture> textures) {
        this.Textures = textures;
        this.Poligons = new ArrayList<>();
    }
}