package Lesson_1.InMemoryModel;

import java.util.ArrayList;
import java.util.List;

import Lesson_1.ModelElements.Camera;
import Lesson_1.ModelElements.Flash;
import Lesson_1.ModelElements.PoligonalModel;
import Lesson_1.ModelElements.Scene;
import Lesson_1.ModelElements.Texture;
import Lesson_1.Staff.Point3D;

public class ModelStore implements IModelChanger{
    // public fields
    List<PoligonalModel> Models = null;
    List<Scene> Scenes = null;
    List<Flash> Flashes = null;
    List<Camera> Cameras = null;

    // private fields
    private List<IModelChangedObserver> changeObservers = null;

    public ModelStore(List<IModelChangedObserver> observers, List<Texture> textures, List<Point3D> points) throws IllegalArgumentException{
        this.Cameras = new ArrayList<>();
        this.Flashes = new ArrayList<>();
        this.Models = new ArrayList<>();
        this.changeObservers = observers;

        Cameras.add(new Camera());
        Flashes.add(new Flash());
        Models.add(new PoligonalModel(textures, points));
        Scenes.add(new Scene(Models, Flashes, Cameras));
    }

    public Scene GetScena(int n) {
        return this.Scenes.get(n);
    }

    @Override
    public void NotifyChange(IModelChanger changer) {
        // not implemented method
    }
}
