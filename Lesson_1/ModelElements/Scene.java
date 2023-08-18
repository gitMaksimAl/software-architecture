package Lesson_1.ModelElements;

import java.util.List;

import Lesson_1.Staff.Type;

public class Scene {
    int id = 0;
    List<PoligonalModel> Models = null;
    List<Flash> Flashes = null;

    public Scene(List<PoligonalModel> models, List<Flash> flashes) {
        this.Models = models;
        this.Flashes = flashes;
    }

    public Type method1(Type type) {
        return type;
    }

    public Type method2(Type type1, Type type2) {
        return type1;
    }
}
