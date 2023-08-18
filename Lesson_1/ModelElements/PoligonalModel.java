package Lesson_1.ModelElements;

import java.util.ArrayList;
import java.util.List;

import Lesson_1.Staff.Point3D;

/**
 * PoligonalModel
 */
public class PoligonalModel {
    //public fields
    List<Texture> Textures = null;
    List<Poligon> Poligons = null;

    public PoligonalModel(List<Texture> textures, List<Point3D> points) {
        this.Textures = textures;
        this.Poligons = new ArrayList<>();

        Poligons.add(new Poligon(points));
    }
}